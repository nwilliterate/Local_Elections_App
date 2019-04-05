package com.example.local_elections_app.View;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.local_elections_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectionsInfo1Fragment extends Fragment {
    public static ElectionsInfo1Fragment newInstance(){
        return new ElectionsInfo1Fragment();
    }

    public ElectionsInfo1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elections_info1, container, false);
    }

}
