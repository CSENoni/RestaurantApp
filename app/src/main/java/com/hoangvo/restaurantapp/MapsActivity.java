package com.hoangvo.restaurantapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Globals g = (Globals) getApplication();
        Bundle bundle = getIntent().getExtras();
        int pos = bundle.getInt("pos");
        JSONObject jsonRes = g.nRes.get(pos);
        try {
            double lat = jsonRes.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
            double lng = jsonRes.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
            // Add a marker in Sydney and move the camera
            LatLng loc = new LatLng(lat, lng);
            mMap.addMarker(new MarkerOptions().position(loc).title(jsonRes.getString("name")));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mMap.setMyLocationEnabled(true);

            Button zoomOut = (Button) findViewById(R.id.zoomOut);
            Button zoomIn = (Button) findViewById(R.id.zoomIn);

            zoomOut.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    mMap.animateCamera(CameraUpdateFactory.zoomOut());
                }
            });

            zoomIn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    mMap.animateCamera(CameraUpdateFactory.zoomIn());
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
