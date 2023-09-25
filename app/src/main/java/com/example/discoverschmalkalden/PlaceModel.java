package com.example.discoverschmalkalden;

public class PlaceModel {

    private int place_id;
    private String place_name;
    private String place_description;
    private double place_lat;
    private double place_lng;
    private int place_distance;
    private int place_image;

    // Constructor
    public PlaceModel(String place_name, int place_distance, int place_image) {
        this.place_name = place_name;
        this.place_distance = place_distance;
        //this.place_description = place_description;
        //this.place_lat = place_lat;
        //this.place_lng = place_lng;
        this.place_image = place_image;
    }

    // Getter and Setter
    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_description() {
        return place_description;
    }

    public void setPlace_description(String place_description) {
        this.place_name = place_description;
    }

    public double getPlace_lat() {
        return place_lat;
    }

    public void setPlace_lat(int place_lat) {
        this.place_lat = place_lat;
    }

    public double getPlace_lng() {
        return place_lng;
    }

    public void setPlace_lng(int place_lng) {
        this.place_lng = place_lng;
    }

    public int getPlace_image() {
        return place_image;
    }

    public void setPlace_image(int place_image) {
        this.place_image = place_image;
    }

    public int getPlace_distance() {
        return place_distance;
    }

    public void setPlace_distance(int place_distance) {
        this.place_distance = place_distance;
    }
}
