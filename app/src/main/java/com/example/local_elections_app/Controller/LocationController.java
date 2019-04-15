package com.example.local_elections_app.Controller;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class LocationController {

    private TextView locationText;
    private Activity currentActivity;
    private double latitude = 0, longitude = 0;

    private Geocoder geocoder;
    private LocationManager locationManager;

    public LocationController(Activity activity, TextView textView) {
        currentActivity = activity;
        locationText = textView;
        geocoder = new Geocoder(currentActivity);
    }

    public final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitude = location.getLongitude(); //경도
            latitude = location.getLatitude();   //위도
            reverseCoding();
        }
        public void onProviderDisabled(String provider) { }
        public void onProviderEnabled(String provider) { }
        public void onStatusChanged(String provider, int status, Bundle extras) { }
    };

    // Location Permission Check
    public boolean checkLocationPermission() {
        boolean permissionCheck = true;

        int permissionCheck1 = ContextCompat.checkSelfPermission(currentActivity, Manifest.permission.INTERNET);
        if (permissionCheck1 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(currentActivity, new String[]{Manifest.permission.INTERNET}, 1);
        else
            permissionCheck = false;
        int permissionCheck2 = ContextCompat.checkSelfPermission(currentActivity, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (permissionCheck2 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(currentActivity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        else
            permissionCheck = false;
        int permissionCheck3 = ContextCompat.checkSelfPermission(currentActivity, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck3 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(currentActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        else
            permissionCheck = false;

        return permissionCheck;
    }

    public void reverseCoding() {
        List<Address> list = null;

        // Error Check
        if (latitude == 0 && longitude == 0)
            locationText.setText("not found");
        try {
            list = geocoder.getFromLocation(latitude, longitude, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Split String
        if (list != null) {
            if (list.size() == 0) {
                locationText.setText("No address information");
            } else {
                String cut[] = list.get(0).toString().split(" ");
                for (int i = 0; i < cut.length; i++) {
                    System.out.println("cut[" + i + "] : " + cut[i]);
                }
                locationText.setText(cut[1] + " " + cut[2] + " " + cut[3]);
            }
        }
    }

    public void findUserLocation(){
        locationManager = (LocationManager) currentActivity.getSystemService(Context.LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 1, mLocationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 1, mLocationListener);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void removeLocationListener(){
        locationManager.removeUpdates(mLocationListener);
    }
}
