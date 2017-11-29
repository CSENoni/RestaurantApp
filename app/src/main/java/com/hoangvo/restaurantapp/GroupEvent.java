package com.hoangvo.restaurantapp;

/**
 * Created by Chalstroms on 11/25/2017.
 */

public class GroupEvent {
    String name;
    String area;
    String date;
    String time;
    int priceHigh;
    int priceLow;
    String tags;

    public GroupEvent(String name, String area, String date, String time, Integer priceHigh, Integer priceLow, String tags) {
        this.name = name;
        this.area = area;
        this.date = date;
        this.time = time;
        this.priceHigh = priceHigh;
        this.priceLow = priceLow;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Integer getPriceHigh() {
        return priceHigh;
    }

    public Integer getPriceLow() {
        return priceLow;
    }

    public String getTags() {
        return tags;
    }
}
