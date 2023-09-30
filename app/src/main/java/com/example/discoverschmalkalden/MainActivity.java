package com.example.discoverschmalkalden;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
//import com.google.maps.android.SphericalUtil;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton hikingButton = findViewById(R.id.hikingButton);
        ImageButton eventsButton = findViewById(R.id.eventButton);
        ImageButton foodButton = findViewById(R.id.foodButton);

        LatLng sydney = new LatLng(-34, 151);
        LatLng Brisbane = new LatLng(-27.470125, 153.021072);
//        Double distance;
//        distance = SphericalUtil.computeDistanceBetween(sydney, Brisbane);
//        Toast.makeText(this, "Distance between Sydney and Brisbane is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();

        hikingButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PageOfTypeActivity.class);
            intent.putExtra("TYPE",1);
            startActivity(intent);
        });

        eventsButton.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, PageOfTypeActivity.class);
            intent2.putExtra("TYPE",2);
            startActivity(intent2);
        });

        foodButton.setOnClickListener(view -> {
            Intent intent3 = new Intent(MainActivity.this, PageOfTypeActivity.class);
            intent3.putExtra("TYPE",3);
            startActivity(intent3);
        });
    }

}