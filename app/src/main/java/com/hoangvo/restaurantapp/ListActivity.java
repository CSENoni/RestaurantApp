package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

