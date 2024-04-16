package com.example.planetsapp;

public class Planet {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoons() {
        return moons;
    }

    public void setMoons(String moons) {
        this.moons = moons;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Planet(String name, String moons, int imageID) {
        this.name = name;
        this.moons = moons;
        this.imageID = imageID;
    }

    private String moons;
    private int imageID;

}
