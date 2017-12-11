package com.hoangvo.restaurantapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Globals g = (Globals) getApplication();

        final EditText userName = (EditText) findViewById(R.id.btName);
        final EditText password = (EditText) findViewById(R.id.btPassword);
        final Button login = (Button) findViewById(R.id.btLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = userName.getText().toString();
                String p = password.getText().toString();
                if(n.length() == 0 || p.length() == 0){
                    Toast.makeText(getApplicationContext(),"Please enter all of the fields.",Toast.LENGTH_LONG).show();
                }else if(!g.users.containsKey(n)){
                    Toast.makeText(getApplicationContext(),"This user name is not registered.",Toast.LENGTH_LONG).show();
                }else if(!g.users.get(n)[0].equals(p)){
                    Toast.makeText(getApplicationContext(),"Password is not correct.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Welcome! " + n,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
