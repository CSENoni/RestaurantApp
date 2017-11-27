package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Globals g = (Globals)getApplication();
        if (!g.already) {
            g.already = true;
            for (int i = 0; i < g.res.length; i++) {
                g.res[i] = new Restaurant();
                g.res[i].res_name = "Olive Garden";
                g.res[i].location = "123 Test Street";
                g.res[i].open = "8:00am";
                g.res[i].close = "4:00pm";
                g.res[i].tags = "Italian\nSit Down\n";
                g.res[i].rating = 4;
                g.res[i].low = "5.00";
                g.res[i].high = "50.00";
            }
        }

        final Button guestLogin = (Button) findViewById(R.id.guestLogin);
        final Button newUser = (Button) findViewById(R.id.newUser);
        final Button login = (Button) findViewById(R.id.login);

        guestLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent guestIntent = new Intent(MainActivity.this, OptionActivity.class);
                MainActivity.this.startActivity(guestIntent);
            }
        });

        newUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(loginIntent);
            }
        });
    }
}
