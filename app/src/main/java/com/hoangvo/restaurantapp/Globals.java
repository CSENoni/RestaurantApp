package com.hoangvo.restaurantapp;

import android.app.Application;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

public class Globals extends Application {
    public boolean already = false;
    public int limit = 0;
    public Restaurant[] res = new Restaurant[10];
    public ArrayList<JSONObject> nRes = new ArrayList<JSONObject>();
    public Groups[] gro = new Groups[5];
    public GroupEvent[] groEvt = new GroupEvent[5];

    public void addRes(Restaurant r){
        if (limit == res.length){
            Toast.makeText(getApplicationContext(),"Cannot add anymore restaurants, list is full.",Toast.LENGTH_LONG).show();
        }
        else{
            res[limit] = r;
            limit++;
        }
    }

    public void delRes(int index){
        if (limit == 0){
            Toast.makeText(getApplicationContext(),"Cannot delete anymore restaurants, list is empty.",Toast.LENGTH_LONG).show();
        }
        else {
            Restaurant temp;
            temp = res[limit-1];
            res[index] = temp;
            res[limit-1] = new Restaurant();
            limit--;
            for(int i = 0; i < res.length; i++){
                res[i].position = i;
            }
        }
    }
}
