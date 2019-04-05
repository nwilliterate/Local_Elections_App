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
public class ElectionsInfo3Fragment extends Fragment {
    public static ElectionsInfo3Fragment newInstance(){
        return new ElectionsInfo3Fragment();
    }

    public ElectionsInfo3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elections_info3, container, false);
    }

}
