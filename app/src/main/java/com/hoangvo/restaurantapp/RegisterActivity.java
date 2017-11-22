package com.hoangvo.restaurantapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText userName = (EditText) findViewById(R.id.etName);
        EditText password = (EditText) findViewById(R.id.etPassword);
        EditText email = (EditText) findViewById(R.id.etEmail);
        Button register = (Button) findViewById(R.id.register);
    }
}
