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
                g.res[i].position = i;
            }
            initializeRes();


            for (int i = 0; i < g.gro.length; i++) {
                g.gro[i] = new Groups();
                g.gro[i].name = "Empty Group";
                for (int j = 0; j < g.gro[i].members.length; j++){
                    g.gro[i].members[j] = "";
                }
                for (int j = 0; j < g.gro[i].events.length; j++){
                    g.gro[i].events[j] = "";
                }
            }

            for (int i = 0; i < g.groEvt.length; i++) {
                g.groEvt[i] = new GroupEvent();
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

    public void initializeRes (){
        Globals g = (Globals)getApplication();
        Restaurant temp = new Restaurant();
        temp.res_name = "McDonalds";
        temp.location = "407 15th Ave SE, Minneapolis, MN 55414";
        temp.open = "5:00am";
        temp.close = "11:59pm";
        temp.tags = "American\nFast Food\nDrive Through\nBurgers";
        temp.low = "1.00";
        temp.high = "15.00";
        g.addRes(temp);


        temp = new Restaurant();
        temp.res_name = "Chipotle";
        temp.location = "800 Washington Ave SE, Minneapolis, MN 55414";
        temp.open = "10:45am";
        temp.close = "10:00pm";
        temp.tags = "Mexican\nFast Food\nBurritos";
        temp.low = "5.00";
        temp.high = "20.00";
        temp.rating = 4;
        g.addRes(temp);

        temp = new Restaurant();
        temp.res_name = "Applebee's";
        temp.location = "615 Washington Ave SE, Minneapolis, MN 55414";
        temp.open = "11:00am";
        temp.close = "11:59pm";
        temp.tags = "American\nBar & Grill\nSit Down\nBurgers\nSteak\nPasta";
        temp.low = "5.00";
        temp.high = "30.00";
        temp.rating = 4.5f;
        g.addRes(temp);

        temp = new Restaurant();
        temp.res_name = "Teahouse";
        temp.location = "2425 University Ave SE, Minneapolis, MN 55414";
        temp.open = "11:00am";
        temp.close = "9:30pm";
        temp.tags = "Chinese\nSit Down\nLo Mein\nChow Mein\nDim Sum\n";
        temp.low = "5.00";
        temp.high = "20.00";
        temp.rating = 4;
        g.addRes(temp);
    }
}