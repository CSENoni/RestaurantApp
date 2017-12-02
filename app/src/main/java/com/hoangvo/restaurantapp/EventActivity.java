package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class EventActivity extends AppCompatActivity {

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
                Intent logoutIntent = new Intent(EventActivity.this, MainActivity.class);
                EventActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(EventActivity.this, OptionActivity.class);
                EventActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(EventActivity.this, ListActivity.class);
                EventActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(EventActivity.this, RandomActivity.class);
                EventActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(EventActivity.this, NearbyActivity.class);
                EventActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                Intent groupsIntent = new Intent(EventActivity.this, GroupActivity.class);
                EventActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                Intent helpIntent = new Intent(EventActivity.this, HelpActivity.class);
                EventActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Globals g = (Globals)getApplication();
        Bundle bundle = getIntent().getExtras();
        long i = bundle.getLong("gID");
        GroupEvent clickedOn = g.groEvt[(int)i];

        EditText name, area, date_time,  priceHigh, priceLow, tags;

        // ed1 = (EditText) findViewById(R.id.nameText);
        name = (EditText) findViewById(R.id.editText2);
        area = (EditText) findViewById(R.id.editText3);
        date_time = (EditText) findViewById(R.id.editText4);
        priceHigh = (EditText) findViewById(R.id.editText5);
        priceLow = (EditText) findViewById(R.id.editText6);

        name.setText( clickedOn.name);
        area.setText(clickedOn.area);
        date_time.setText(clickedOn.date);
        priceHigh.setText(clickedOn.priceHigh);
        priceLow.setText(clickedOn.priceHigh);






    }
}