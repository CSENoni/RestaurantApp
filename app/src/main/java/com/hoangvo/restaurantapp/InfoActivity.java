package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class InfoActivity extends AppCompatActivity {

    long position;
    boolean nearBy;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.infomenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Bundle bundle = getIntent().getExtras();
        nearBy = bundle.getBoolean("nearBy");
        switch (item.getItemId()) {
            case R.id.edit:
                if(!nearBy){
                    Intent editIntent = new Intent(InfoActivity.this, EditResActivity.class);
                    editIntent.putExtra("pos", position);
                    InfoActivity.this.startActivity(editIntent);
                    return true;
                }
                Toast.makeText(getApplicationContext(),"This is a read-only page.",Toast.LENGTH_LONG).show();
                return false;
            case R.id.logout:
                Intent logoutIntent = new Intent(InfoActivity.this, MainActivity.class);
                InfoActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(InfoActivity.this, OptionActivity.class);
                InfoActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(InfoActivity.this, ListActivity.class);
                InfoActivity.this.startActivity(listIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(InfoActivity.this, NearbyActivity.class);
                InfoActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                Intent groupsIntent = new Intent(InfoActivity.this, GroupActivity.class);
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
        nearBy = bundle.getBoolean("nearBy");

        EditText ed1, ed2, ed3, ed4, ed5;
        RatingBar rb = (RatingBar) findViewById(R.id.rating);
        ed1 = (EditText) findViewById(R.id.nameText);
        ed2 = (EditText) findViewById(R.id.addressText);
        ed3 = (EditText) findViewById(R.id.hoursText);
        ed4 = (EditText) findViewById(R.id.priceText);
        ed5 = (EditText) findViewById(R.id.tagsText);

        if(nearBy){
            final int pos = bundle.getInt("pos");
            JSONObject jsonRes = g.nRes.get(pos);
            try {
                ed1.setText(jsonRes.getString("name"));
                ed2.setText(jsonRes.getString("vicinity"));
                ed3.setVisibility(View.GONE);
                ed4.setVisibility(View.GONE);
                ed5.setVisibility(View.GONE);
                rb.setRating((float)jsonRes.getDouble("rating"));

                Button showMap = (Button) findViewById(R.id.show_map);
                showMap.setVisibility(View.VISIBLE);
                showMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mapIntent = new Intent(InfoActivity.this, MapsActivity.class);
                        mapIntent.putExtra("pos", pos);
                        InfoActivity.this.startActivity(mapIntent);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            position = bundle.getLong("pos");
            Restaurant selected = g.res[(int)position];
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
}
