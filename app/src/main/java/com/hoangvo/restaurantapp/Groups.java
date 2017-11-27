package com.hoangvo.restaurantapp;

/**
 * Created by Chalstroms on 11/25/2017.
 */

public class Groups {
    String name;
    String members;
    String events;

    public Groups(String name, String members, String events) {
        this.name = name;
        this.members = members;
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public String getMembers() {
        return members;
    }

    public String getEvents() {
        return events;
    }
}
