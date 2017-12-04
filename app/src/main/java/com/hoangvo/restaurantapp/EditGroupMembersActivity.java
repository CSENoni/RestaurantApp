package com.hoangvo.restaurantapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EditGroupMembersActivity extends AppCompatActivity {

    ListView lv;
    EditText nameTxt;
    Button addbtn, updateBtn, deleteBtn, clearBtn;
    ArrayList<String> names = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group_members);

        lv = (ListView) findViewById(R.id.listView4);
        nameTxt = (EditText) findViewById(R.id.editText);
        addbtn = (Button) findViewById(R.id.button2);
        updateBtn = (Button) findViewById(R.id.button4);
        deleteBtn = (Button) findViewById(R.id.button8);
        clearBtn = (Button) findViewById(R.id.button9);

        //ADAPTER
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, names);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

            }
        });
    }
}
