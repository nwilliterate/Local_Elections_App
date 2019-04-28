package com.example.local_elections_app.Unit;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.local_elections_app.Model.Candidate;
import com.example.local_elections_app.Model.Polls;
import com.example.local_elections_app.R;

import java.util.ArrayList;

public class CustomList {

    public static class CnddCustomList extends ArrayAdapter<String> {
        private  final Activity context;
        private ArrayList<Candidate> candidates;

        public CnddCustomList(Activity context, ArrayList<Candidate> hCandidates) {
            super(context, R.layout.custom_list_item_candidate, new String[hCandidates.size()]);
            this.context = context;
            candidates = hCandidates;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.custom_list_item_candidate, null, true);
            ImageView image = (ImageView) rowView.findViewById(R.id.candidateImage);
            TextView name = (TextView) rowView.findViewById(R.id.candidateName);
            TextView profile = (TextView) rowView.findViewById(R.id.candidateProfile);

            name.setText(candidates.get(position).getName());
            image.setImageResource(R.drawable.ic_launcher_background);
            profile.setText(candidates.get(position).getCareer1() + "\n" + candidates.get(position).getCareer2());

            return rowView;
        }
    }

    public static class PollsCustomList extends ArrayAdapter<String>{
        private final Activity context;
        ArrayList<Polls> pollsArrayList;

        public PollsCustomList(Activity context, ArrayList<Polls> hPollsArrayList) {
            super(context, R.layout.custom_list_item_candidate, new String[hPollsArrayList.size()]);
            this.context = context;
            pollsArrayList = hPollsArrayList;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.custom_list_item_candidate, null, true);
            TextView name = (TextView) rowView.findViewById(R.id.psName);
            TextView addr1 = (TextView) rowView.findViewById(R.id.addr1);
            TextView addr2 = (TextView) rowView.findViewById(R.id.addr2);

            name.setText(pollsArrayList.get(position).getPsName());
            addr1.setText(pollsArrayList.get(position).getSdName() + pollsArrayList.get(position).getWiwName() +
                    pollsArrayList.get(position).getEmdName() + pollsArrayList.get(position).getPlaceName());
            addr2.setText(pollsArrayList.get(position).getAddr() + pollsArrayList.get(position).getFloor());

            return rowView;
        }
    }
}
