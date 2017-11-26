package com.hoangvo.restaurantapp;


public class Restaurant {
    // restaurant name
    String res_name;
    // restaurant location
    String location;
    // flag set when search criteria doesn't match the restaurants details
    boolean ignore;
    // continuous string of tags. Tags are separated with a "."
    String tags;
    // rating (1-5)
    int rating;
    // price range
    double low;
    double high;

    public Restaurant(){
        res_name = "";
        location = "";
        ignore = false;
        tags = "";
        rating = 5;
        low = 0;
        high = 100;
    }

}
