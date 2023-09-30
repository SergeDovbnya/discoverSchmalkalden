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
    private LatLng placeLatLng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_description);

        ImageView placePicture = findViewById(R.id.place_picture_detailed);
        TextView placeName = findViewById(R.id.place_name_detailed);
        TextView placeDescription = findViewById(R.id.place_description_detailed);

        CustomData cd = (CustomData) getIntent().getExtras().getSerializable(PageOfTypeActivity.OBJECT);

        placeName.setText("" + cd.getPlaceName());
        placeDescription.setText("" + getString(cd.getPlaceDescription()));
        placePicture.setImageResource(cd.getPlacePicture());
        placeLatLng = new LatLng(cd.getPlaceLat(), cd.getPlaceLng());

        // Get a handle to the fragment and register the callback.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    // Get a handle to the GoogleMap object and display marker.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(placeLatLng).title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLatLng, 15));
    }
}