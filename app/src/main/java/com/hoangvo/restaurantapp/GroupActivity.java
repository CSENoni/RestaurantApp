package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GroupActivity extends AppCompatActivity {

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
                Intent logoutIntent = new Intent(GroupActivity.this, MainActivity.class);
                GroupActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(GroupActivity.this, OptionActivity.class);
                GroupActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(GroupActivity.this, ListActivity.class);
                GroupActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(GroupActivity.this, RandomActivity.class);
                GroupActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(GroupActivity.this, NearbyActivity.class);
                GroupActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                Intent groupsIntent = new Intent(GroupActivity.this, GroupActivity.class);
                GroupActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                Intent helpIntent = new Intent(GroupActivity.this, HelpActivity.class);
                GroupActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Globals g = (Globals)getApplication();

        final ListView listView = (ListView)findViewById(R.id.groupList);
        // Create a string array of group names
        final String[] gList = new String[]{g.gro[0].name,g.gro[1].name,g.gro[2].name, g.gro[3].name, g.gro[4].name};
        // Create an adapter to show this array like a list of items
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, gList);
        // Put this adapter to listview
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent myintent = new Intent(view.getContext(), GroupDisplyActivity.class);
                    myintent.putExtra("gID", id);
                    startActivityForResult(myintent, 0);
                }
                if(position == 1){
                    Intent myintent = new Intent(view.getContext(), GroupDisplyActivity.class);
                    myintent.putExtra("gID", id);
                    startActivityForResult(myintent, 1);
                }
                if(position == 2){
                    Intent myintent = new Intent(view.getContext(), GroupDisplyActivity.class);
                    myintent.putExtra("gID", id);
                    startActivityForResult(myintent, 2);
                }
                if(position == 3){
                    Intent myintent = new Intent(view.getContext(), GroupDisplyActivity.class);
                    myintent.putExtra("gID", id);
                    startActivityForResult(myintent, 3);
                }
                if(position == 4){
                    Intent myintent = new Intent(view.getContext(), GroupDisplyActivity.class);
                    myintent.putExtra("gID", id);
                    startActivityForResult(myintent, 4);
                }
            }
        });


    }

}
