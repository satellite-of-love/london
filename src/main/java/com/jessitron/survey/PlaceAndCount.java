package com.jessitron.survey;

public class PlaceAndCount {

    public PlaceAndCount() {}

    private int place;
    private int count;

    public PlaceAndCount(int place, int count) {
        this.place = place;
        this.count = count;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
