package com.example.android.tourguide;

public class Place {

    private String name;
    private String description;
    private int ImageResourceId;

    public Place(String name, String description, int ImageResourceId) {
        this.name = name;
        this.description = description;
        this.ImageResourceId = ImageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }
}
