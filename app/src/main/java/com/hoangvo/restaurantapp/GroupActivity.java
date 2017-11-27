package com.hoangvo.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GroupActivity extends AppCompatActivity {
/*
    // Group 1
    SharedPreferences group1SharedPref = getSharedPreferences("group1Info", Context.MODE_PRIVATE);
    String  g1name = group1SharedPref.getString("group1Name", "");
    // Group 2
    SharedPreferences group2SharedPref = getSharedPreferences("group2Info", Context.MODE_PRIVATE);
    String  g2name = group2SharedPref.getString("group2Name", "");
    // Group 3
    SharedPreferences group3SharedPref = getSharedPreferences("group3Info", Context.MODE_PRIVATE);
    String  g3name = group3SharedPref.getString("group3Name", "");
*/
    // Group 4
    //SharedPreferences group4SharedPref = getSharedPreferences("group4Info", Context.MODE_PRIVATE);
    //String  g4name = group4SharedPref.getString("group4Name", "");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        // Group 1
        SharedPreferences group1SharedPref = getSharedPreferences("group1Info", Context.MODE_PRIVATE);
        String  g1name = group1SharedPref.getString("group1Name", "");
        // Group 2
        SharedPreferences group2SharedPref = getSharedPreferences("group2Info", Context.MODE_PRIVATE);
        String  g2name = group2SharedPref.getString("group2Name", "");
        // Group 3
        SharedPreferences group3SharedPref = getSharedPreferences("group3Info", Context.MODE_PRIVATE);
        String  g3name = group3SharedPref.getString("group3Name", "");

        //
        final ListView listView = (ListView)findViewById(R.id.groupList);
        // Create a string array of group names
        final String[] gList = new String[]{"Group: "+ g1name,"Group: "+ g2name,"Group: "+ g3name};
        // Create an adapter to show this array like a list of items
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, gList);
        // Put this adapter to listview
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                if(i == 0){
                    Intent myintent = new Intent(view.getContext(), Group1Activity.class);
                    startActivityForResult(myintent, 0);
                }
                if(i == 1){
                    Intent myintent = new Intent(view.getContext(), Group2Activity.class);
                    startActivityForResult(myintent, 1);
                }
                if(i == 2){
                    Intent myintent = new Intent(view.getContext(), Group3Activity.class);
                    startActivityForResult(myintent, 2);
                }
                /*
                if(position == 3){
                    Intent myintent = new Intent(view.getContext(), Group4Activity.class);
                    startActivityForResult(myintent, 3);
                }
                */
            }
        });


    }

}
