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


public class ListActivity extends AppCompatActivity {
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
                Intent editIntent = new Intent(ListActivity.this, EditActivity.class);
                ListActivity.this.startActivity(editIntent);
                return true;
            case R.id.search:
                Intent searchIntent = new Intent(ListActivity.this, SearchActivity.class);
                ListActivity.this.startActivity(searchIntent);
                return true;
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
            case R.id.nearby:
                Intent nearbyIntent = new Intent(ListActivity.this, NearbyActivity.class);
                ListActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                 Intent groupsIntent = new Intent(ListActivity.this, GroupActivity.class);
                 ListActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                 Intent helpIntent = new Intent(ListActivity.this, HelpActivity.class);
                 ListActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button random = (Button) findViewById(R.id.random);

        Globals g = (Globals)getApplication();
        String reslist[] = new String[g.limit];
        for (int i = 0; i < g.limit; i++){
            reslist[i] = g.res[i].res_name;
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, reslist);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent infoIntent = new Intent(ListActivity.this, InfoActivity.class);
                infoIntent.putExtra("nearBy", false);
                infoIntent.putExtra("pos", id);
                ListActivity.this.startActivity(infoIntent);
            }
        });

        random.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent randomIntent = new Intent(ListActivity.this, RandomActivity.class);
                ListActivity.this.startActivity(randomIntent);
            }
        });
    }
}

