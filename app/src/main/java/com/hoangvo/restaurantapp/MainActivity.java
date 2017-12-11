package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
            initializeUser();

            for (int i = 0; i < g.gro.length; i++) {
                g.gro[i] = new Groups();
                g.gro[i].name = "Add Group";
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

    public void initializeUser() {
        Globals g = (Globals) getApplication();
        g.addUser("superman@gmail.com", "Superman", "12345");
        g.addUser("batman@gmail.com", "Batman", "54321");
        g.addUser("hulk@gmail.com", "Hulk", "11111");
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

        Restaurant temp1 = new Restaurant();

        temp1.res_name = "Chipotle";
        temp1.location = "800 Washington Ave SE, Minneapolis, MN 55414";
        temp1.open = "10:45am";
        temp1.close = "10:00pm";
        temp1.tags = "Mexican\nFast Food\nBurritos";
        temp1.low = "5.00";
        temp1.high = "20.00";
        temp1.rating = 4;
        g.addRes(temp1);

        Restaurant temp2 = new Restaurant();

        temp2.res_name = "Applebee's";
        temp2.location = "615 Washington Ave SE, Minneapolis, MN 55414";
        temp2.open = "11:00am";
        temp2.close = "11:59pm";
        temp2.tags = "American\nBar & Grill\nSit Down\nBurgers\nSteak\nPasta";
        temp2.low = "5.00";
        temp2.high = "30.00";
        temp2.rating = 4.5f;
        g.addRes(temp2);

        Restaurant temp3 = new Restaurant();

        temp3.res_name = "Teahouse";
        temp3.location = "2425 University Ave SE, Minneapolis, MN 55414";
        temp3.open = "11:00am";
        temp3.close = "9:30pm";
        temp3.tags = "Chinese\nSit Down\nLo Mein\nChow Mein\nDim Sum\n";
        temp3.low = "5.00";
        temp3.high = "20.00";
        temp3.rating = 4;
        g.addRes(temp3);

        Restaurant temp4 = new Restaurant();

        temp4.res_name = "Noodles & Company";
        temp4.location = "820 Washington Ave SE, Minneapolis, MN 55414";
        temp4.open = "11:00am";
        temp4.close = "10:00pm";
        temp4.tags = "Fast Food\nNoodles";
        temp4.low = "5.00";
        temp4.high = "10.00";
        temp4.rating = 3;
        g.addRes(temp4);

        Restaurant temp5 = new Restaurant();

        temp5.res_name = "Raising Cane's";
        temp5.location = "825 Washington Ave SE, Minneapolis, MN 55414";
        temp5.open = "10:00am";
        temp5.close = "11:00pm";
        temp5.tags = "American\nFast Food\nChicken Fingers";
        temp5.low = "5.00";
        temp5.high = "12.00";
        temp5.rating = 5;
        g.addRes(temp5);

        Restaurant temp6 = new Restaurant();

        temp6.res_name = "Perkins";
        temp6.location = "901 27th Ave S, Minneapolis, MN 55406";
        temp6.open = "6:00am";
        temp6.close = "11:59pm";
        temp6.tags = "Sit Down\nFamily\nParking Lot\nBreakfast\nBakery";
        temp6.low = "1.00";
        temp6.high = "13.00";
        temp6.rating = 3.7f;
        g.addRes(temp6);

        Restaurant temp7 = new Restaurant();

        temp7.res_name = "Restaurant Alma";
        temp7.location = "528 University Ave SE, Minneapolis, MN 55414";
        temp7.open = "7:00am";
        temp7.close = "10:00pm";
        temp7.tags = "Fine Dining\nHealthy Options";
        temp7.low = "5.00";
        temp7.high = "52.00";
        temp7.rating = 4.6f;
        g.addRes(temp7);


    }
}