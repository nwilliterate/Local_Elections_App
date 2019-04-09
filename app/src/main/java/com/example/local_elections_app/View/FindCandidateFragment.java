package com.example.local_elections_app.View;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.example.local_elections_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindCandidateFragment extends Fragment {


    public FindCandidateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_find_candidate, container, false);

         // Spinner 선언
        Spinner voteSpinner = (Spinner) v.findViewById(R.id.vote_spinner);
        Spinner citySpinner = (Spinner) v.findViewById(R.id.city_spinner);
        Button findBtn = v.findViewById(R.id.searchBtn);

         return  v;
    }

}
