package com.hoangvo.restaurantapp;

import android.app.Application;

import org.json.JSONObject;

import java.util.ArrayList;

public class Globals extends Application {
    public boolean already = false;
    public Restaurant[] res = new Restaurant[10];
    public ArrayList<JSONObject> nRes = new ArrayList<JSONObject>();
    public Groups[] gro = new Groups[5];
    public GroupEvent[] groEvt = new GroupEvent[5];
}
