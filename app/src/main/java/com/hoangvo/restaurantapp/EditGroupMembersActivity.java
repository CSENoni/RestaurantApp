package com.hoangvo.restaurantapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class EditGroupMembersActivity extends AppCompatActivity {




    ListView lv;
    EditText nameTxt;
    Button addbtn, updateBtn, deleteBtn, clearBtn;
    ArrayList<String> names ;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group_members);

        Globals g = (Globals)getApplication();
        Bundle bundle = getIntent().getExtras();
        final long i = bundle.getLong("gID");
        final Groups clickedOn = g.gro[(int)i];



        lv = (ListView) findViewById(R.id.listView4);
        nameTxt = (EditText) findViewById(R.id.editText);
        addbtn = (Button) findViewById(R.id.button2);
        updateBtn = (Button) findViewById(R.id.button4);
        deleteBtn = (Button) findViewById(R.id.button8);
        clearBtn = (Button) findViewById(R.id.button9);

        //ADAPTER
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

        names = new ArrayList<>(Arrays.asList(members_names));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, names);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int pos, long id) {

                nameTxt.setText(names.get(pos));
            }
        });

        //HANDLE EVENTS
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                add();
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                update();
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                delete();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                clear();
            }
        });
    }

    //ADD
    private void add() {
        String name = nameTxt.getText().toString();
        if ( !name.isEmpty() && name.length() > 0){
            //ADD
            adapter.add(name);
            Globals g = (Globals)getApplication();
            Bundle bundle = getIntent().getExtras();
            final long i = bundle.getLong("gID");
            final Groups clickedOn = g.gro[(int)i];

            //clickedOn.members[adapter.getCount()] = name;

            //REFRESH
            adapter.notifyDataSetChanged();
            nameTxt.setText("");

            clickedOn.members[adapter.getCount()] = name;

            Toast.makeText(getApplicationContext(), "Added " + name, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "!! Nothing to Add", Toast.LENGTH_SHORT).show();
        }
    }

    //UPDATE
    private void update() {
        String name = nameTxt.getText().toString();

        //GET POSITION OF SELECTED ITEM
        int pos = lv.getCheckedItemPosition();

        if(!name.isEmpty() && name.length() > 0) {
            //REMOVE ITEM
            adapter.remove(names.get(pos));

            //INSERT
            adapter.insert(name, pos);

            //REFRESH
            adapter.notifyDataSetChanged();

            Toast.makeText(getApplicationContext(), "Updated " + name, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "!! Nothing to update", Toast.LENGTH_SHORT).show();
        }
    }

    //DELETE
    private void delete() {
        int pos = lv.getCheckedItemPosition();

        if(pos > -1) {
            //remove
            adapter.remove(names.get(pos));
            //refresh
            adapter.notifyDataSetChanged();

            nameTxt.setText("");
            Toast.makeText(getApplicationContext(), "Deleted ", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "!! Nothing to Delete", Toast.LENGTH_SHORT).show();
        }
    }

    //CLEAR
    private void clear() {
        adapter.clear();
    }



    //
}
