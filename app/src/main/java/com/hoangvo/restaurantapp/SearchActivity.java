package com.hoangvo.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.RatingBar;
import android.text.TextUtils;
import android.widget.Toast;


public class SearchActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.titlemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                Intent searchIntent = new Intent(SearchActivity.this, SearchActivity.class);
                SearchActivity.this.startActivity(searchIntent);
                return true;
            case R.id.logout:
                Intent logoutIntent = new Intent(SearchActivity.this, MainActivity.class);
                SearchActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(SearchActivity.this, OptionActivity.class);
                SearchActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(SearchActivity.this, ListActivity.class);
                SearchActivity.this.startActivity(listIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(SearchActivity.this, NearbyActivity.class);
                SearchActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                 Intent groupsIntent = new Intent(SearchActivity.this, GroupActivity.class);
                 SearchActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                 Intent helpIntent = new Intent(SearchActivity.this, HelpActivity.class);
                 SearchActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Globals g = (Globals)getApplication();
                EditText ed1, ed2, ed3, ed4, ed5;
                RatingBar rb = (RatingBar) findViewById(R.id.rating);
                ed1 = (EditText) findViewById(R.id.nameText);
                ed2 = (EditText) findViewById(R.id.addressText);
                ed3 = (EditText) findViewById(R.id.hoursText);
                ed4 = (EditText) findViewById(R.id.priceText);
                ed5 = (EditText) findViewById(R.id.tagsText);
                String name = ed1.getText().toString();
                String address = ed2.getText().toString();
                String hours = ed3.getText().toString();
                String price = ed4.getText().toString();
                String tags = ed5.getText().toString();
                boolean con = true;

                for(Restaurant r : g.res){
                    r.ignore = false;
                }

                if (!TextUtils.isEmpty(name)){
                    for(int i = 0; i < g.res.length; i++){
                        if(!name.equals(g.res[i].res_name))
                            g.res[i].ignore = true;
                    }
                }

                if (!TextUtils.isEmpty(address)){
                    for(int i = 0; i < g.res.length; i++){
                        if(!address.equals(g.res[i].location))
                            g.res[i].ignore = true;
                    }
                }

                if (!TextUtils.isEmpty(hours)){
                    String[] values = hours.split("-");
                    if (values.length != 2) {
                        Toast.makeText(getApplicationContext(),"Invalid hours range. Please check your input and try again (start - end).",Toast.LENGTH_LONG).show();
                        con = false;
                    }
                    else {
                        boolean fpm = false;
                        boolean spm = false;

                        //Format start time
                        String temp = values[0];
                        temp = temp.trim();
                        if (temp.endsWith("am"))
                            temp = temp.substring(0, temp.length()-2);
                        if (temp.endsWith("pm")) {
                            fpm = true;
                            temp = temp.substring(0, temp.length()-2);
                        }
                        temp = temp.replace(':', '.');
                        values[0] = temp;

                        //Format end time
                        temp = values[1];
                        temp = temp.trim();
                        if (temp.endsWith("am"))
                            temp = temp.substring(0, temp.length()-2);
                        if (temp.endsWith("pm")) {
                            spm = true;
                            temp = temp.substring(0, temp.length()-2);
                        }
                        temp = temp.replace(':', '.');
                        values[1] = temp;

                        float low = Float.parseFloat(values[0]);
                        float high = Float.parseFloat(values[1]);
                        if(fpm && (low < 12.01 || low > 12.59))
                            low += 12;
                        if(spm && (high < 12.01 || high > 12.6))
                            high += 12;

                        for(Restaurant r : g.res){
                            boolean ropm = false;
                            boolean rcpm = false;
                            String ro = r.open;
                            String rc = r.close;
                            if (ro.endsWith("am"))
                                ro = ro.substring(0, ro.length()-2);
                            if (ro.endsWith("pm")) {
                                ropm = true;
                                ro = ro.substring(0, ro.length()-2);
                            }
                            ro = ro.replace(':', '.');
                            if (rc.endsWith("am"))
                                rc = rc.substring(0, rc.length()-2);
                            if (rc.endsWith("pm")) {
                                rcpm = true;
                                rc = rc.substring(0, rc.length()-2);
                            }
                            rc = rc.replace(':', '.');

                            float rl = Float.parseFloat(ro);
                            float rh = Float.parseFloat(rc);
                            if(ropm && (rl < 12.01 || rl > 12.59))
                                rl += 12;
                            if(rcpm && (rh < 12.01 || rh > 12.6))
                                rh += 12;

                            if(rl > high || rh < low)
                                r.ignore = true;
                        }
                    }
                }

                if (!TextUtils.isEmpty(price)){
                    String[] values = price.split("-");
                    if (values.length != 2) {
                        Toast.makeText(getApplicationContext(),"Invalid price range. Please check your input and try again ($low - $high).",Toast.LENGTH_LONG).show();
                        con = false;
                    }
                    else {
                        String temp = values[0];
                        temp = temp.trim();
                        if (temp.startsWith("$"))
                            temp = temp.substring(1);
                        values[0] = temp;
                        temp = values[1];
                        temp = temp.trim();
                        if (temp.startsWith("$"))
                            temp = temp.substring(1);
                        values[1] = temp;
                        float low = Float.parseFloat(values[0]);
                        float high = Float.parseFloat(values[1]);
                        for(Restaurant r : g.res){
                            float rl = Float.parseFloat(r.low);
                            float rh = Float.parseFloat(r.high);
                            if(rl > high || rh < low)
                                r.ignore = true;
                        }
                    }
                }


                if (!TextUtils.isEmpty(tags)){
                    //String array of inputted tags
                    String[] buff = tags.split("\\n");

                    for(int i = 0; i < g.res.length; i++){
                        String[] ffub = g.res[i].tags.split("\\n");

                        if (buff.length > ffub.length){
                            g.res[i].ignore = true;
                        }

                        else {
                            int k = 0;
                            for (int j = 0; j < buff.length; j++) {
                                for (k = 0; k < ffub.length; k++) {
                                    if (!TextUtils.isEmpty(buff[j]) && !TextUtils.isEmpty(ffub[k])) {
                                        if (buff[j].equals(ffub[k])) {
                                            break;
                                        }
                                    }
                                }
                                if (k == ffub.length) {
                                    g.res[i].ignore = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(rb.getRating() > 0){
                    for(Restaurant r : g.res){
                        if(r.rating < rb.getRating())
                            r.ignore = true;
                    }
                }

                if(con) {
                    Intent selectIntent = new Intent(SearchActivity.this, SelectedActivity.class);
                    SearchActivity.this.startActivity(selectIntent);
                }
            }
        });
    }
}

