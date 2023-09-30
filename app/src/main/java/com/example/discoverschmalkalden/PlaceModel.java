package com.example.discoverschmalkalden;

import com.google.android.gms.maps.model.LatLng;

enum PlaceType {
    HIKING, EVENT, FOOD
}
public class PlaceModel {
    private String place_name;
    private PlaceType type;
    private int place_description;
    private double place_lat;
    private double place_lng;
    private int place_distance;
    private int place_image;

    // Constructor
    public PlaceModel(String place_name, PlaceType type, int place_description, double place_lat, double place_lng, int place_distance, int place_image) {
        this.place_name = place_name;
        this.type = type;
        this.place_distance = place_distance;
        this.place_description = place_description;
        this.place_lat = place_lat;
        this.place_lng = place_lng;
        this.place_image = place_image;
    }

    // Getter and Setter
    public String getPlace_name() {
        return place_name;
    }

    public PlaceType getType() {
        return type;
    }

    public int getPlace_description() {
        return place_description;
    }

    public double getPlace_lat() {
        return place_lat;
    }

    public double getPlace_lng() {
        return place_lng;
    }

    public int getPlace_image() {
        return place_image;
    }

    public int getPlace_distance() {
        return place_distance;
    }

}
