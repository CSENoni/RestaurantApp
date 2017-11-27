package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.widget.TextView;


public class ListActivity extends AppCompatActivity {
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
                Intent logoutIntent = new Intent(ListActivity.this, MainActivity.class);
                ListActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(ListActivity.this, OptionActivity.class);
                ListActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(ListActivity.this, ListActivity.class);
                ListActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(ListActivity.this, RandomActivity.class);
                ListActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(ListActivity.this, NearbyActivity.class);
                ListActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                // Intent groupsIntent = new Intent(ListActivity.this, GroupsActivity.class);
                // ListActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                // Intent helpIntent = new Intent(ListActivity.this, HelpActivity.class);
                // ListActivity.this.startActivity(helpIntent);
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
        String reslist[] = new String[g.res.length];
        for (int i = 0; i < g.res.length; i++){
            reslist[i] = g.res[i].res_name;
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, reslist);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent infoIntent = new Intent(ListActivity.this, InfoActivity.class);
                infoIntent.putExtra("pos", id);
                ListActivity.this.startActivity(infoIntent);
            }
        });
    }
}

