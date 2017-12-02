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
import android.widget.ListView;


public class EditActivity extends AppCompatActivity {
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
                Intent editIntent = new Intent(EditActivity.this, EditActivity.class);
                EditActivity.this.startActivity(editIntent);
                return true;
            case R.id.search:
                Intent searchIntent = new Intent(EditActivity.this, SearchActivity.class);
                EditActivity.this.startActivity(searchIntent);
                return true;
            case R.id.logout:
                Intent logoutIntent = new Intent(EditActivity.this, MainActivity.class);
                EditActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(EditActivity.this, OptionActivity.class);
                EditActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(EditActivity.this, EditActivity.class);
                EditActivity.this.startActivity(listIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(EditActivity.this, NearbyActivity.class);
                EditActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                 Intent groupsIntent = new Intent(EditActivity.this, GroupActivity.class);
                 EditActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                 Intent helpIntent = new Intent(EditActivity.this, HelpActivity.class);
                 EditActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

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
                Intent infoIntent = new Intent(EditActivity.this, InfoActivity.class);
                infoIntent.putExtra("pos", id);
                EditActivity.this.startActivity(infoIntent);
            }
        });
    }
}

