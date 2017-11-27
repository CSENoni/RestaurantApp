package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RandomActivity extends AppCompatActivity {
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
                Intent logoutIntent = new Intent(RandomActivity.this, MainActivity.class);
                RandomActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(RandomActivity.this, OptionActivity.class);
                RandomActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(RandomActivity.this, ListActivity.class);
                RandomActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(RandomActivity.this, RandomActivity.class);
                RandomActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(RandomActivity.this, NearbyActivity.class);
                RandomActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                 Intent groupsIntent = new Intent(RandomActivity.this, GroupActivity.class);
                 RandomActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                 Intent helpIntent = new Intent(RandomActivity.this, HelpActivity.class);
                 RandomActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
    }
}
