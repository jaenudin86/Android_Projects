package com.example.thomas.activitymonitor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MapActivity extends FragmentActivity implements android.location.LocationListener, OnMapReadyCallback
{
    // Initialise constants
    LocationManager locationManager;
    private GoogleMap googleMap;
    private DatabaseReference database;
    int updateTime = 200;
    int updateDistance = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapactivitylayout);
        // Set up database reference and location manager
        database = FirebaseDatabase.getInstance().getReference();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            // Return if permissions are not granted
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                return;
            }
            // Request location updates
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, updateTime, updateDistance, this);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, updateTime, updateDistance, this);
        } catch (Exception e) {
            Log.e("GPS", "exception occurred " + e.getMessage());
        }
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded()
    {
        // Check if the map is already instantiated
        if (googleMap == null)
        {
            // Get map using SupportMapFragment.
            ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap map)
    {
        googleMap = map;
        // Check if the map was obtained
        if (googleMap != null)
        {
            setUpMap();
        }
    }

    private void setUpMap()
    {
        final DatabaseReference ref = database.child("locations").getRef();

        // Attach a listener to read the data
        ref.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for (DataSnapshot locSnapshot: dataSnapshot.getChildren()) {
                    LocationData loc = locSnapshot.getValue(LocationData.class);
                    // Check if location data is received
                    if (loc != null)
                    {
                        // Add a marker at the location downloaded
                        googleMap.addMarker(new MarkerOptions().position(new LatLng(loc.latitude, loc.longitude)));
                    }
                }
                ref.removeEventListener(this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public void onLocationChanged(Location arg0)
    {
        // Add marker at the current location on the map
        googleMap.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())));
        // Get current date and time
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        String dateTime = sdf.format(cal.getTime());
        // Create a new Location Data object
        LocationData locationData = new LocationData(arg0.getLatitude(), arg0.getLongitude(), dateTime);
        // Upload LocationData object to the database
        database.child("locations").push().setValue(locationData);
    }

    public void onProviderDisabled(String arg0)
    {
        Log.e("GPS", "provider disabled " + arg0);
    }

    public void onProviderEnabled(String arg0)
    {
        Log.e("GPS", "provider enabled " + arg0);
    }

    public void onStatusChanged(String arg0, int arg1, Bundle arg2)
    {
        Log.e("GPS", "status changed to " + arg0 + " [" + arg1 + "]");
    }
}
