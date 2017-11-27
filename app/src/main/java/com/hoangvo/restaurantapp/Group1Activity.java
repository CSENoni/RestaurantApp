package com.hoangvo.restaurantapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Group1Activity extends AppCompatActivity {

    // Group 1
    EditText gName;

    EditText member1;
    EditText member2;
    EditText member3;
    EditText event1;
    EditText event2;
    TextView displayGroupInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group1);

        SharedPreferences group1SharedPref = getSharedPreferences("group1Info", Context.MODE_PRIVATE);
        String  g1name = group1SharedPref.getString("group1Name", "");

        gName = (EditText) findViewById(R.id.editTextGroup1Name);
        //member = (EditText) findViewById();
        //event = (EditText) findViewById();
        //displayGroupInfo = (TextView) findViewById(R.id.)

        EditText editText = gName;
        editText.setText(group1SharedPref.getString("group1Name", ""));

        //TextView groupName = (TextView) findViewById(R.id.editTextGroup1Name);
        //groupName.setText(firstGroup.name);
    }

    public void saveInfo(View view){
        SharedPreferences groupSharedPref = getSharedPreferences("group1Info", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = groupSharedPref.edit();
        editor.putString("group1Name", gName.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }
}
