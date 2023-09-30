package com.example.discoverschmalkalden;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class CustomData implements Serializable {
    private String placeName;
    private int placeDescription;
    private double placeLat;
    private double placeLng;
    private int placePicture;


    public CustomData(String placeName, int placeDescription, int placePicture, double placeLat, double placeLng) {
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.placePicture = placePicture;
        this.placeLat = placeLat;
        this.placeLng = placeLng;
    }

    public double getPlaceLat() {
        return placeLat;
    }

    public double getPlaceLng() {
        return placeLng;
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getPlaceDescription() {
        return placeDescription;
    }

    public int getPlacePicture() {
        return placePicture;
    }
}
