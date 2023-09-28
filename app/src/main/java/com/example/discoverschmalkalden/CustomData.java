package com.example.discoverschmalkalden;

import java.io.Serializable;

public class CustomData implements Serializable {
    private String placeName;
    private int placeDescription;

    private int placePicture;


    public CustomData(String placeName, int placeDescription, int placePicture) {
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.placePicture = placePicture;
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
