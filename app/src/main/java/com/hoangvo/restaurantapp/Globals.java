package com.hoangvo.restaurantapp;

import android.app.Application;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

public class Globals extends Application {
    public boolean already = false;
    public int limit = 0;
    public Restaurant[] res = new Restaurant[20];
    public ArrayList<JSONObject> nRes = new ArrayList<JSONObject>();
    public Groups[] gro = new Groups[5];
    public GroupEvent[] groEvt = new GroupEvent[5];

    public boolean addRes(Restaurant r){
        if (limit == res.length){
            Toast.makeText(getApplicationContext(),"Cannot add anymore restaurants, list is full.",Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            res[limit] = r;
            limit++;
            return true;
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

    // This is only for new added restaurant on a fly
    public boolean isRestaurant(String name){
        for(int i = 0; i < res.length; i++){
            if(res[i].res_name.equals(name)){
                return true;
            }
        }
        return false;
    }
}
