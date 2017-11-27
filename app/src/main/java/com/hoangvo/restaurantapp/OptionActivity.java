package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class OptionActivity extends AppCompatActivity {
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
                Intent logoutIntent = new Intent(OptionActivity.this, MainActivity.class);
                OptionActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(OptionActivity.this, OptionActivity.class);
                OptionActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(OptionActivity.this, ListActivity.class);
                OptionActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(OptionActivity.this, RandomActivity.class);
                OptionActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(OptionActivity.this, NearbyActivity.class);
                OptionActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                // Intent groupsIntent = new Intent(OptionActivity.this, GroupsActivity.class);
                // OptionActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                // Intent helpIntent = new Intent(OptionActivity.this, HelpActivity.class);
                // OptionActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        Globals g = (Globals)getApplication();

        Button mylist = (Button) findViewById(R.id.btView);
        Button random = (Button) findViewById(R.id.btRandom);
        Button group = (Button) findViewById(R.id.btGroup);
        Button nearBy = (Button) findViewById(R.id.btNearby);

        nearBy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent nearbyIntent = new Intent(OptionActivity.this, NearbyActivity.class);
                OptionActivity.this.startActivity(nearbyIntent);
            }
        });

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

        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groupIntent = new Intent( OptionActivity.this, GroupActivity.class);
                OptionActivity.this.startActivity(groupIntent);
            }
        });
    }
}
