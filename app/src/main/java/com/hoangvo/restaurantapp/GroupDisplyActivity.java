package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class GroupDisplyActivity extends AppCompatActivity {

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
                Intent logoutIntent = new Intent(GroupDisplyActivity.this, MainActivity.class);
                GroupDisplyActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(GroupDisplyActivity.this, OptionActivity.class);
                GroupDisplyActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(GroupDisplyActivity.this, ListActivity.class);
                GroupDisplyActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(GroupDisplyActivity.this, RandomActivity.class);
                GroupDisplyActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(GroupDisplyActivity.this, NearbyActivity.class);
                GroupDisplyActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                Intent groupsIntent = new Intent(GroupDisplyActivity.this, GroupActivity.class);
                GroupDisplyActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                Intent helpIntent = new Intent(GroupDisplyActivity.this, HelpActivity.class);
                GroupDisplyActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_disply);


        Globals g = (Globals)getApplication();
        Bundle bundle = getIntent().getExtras();
        long i = bundle.getLong("gID");
        Groups clickedOn = g.gro[(int)i];
        int count = g.gro[(int)i].members.length;

        EditText gName = (EditText) findViewById(R.id.editTextGroupName);
        EditText editText = gName;
        editText.setText(clickedOn.name);

        ListView listViewMembers = (ListView ) findViewById(R.id.listView);
        //String[] members_names = new String[count];
        int total = 0;
        for (int j = 0; j < clickedOn.members.length; j++) {
            if(clickedOn.members[j] != ""){
                total++;
            }
        }
        String[] members_names = new String[total];
        int current = 0;
        for(int k = 0; k < clickedOn.members.length; k++){
            if(clickedOn.members[k] != ""){
                members_names[current] = clickedOn.members[k];
                current++;
            }
        }


        final ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(members_names));
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, arrayList);
        listViewMembers.setAdapter(adapter);

        final EditText mName = (EditText) findViewById(R.id.editTextMemberName);
        Button btnAddMem = (Button) findViewById(R.id.button3);
        btnAddMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addMember = mName.getText().toString();
                arrayList.add(addMember);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Name Added To List", Toast.LENGTH_SHORT).show();
            }
        });

        ListView listView1 = (ListView) findViewById(R.id.listView2);
        int totalE = 0;
        for (int j = 0; j < clickedOn.events.length; j++) {
            if(clickedOn.events[j] != ""){
                totalE++;
            }
        }
        String[] event_list = new String[totalE];
        int current1 = 0;
        for(int k = 0; k < clickedOn.events.length; k++){
            if(clickedOn.events[k] != ""){
                event_list[current1] = clickedOn.events[k];
                current1++;
            }
        }

        //ListView listView1 = (ListView) findViewById(R.id.listView2);
        final ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(event_list));
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, arrayList1);
        listView1.setAdapter(adapter1);

        final EditText eName = (EditText) findViewById(R.id.editTextEventName);
        Button btnAddEvent = (Button) findViewById(R.id.button5);
        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addEvent = eName.getText().toString();
                arrayList1.add(addEvent);
                adapter1.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Event Added To List", Toast.LENGTH_SHORT).show();
            }
        });



        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent myintent = new Intent(view.getContext(), EventActivity.class);
                    myintent.putExtra("gID",id);
                    startActivityForResult(myintent, 0);
                }
                if (position == 1) {
                    Intent myintent = new Intent(view.getContext(), EventActivity.class);
                    myintent.putExtra("gID", id);
                    startActivityForResult(myintent, 1);
                }
                if (position == 2) {
                    Intent myintent = new Intent(view.getContext(), EventActivity.class);
                    myintent.putExtra("gID",id);
                    startActivityForResult(myintent, 2);
                }
            }


        });

    }

}
