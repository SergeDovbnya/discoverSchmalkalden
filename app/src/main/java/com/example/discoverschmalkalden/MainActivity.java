package com.example.discoverschmalkalden;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.maps.android.SphericalUtil;

import java.util.List;
import java.util.Locale;
//import com.google.maps.android.SphericalUtil;

public class MainActivity extends AppCompatActivity {

//    private final int FINE_PERMISSION_CODE = 1;
    FusedLocationProviderClient fusedLocationProviderClient;
    TextView dashboard_text1;
//    Location currentLocation;
    LatLng currentLocationLatLng;
    private final static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton hikingButton = findViewById(R.id.hikingButton);
        ImageButton eventsButton = findViewById(R.id.eventButton);
        ImageButton foodButton = findViewById(R.id.foodButton);

        hikingButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PageOfTypeActivity.class);
            intent.putExtra("TYPE", 1);
            startActivity(intent);
        });

        eventsButton.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, PageOfTypeActivity.class);
            intent2.putExtra("TYPE", 2);
            startActivity(intent2);
        });

        foodButton.setOnClickListener(view -> {
            Intent intent3 = new Intent(MainActivity.this, PageOfTypeActivity.class);
            intent3.putExtra("TYPE", 3);
            startActivity(intent3);
        });

        dashboard_text1 = findViewById(R.id.textAwayRhoen);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();

//        currentLocationLatLng = new LatLng(50.79946546793923, 10.417242896798642);
        LatLng locationRhoenblick = new LatLng(50.72695191940359, 10.395809851823534);

        if (currentLocationLatLng != null) {
            Double distance = SphericalUtil.computeDistanceBetween(currentLocationLatLng, locationRhoenblick);
            Toast.makeText(this, "Distance between you and Rhoenblick is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();
            dashboard_text1.setText(String.format("%.1f", distance / 1000) + " km");
        } else {
//            getLastLocation();
        }

    }

    private void getLastLocation() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_PERMISSION_CODE);
//            return;
//        }
//        Task<Location> task = fusedLocationProviderClient.getLastLocation();
//        task.addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//                if (location != null) {
//                    currentLocation = location;
//                    currentLocationLatLng = new LatLng(location.getLatitude(),location.getLongitude());
//                } else {
//                    askPermission();
//                }
//            }
//        });


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
//                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                        currentLocationLatLng = new LatLng(location.getLatitude(),location.getLongitude());
                    }
                }
            });
        } else {
            askPermission();
        }
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==REQUEST_CODE) {
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            } else {
                Toast.makeText(this, "Permission is required", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}