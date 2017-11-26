package com.hoangvo.restaurantapp;

public class Globals {
    private static Globals instance;
    public Restaurant res;

    private Globals(){}

    public static synchronized Globals getInstance(){
        if(instance == null){
            instance = new Globals();
        }
        return instance;
    }
}
