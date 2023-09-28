package com.example.discoverschmalkalden;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDescriptionActivity extends AppCompatActivity implements OnMapReadyCallback {

    LatLng PlaceLatLng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_description);

        ImageView placePicture = findViewById(R.id.place_picture_detailed);
        TextView placeName = findViewById(R.id.place_name_detailed);
        TextView placeDescription = findViewById(R.id.place_description_detailed);
        LatLng placeCoordinates;

        CustomData cd = (CustomData) getIntent().getExtras().getSerializable(PageOfTypeActivity.OBJECT);

        placeName.setText("" + cd.getPlaceName());
        placeDescription.setText("" + getString(cd.getPlaceDescription()));
        placePicture.setImageResource(cd.getPlacePicture());

        // Get a handle to the fragment and register the callback.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    // Get a handle to the GoogleMap object and display marker.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        PlaceLatLng = new LatLng(50.72695191940359, 10.395809851823534);
        googleMap.addMarker(new MarkerOptions().position(PlaceLatLng).title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PlaceLatLng, 15));
    }
}