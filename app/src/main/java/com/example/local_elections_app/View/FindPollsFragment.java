package com.example.local_elections_app.View;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.local_elections_app.Controller.LocationController;
import com.example.local_elections_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindPollsFragment extends Fragment {
    LocationController locationController;
    TextView locationText;

    public FindPollsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_find_polls, container, false);
        // TextView, Button, LocationController 선언
        locationText = v.findViewById(R.id.text_current_location);
        locationController = new LocationController(getActivity(),locationText);
        Button findBtn = v.findViewById(R.id.findBtn);

        // Locate the user's current location
        locationController.checkLocationPermission();
        locationController.reverseCoding();
        locationController.findUserLocation();

        // Button Event
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return  v;
    }

}
