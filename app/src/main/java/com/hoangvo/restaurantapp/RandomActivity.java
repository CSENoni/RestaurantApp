package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;


public class RandomActivity extends AppCompatActivity {

    Globals g;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.titlemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                g = (Globals)getApplication();
                for(int i = 0; i < g.res.length; i++)
                    g.res[i].ignore = false;
                Intent logoutIntent = new Intent(RandomActivity.this, MainActivity.class);
                RandomActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                g = (Globals)getApplication();
                for(int i = 0; i < g.res.length; i++)
                    g.res[i].ignore = false;
                Intent optionIntent = new Intent(RandomActivity.this, OptionActivity.class);
                RandomActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                g = (Globals)getApplication();
                for(int i = 0; i < g.res.length; i++)
                    g.res[i].ignore = false;
                Intent listIntent = new Intent(RandomActivity.this, ListActivity.class);
                RandomActivity.this.startActivity(listIntent);
                return true;
            case R.id.nearby:
                g = (Globals)getApplication();
                for(int i = 0; i < g.res.length; i++)
                    g.res[i].ignore = false;
                Intent nearbyIntent = new Intent(RandomActivity.this, NearbyActivity.class);
                RandomActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                g = (Globals)getApplication();
                for(int i = 0; i < g.res.length; i++)
                    g.res[i].ignore = false;
                Intent groupsIntent = new Intent(RandomActivity.this, GroupActivity.class);
                RandomActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                g = (Globals)getApplication();
                for(int i = 0; i < g.res.length; i++)
                    g.res[i].ignore = false;
                Intent helpIntent = new Intent(RandomActivity.this, HelpActivity.class);
                RandomActivity.this.startActivity(helpIntent);
                return true;
            default:
                g = (Globals)getApplication();
                for(int i = 0; i < g.res.length; i++)
                    g.res[i].ignore = false;
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        g = (Globals)getApplication();
        Button reroll = (Button) findViewById(R.id.next);
        Button accept = (Button) findViewById(R.id.accept);


        int max = g.res.length;
        int position = new Random().nextInt(max);

        loop:
        while(g.res[position].ignore) {
            //Check if there is still a valid restaurant.
            for(int i = 0; i < g.res.length; i++){
                if(!g.res[i].ignore)
                    break;
                if(i == g.res.length-1) {
                    Toast.makeText(getApplicationContext(),"There are no more restaurants to choose from.",Toast.LENGTH_LONG).show();
                    break loop;
                }
            }
            position = new Random().nextInt(g.res.length);
        }

        final Restaurant selected = g.res[position];

        EditText ed1, ed2, ed3, ed4, ed5;
        RatingBar rb = (RatingBar) findViewById(R.id.rating);
        ed1 = (EditText) findViewById(R.id.nameText);
        ed2 = (EditText) findViewById(R.id.addressText);
        ed3 = (EditText) findViewById(R.id.hoursText);
        ed4 = (EditText) findViewById(R.id.priceText);
        ed5 = (EditText) findViewById(R.id.tagsText);
        ed1.setText(selected.res_name);
        ed2.setText(selected.location);
        String hoursTemp = selected.open + " - " + selected.close;
        ed3.setText(hoursTemp);
        String priceTemp = "$" + selected.low + " - $" + selected.high;
        ed4.setText(priceTemp);
        ed5.setText(selected.tags);
        rb.setRating(selected.rating);

        reroll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selected.ignore = true;
                Intent rerollIntent = new Intent(RandomActivity.this, RandomActivity.class);
                RandomActivity.this.startActivity(rerollIntent);
            }
        });

        accept.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for(int i = 0; i < g.res.length; i++)
                    g.res[i].ignore = false;
                Intent acceptIntent = new Intent(RandomActivity.this, RandomActivity.class);
                RandomActivity.this.startActivity(acceptIntent);
            }
        });

    }
}
