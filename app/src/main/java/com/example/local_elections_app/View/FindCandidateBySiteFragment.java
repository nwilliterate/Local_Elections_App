package com.example.local_elections_app.View;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.local_elections_app.Controller.LocationController;
import com.example.local_elections_app.R;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindCandidateBySiteFragment extends Fragment {
    LocationController locationController;
    TextView locationText;

    public FindCandidateBySiteFragment() {
        // Required empty public constructor

    }

    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_find_candidate_by_site, container, false);
        locationText = v.findViewById(R.id.text_current_location);
        locationController = new LocationController(getActivity(),locationText);

        // Locate the user's current location
        locationController.checkLocationPermission();
        locationController.reverseCoding();
        locationController.findUserLocation();

        return  v;
    }
}
