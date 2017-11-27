package com.hoangvo.restaurantapp;


public class Restaurant {
    // restaurant name
    String res_name;
    // restaurant location
    String location;
    // flag set when search criteria doesn't match the restaurants details
    boolean ignore;
    // Hours
    String open;
    String close;
    // continuous string of tags. Tags are separated with a "\n"
    String tags;
    // rating (1-5)
    float rating;
    // price range
    String low;
    String high;

    public Restaurant(){
        res_name = "";
        location = "";
        ignore = false;
        open = "";
        close = "";
        tags = "";
        rating = 3;
        low = "0";
        high = "100";
    }

}
