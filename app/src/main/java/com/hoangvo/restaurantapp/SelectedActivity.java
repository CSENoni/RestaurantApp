package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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
            case R.id.edit:
                Intent editIntent = new Intent(SelectedActivity.this, EditActivity.class);
                SelectedActivity.this.startActivity(editIntent);
                return true;
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
                Intent listIntent = new Intent(SelectedActivity.this, SelectedActivity.class);
                SelectedActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(SelectedActivity.this, RandomActivity.class);
                SelectedActivity.this.startActivity(randomIntent);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Globals g = (Globals)getApplication();
        int total = 0;
        for (int i = 0; i < g.res.length; i++){
            if(!g.res[i].ignore)
                total++;
        }
        String reslist[] = new String[total];
        int current = 0;
        for (int i = 0; i < g.res.length; i++){
            if(!g.res[i].ignore){
                reslist[current] = g.res[i].res_name;
                current++;
            }
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, reslist);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent infoIntent = new Intent(SelectedActivity.this, InfoActivity.class);
                infoIntent.putExtra("pos", id);
                SelectedActivity.this.startActivity(infoIntent);
            }
        });
    }
}

