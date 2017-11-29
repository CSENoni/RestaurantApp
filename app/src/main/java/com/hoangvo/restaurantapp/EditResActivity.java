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


public class EditResActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5;
    long position;
    Restaurant selected;
    RatingBar rb;

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
                Intent logoutIntent = new Intent(EditResActivity.this, MainActivity.class);
                EditResActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(EditResActivity.this, OptionActivity.class);
                EditResActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(EditResActivity.this, ListActivity.class);
                EditResActivity.this.startActivity(listIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(EditResActivity.this, NearbyActivity.class);
                EditResActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                Intent groupsIntent = new Intent(EditResActivity.this, GroupActivity.class);
                EditResActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                Intent helpIntent = new Intent(EditResActivity.this, HelpActivity.class);
                EditResActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editres);

        Globals g = (Globals)getApplication();
        Bundle bundle = getIntent().getExtras();
        position = bundle.getLong("pos");
        selected = g.res[(int)position];

        rb = (RatingBar) findViewById(R.id.rating);
        Button save = (Button) findViewById(R.id.save);
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
                selected.low = store[0];
                selected.high = store[1];
                selected.tags = ed5.getText().toString();
                selected.rating = rb.getRating();

                Intent saveIntent = new Intent(EditResActivity.this, InfoActivity.class);
                saveIntent.putExtra("pos", position);
                EditResActivity.this.startActivity(saveIntent);
            }
        });
    }
}
