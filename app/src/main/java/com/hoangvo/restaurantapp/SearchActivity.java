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
import android.widget.Button;
import android.widget.ListView;
import android.widget.EditText;
import android.text.TextUtils;



public class SearchActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.titlemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                Intent searchIntent = new Intent(SearchActivity.this, SearchActivity.class);
                SearchActivity.this.startActivity(searchIntent);
                return true;
            case R.id.logout:
                Intent logoutIntent = new Intent(SearchActivity.this, MainActivity.class);
                SearchActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(SearchActivity.this, OptionActivity.class);
                SearchActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(SearchActivity.this, ListActivity.class);
                SearchActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(SearchActivity.this, RandomActivity.class);
                SearchActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(SearchActivity.this, NearbyActivity.class);
                SearchActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                 Intent groupsIntent = new Intent(SearchActivity.this, GroupActivity.class);
                 SearchActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                 Intent helpIntent = new Intent(SearchActivity.this, HelpActivity.class);
                 SearchActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Globals g = (Globals)getApplication();
                EditText ed1, ed2, ed3, ed4, ed5;
                ed1 = (EditText) findViewById(R.id.nameText);
                ed2 = (EditText) findViewById(R.id.addressText);
                ed3 = (EditText) findViewById(R.id.hoursText);
                ed4 = (EditText) findViewById(R.id.priceText);
                ed5 = (EditText) findViewById(R.id.tagsText);
                String name = ed1.getText().toString();
                String address = ed2.getText().toString();
                String hours = ed3.getText().toString();
                String price = ed4.getText().toString();
                String tags = ed5.getText().toString();

                if (!TextUtils.isEmpty(name)){
                    for(int i = 0; i < g.res.length; i++){
                        if(!name.equals(g.res[i].res_name))
                            g.res[i].ignore = true;
                    }
                }

                if (!TextUtils.isEmpty(address)){
                    for(int i = 0; i < g.res.length; i++){
                        if(!address.equals(g.res[i].location))
                            g.res[i].ignore = true;
                    }
                }

                /* COME BACK TO
                if (!TextUtils.isEmpty(hours)){
                    for(int i = 0; i < g.res.length; i++){
                        if(hours.equals(g.res[i].))
                            g.res[i].ignore = true;
                    }
                }

                if (!TextUtils.isEmpty(price)){
                    for(int i = 0; i < g.res.length; i++){
                        if(price.equals(g.res[i].))
                            g.res[i].ignore = true;
                    }
                }
                */

                if (!TextUtils.isEmpty(tags)){
                    String[] buff = tags.split("\\n");
                    for(int i = 0; i < g.res.length; i++){
                        String[] ffub = g.res[i].tags.split("\\n");
                        for(int j = 0; j < buff.length; j++){
                            for(int k = 0; k < ffub.length; k++){
                                if(!TextUtils.isEmpty(buff[j]) && !TextUtils.isEmpty(ffub[k]))
                                    if(buff[j].equals(ffub[k]))
                                        g.res[i].ignore = true;
                            }
                        }
                    }
                }


                Intent selectIntent = new Intent(SearchActivity.this, SelectedActivity.class);
                SearchActivity.this.startActivity(selectIntent);
            }
        });
    }
}

