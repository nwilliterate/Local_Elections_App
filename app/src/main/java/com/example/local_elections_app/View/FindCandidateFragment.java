package com.example.local_elections_app.View;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.local_elections_app.Controller.CommController;
import com.example.local_elections_app.Model.Params;
import com.example.local_elections_app.R;
import com.example.local_elections_app.Unit.CustomList;
import com.example.local_elections_app.Unit.JSONParser;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindCandidateFragment extends Fragment {
    Params params;

    public FindCandidateFragment() {
        // Required empty public constructor
        params = new Params(2, "서울특별시",null, 0);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_find_candidate, container, false);

        // Spinner, Button 선언
        Spinner typeCandidateSpinner = v.findViewById(R.id.types_candidate_spinner);
        Spinner citySpinner = v.findViewById(R.id.city_spinner);
        Button findBtn = v.findViewById(R.id.findBtn);

        // Spinner Using ArrayAdapter
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.types_candidate, R.layout.custom_spinner_list);
        adapter.setDropDownViewResource(R.layout.customer_spinner);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.city, R.layout.custom_spinner_list);
        adapter2.setDropDownViewResource(R.layout.customer_spinner);
        typeCandidateSpinner.setAdapter(adapter);
        citySpinner.setAdapter(adapter2);

        // Spinner Event
        typeCandidateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                params.setSgTypeCode((position < 5) ? position + 2 : position + 3);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                params.setSdName(String.valueOf(parent.getItemAtPosition(position)));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        // Button Event
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create List
                CustomList.CnddCustomList cnddCustomList = new CustomList.CnddCustomList(getActivity(),
                        JSONParser.CadidateParser(CommController.recvResponse(params)));
                ListView listView = v.findViewById(R.id.list_view);
                listView.setAdapter(cnddCustomList);
            }
        });

         return  v;
    }

}
