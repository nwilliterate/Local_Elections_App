package com.example.local_elections_app.View;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.local_elections_app.Controller.LocationController;
import com.example.local_elections_app.Model.Params;
import com.example.local_elections_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindCandidateBySiteFragment extends Fragment {
    LocationController locationController;
    TextView locationText;
    Params params;

    public FindCandidateBySiteFragment() {
        // Required empty public constructor
        params = new Params(2, "서울특별시", null, 0);
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
        // TextView, Spinner, Button, LocationController 선언
        Spinner typeCandidateSpinner = v.findViewById(R.id.types_candidate_spinner);
        locationText = v.findViewById(R.id.text_current_location);
        locationController = new LocationController(getActivity(),locationText);
        Button findBtn = v.findViewById(R.id.findBtn);

        // Locate the user's current location
        locationController.checkLocationPermission();
        locationController.reverseCoding();
        locationController.findUserLocation();

        // Spinner Using ArrayAdapter
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.types_candidate, R.layout.custom_spinner_list);
        adapter.setDropDownViewResource(R.layout.customer_spinner);
        typeCandidateSpinner.setAdapter(adapter);


        // Spinner Event
        typeCandidateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                params.setSgTypeCode((position < 5) ? position + 2 : position + 3);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        // Button Event
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create View
            }
        });

        return  v;
    }
}
