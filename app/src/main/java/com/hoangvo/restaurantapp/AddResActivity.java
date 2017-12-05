package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Button;


public class AddResActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5;
    long position;
    Restaurant selected;
    RatingBar rb;
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
                Intent logoutIntent = new Intent(AddResActivity.this, MainActivity.class);
                AddResActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(AddResActivity.this, OptionActivity.class);
                AddResActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(AddResActivity.this, ListActivity.class);
                AddResActivity.this.startActivity(listIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(AddResActivity.this, NearbyActivity.class);
                AddResActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                Intent groupsIntent = new Intent(AddResActivity.this, GroupActivity.class);
                AddResActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                Intent helpIntent = new Intent(AddResActivity.this, HelpActivity.class);
                AddResActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editres);

        g = (Globals)getApplication();
        selected = new Restaurant();

        rb = (RatingBar) findViewById(R.id.rating);
        Button save = (Button) findViewById(R.id.save);
        ed1 = (EditText) findViewById(R.id.nameText);
        ed2 = (EditText) findViewById(R.id.addressText);
        ed3 = (EditText) findViewById(R.id.hoursText);
        ed4 = (EditText) findViewById(R.id.priceText);
        ed5 = (EditText) findViewById(R.id.tagsText);

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selected.res_name = ed1.getText().toString();
                selected.location = ed2.getText().toString();
                String hours = ed3.getText().toString();
                String[] store = hours.split("-");
                store[0] = store[0].trim();
                store[1] = store[1].trim();
                selected.open = store[0];
                selected.close = store[1];
                String prices = ed4.getText().toString();
                store = prices.split("-");
                store[0] = store[0].trim();
                store[1] = store[1].trim();
                if(store[0].startsWith("$"))
                    store[0] = store[0].substring(1);
                if(store[1].startsWith("$"))
                    store[1] = store[1].substring(1);
                selected.low = store[0];
                selected.high = store[1];
                selected.tags = ed5.getText().toString();
                selected.rating = rb.getRating();

                g.addRes(selected);

                Intent addIntent = new Intent(AddResActivity.this, ListActivity.class);
                AddResActivity.this.startActivity(addIntent);
            }
        });
    }
}
