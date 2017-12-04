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
        g.res[0].res_name = "McDonalds";
        g.res[0].location = "407 15th Ave SE, Minneapolis, MN 55414";
        g.res[0].open = "5:00am";
        g.res[0].close = "11:59pm";
        g.res[0].tags = "American\nFast Food\nDrive Through\nBurgers";
        g.res[0].low = "1.00";
        g.res[0].high = "15.00";

        g.res[1].res_name = "Chipotle";
        g.res[1].location = "800 Washington Ave SE, Minneapolis, MN 55414";
        g.res[1].open = "10:45am";
        g.res[1].close = "10:00pm";
        g.res[1].tags = "Mexican\nFast Food\nBurritos";
        g.res[1].low = "5.00";
        g.res[1].high = "20.00";
        g.res[1].rating = 4;

        g.res[2].res_name = "Applebee's";
        g.res[2].location = "615 Washington Ave SE, Minneapolis, MN 55414";
        g.res[2].open = "11:00am";
        g.res[2].close = "11:59pm";
        g.res[2].tags = "American\nBar & Grill\nSit Down\nBurgers\nSteak\nPasta";
        g.res[2].low = "5.00";
        g.res[2].high = "30.00";
        g.res[2].rating = 4.5f;

        g.res[3].res_name = "Teahouse";
        g.res[3].location = "2425 University Ave SE, Minneapolis, MN 55414";
        g.res[3].open = "11:00am";
        g.res[3].close = "9:30pm";
        g.res[3].tags = "Chinese\nSit Down\nLo Mein\nChow Mein\nDim Sum\n";
        g.res[3].low = "5.00";
        g.res[3].high = "20.00";
        g.res[3].rating = 4;

        g.res[8].res_name = "Chipotle";
        g.res[8].location = "800 Washington Ave SE, Minneapolis, MN 55414";
        g.res[8].open = "10:45am";
        g.res[8].close = "10:00pm";
        g.res[8].tags = "Mexican\nFast Food\nBurritos";
        g.res[8].low = "5.00";
        g.res[8].high = "20.00";
        g.res[8].rating = 4;
    }
}