package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        Globals g = (Globals)getApplication();

        Button mylist = (Button) findViewById(R.id.btView);
        Button random = (Button) findViewById(R.id.btRandom);


        mylist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(OptionActivity.this, ListActivity.class);
                OptionActivity.this.startActivity(listIntent);
            }
        });

        random.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent randomIntent = new Intent(OptionActivity.this, RandomActivity.class);
                OptionActivity.this.startActivity(randomIntent);
            }
        });
    }
}
