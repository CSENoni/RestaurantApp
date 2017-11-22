package com.hoangvo.restaurantapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText userName = (EditText) findViewById(R.id.btName);
        final EditText password = (EditText) findViewById(R.id.btPassword);
        final Button guestLogin = (Button) findViewById(R.id.btLogin);
    }
}
