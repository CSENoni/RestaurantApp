package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class EditActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.titlemenu, menu);
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
                Intent listIntent = new Intent(EditActivity.this, ListActivity.class);
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

    ArrayList<Integer> deleted = new ArrayList<Integer>();
    ArrayList<Restaurant> reslist = new ArrayList<Restaurant>();
    Globals g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        g = (Globals)getApplication();
        for (int i = 0; i < g.res.length; i++)
            g.res[i].position = i;

        reslist = new ArrayList<Restaurant>();
        for (int i = 0; i < g.limit; i++){
            if(!g.res[i].ignore){
                reslist.add(g.res[i]);
            }
        }

        final Button add = (Button) findViewById(R.id.add);
        final Button done = (Button) findViewById(R.id.done);
        final Button delete = (Button) findViewById(R.id.delete);

        ArrayAdapter adapter = new ArrayAdapter<Restaurant>(this, android.R.layout.simple_list_item_checked, reslist);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                CheckedTextView item = (CheckedTextView) view;
                if(item.isChecked()) {
                    //Toast.makeText(getApplicationContext(), "Checked", Toast.LENGTH_LONG).show();
                    if (!deleted.contains((int) id)) {
                        deleted.add((int) id);
                    }
                }
                else {
                    if (deleted.contains((int) id)){
                        deleted.remove((int) id);
                    }
                }
            }
        });

        done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent doneIntent = new Intent(EditActivity.this, ListActivity.class);
                EditActivity.this.startActivity(doneIntent);
            }
        });

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(EditActivity.this, AddResActivity.class);
                EditActivity.this.startActivity(addIntent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayList<Restaurant> rest = new ArrayList<>();
                for(int i = 0; i < deleted.size(); i++){
                    Restaurant clicked = reslist.get(deleted.get(i));
                    g.delRes(clicked.position);
                }
                Intent deleteIntent = new Intent(EditActivity.this, ListActivity.class);
                EditActivity.this.startActivity(deleteIntent);
            }
        });
    }


}

