package com.hoangvo.restaurantapp;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NearbyActivity extends AppCompatActivity {

    private static final int REQUEST_LOCATION = 1;
    ListView listView;
    LocationManager locationManager;
    String lattitude,longitude;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.titlemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                Intent logoutIntent = new Intent(NearbyActivity.this, MainActivity.class);
                NearbyActivity.this.startActivity(logoutIntent);
                return true;
            case R.id.home:
                Intent optionIntent = new Intent(NearbyActivity.this, OptionActivity.class);
                NearbyActivity.this.startActivity(optionIntent);
                return true;
            case R.id.mylist:
                Intent listIntent = new Intent(NearbyActivity.this, ListActivity.class);
                NearbyActivity.this.startActivity(listIntent);
                return true;
            case R.id.random:
                Intent randomIntent = new Intent(NearbyActivity.this, RandomActivity.class);
                NearbyActivity.this.startActivity(randomIntent);
                return true;
            case R.id.nearby:
                Intent nearbyIntent = new Intent(NearbyActivity.this, NearbyActivity.class);
                NearbyActivity.this.startActivity(nearbyIntent);
                return true;
            case R.id.groups:
                Intent groupsIntent = new Intent(NearbyActivity.this, NearbyActivity.class);
                NearbyActivity.this.startActivity(groupsIntent);
                return true;
            case R.id.help:
                Intent helpIntent = new Intent(NearbyActivity.this, HelpActivity.class);
                NearbyActivity.this.startActivity(helpIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        listView = (ListView) findViewById(R.id.list_view);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            getLocation();
        }
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(NearbyActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (NearbyActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(NearbyActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            System.out.println("location is null: " + location == null);
            if (location != null) {
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);
//                new GetPlacesTask().execute("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" +
//                        latti + "," + longi + "&rankby=distance&types=restaurant&key=AIzaSyAR7gF4UakpovhdBGSVckgXEdFX1zC_cm4");
                new GetPlacesTask().execute("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=44.974698,-93.232075&rankby=distance&types=restaurant&key=AIzaSyAR7gF4UakpovhdBGSVckgXEdFX1zC_cm4");
            }else{
                new GetPlacesTask().execute("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=44.974698,-93.232075&rankby=distance&types=restaurant&key=AIzaSyAR7gF4UakpovhdBGSVckgXEdFX1zC_cm4");
            }
        }
    }

    protected void buildAlertMessageNoGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please Turn ON your GPS Connection")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private class GetPlacesTask extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params)
        {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while((line = reader.readLine()) != null){
                    buffer.append(line+"\n");
                }
                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }finally {
                if(connection != null){
                    connection.disconnect();
                }
                try {
                    if(reader != null){
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result)
        {
            super.onPostExecute(result);

            try {
                JSONObject jObject = new JSONObject(result);
                JSONArray jArray = jObject.getJSONArray("results");

                ArrayList<String> res = new ArrayList<String>();
                ArrayList<JSONObject> temp = new ArrayList<JSONObject>();

                for(int i = 0; i < jArray.length(); i++){
                    JSONObject obj = jArray.getJSONObject(i);
                    temp.add(obj);
                    res.add(obj.getString("name"));
                }

                Globals g = (Globals) getApplication();
                g.nRes = new ArrayList<JSONObject>(temp);

                MyAdapter adapter = new MyAdapter(NearbyActivity.this, res);
                listView.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

