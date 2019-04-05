package com.example.local_elections_app.View;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.local_elections_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectionsInfoMainFragment extends Fragment {


    public ElectionsInfoMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_elections_info_main, container, false);

        getFragmentManager().beginTransaction()
                .add(R.id.info_container, ElectionsInfo1Fragment.newInstance()).commit();

        Button btn1,btn2,btn3;
        btn1=(Button)v.findViewById(R.id.btn1);
        btn2=(Button)v.findViewById(R.id.btn2);
        btn3=(Button)v.findViewById(R.id.btn3);

        // 선거 개요 프래그먼트 버튼
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.info_container,ElectionsInfo1Fragment.newInstance()).commit();
            }
        });

        // 선거 일정 프래그먼트 버튼
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.info_container, ElectionsInfo2Fragment.newInstance()).commit();
            }
        });

        // 선거 시 주의사항 프래그먼트 버튼
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.info_container, ElectionsInfo3Fragment.newInstance()).commit();
            }
        });

        return v;
    }

}
