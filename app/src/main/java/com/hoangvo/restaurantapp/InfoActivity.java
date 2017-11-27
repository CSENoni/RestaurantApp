package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.view.Menu;
import android.view.MenuItem;


public class InfoActivity extends AppCompatActivity {

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
                Intent logoutIntent = new Intent(InfoActivity.this, MainActivity.class);
                InfoActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(InfoActivity.this, OptionActivity.class);
                InfoActivity.this.startActivity(optionIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(InfoActivity.this, RandomActivity.class);
                InfoActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(InfoActivity.this, NearbyActivity.class);
                InfoActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                Intent groupsIntent = new Intent(InfoActivity.this, GroupsActivity.class);
                InfoActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                Intent helpIntent = new Intent(InfoActivity.this, HelpActivity.class);
                InfoActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Globals g = (Globals)getApplication();
        Bundle bundle = getIntent().getExtras();
        long position = bundle.getLong("pos");
        Restaurant selected = g.res[(int)position];

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
    }
}
