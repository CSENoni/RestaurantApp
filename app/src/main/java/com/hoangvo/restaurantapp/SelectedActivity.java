package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class SelectedActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                Intent searchIntent = new Intent(SelectedActivity.this, SearchActivity.class);
                SelectedActivity.this.startActivity(searchIntent);
                return true;
            case R.id.logout:
                Intent logoutIntent = new Intent(SelectedActivity.this, MainActivity.class);
                SelectedActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(SelectedActivity.this, OptionActivity.class);
                SelectedActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(SelectedActivity.this, ListActivity.class);
                SelectedActivity.this.startActivity(listIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(SelectedActivity.this, NearbyActivity.class);
                SelectedActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                 Intent groupsIntent = new Intent(SelectedActivity.this, GroupActivity.class);
                 SelectedActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                 Intent helpIntent = new Intent(SelectedActivity.this, HelpActivity.class);
                 SelectedActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    ArrayList<Restaurant> reslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button random = (Button) findViewById(R.id.random);

        Globals g = (Globals)getApplication();
        int total = 0;
        for (int i = 0; i < g.limit; i++){
            if(!g.res[i].ignore)
                total++;
        }
        reslist = new ArrayList<Restaurant>();
        for (int i = 0; i < g.limit; i++){
            if(!g.res[i].ignore){
                reslist.add(g.res[i]);
            }
        }

        ArrayAdapter adapter = new ArrayAdapter<Restaurant>(this, R.layout.activity_listview, reslist);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Restaurant clicked = reslist.get((int)id);
                Intent infoIntent = new Intent(SelectedActivity.this, InfoActivity.class);
                infoIntent.putExtra("pos", (long)clicked.position);
                SelectedActivity.this.startActivity(infoIntent);
            }
        });

        random.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent randomIntent = new Intent(SelectedActivity.this, RandomActivity.class);
                SelectedActivity.this.startActivity(randomIntent);
            }
        });
    }
}

