package com.hoangvo.restaurantapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Group1Activity extends AppCompatActivity {

    // Group 1
    EditText gName;

    EditText member1;
    EditText member2;
    EditText member3;
    EditText event1;
    EditText event2;
    TextView displayGroupInfo;

    ListView listViewMembers;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    EditText mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group1);

        listViewMembers = (ListView ) findViewById(R.id.ListViewMemberNames);
        String[] members_names={"Bob"};
        arrayList = new ArrayList<>(Arrays.asList(members_names));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listViewMembers.setAdapter(adapter);

        mName = (EditText) findViewById(R.id.editText2Group1);
        Button btnAddMem = (Button) findViewById(R.id.btAddMemberGroup1);
        btnAddMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addMember = mName.getText().toString();
                arrayList.add(addMember);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Name Added To List", Toast.LENGTH_SHORT).show();
            }
        });
        /*
        listViewMembers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), parent.getItem)
            }
        });
        */
        SharedPreferences group1SharedPref = getSharedPreferences("group1Info", Context.MODE_PRIVATE);
        String  g1name = group1SharedPref.getString("group1Name", "");

        gName = (EditText) findViewById(R.id.editTextGroup1Name);
        //member = (EditText) findViewById();
        //event = (EditText) findViewById();
        //displayGroupInfo = (TextView) findViewById(R.id.)

        EditText editText = gName;
        editText.setText(group1SharedPref.getString("group1Name", ""));

        //TextView groupName = (TextView) findViewById(R.id.editTextGroup1Name);
        //groupName.setText(firstGroup.name);
    }

    public void saveInfo(View view){
        SharedPreferences groupSharedPref = getSharedPreferences("group1Info", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = groupSharedPref.edit();
        editor.putString("group1Name", gName.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }
}
