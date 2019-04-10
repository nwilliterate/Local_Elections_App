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

import com.example.local_elections_app.R;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindCandidateBySiteFragment extends Fragment {

    Geocoder geocoder;
    double latitude, longitude;
    TextView locationText;
    LocationManager lm;

    public FindCandidateBySiteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        // 권한 체크
        int permissionCheck1 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.INTERNET);
        if (permissionCheck1 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET}, 1);
        int permissionCheck2 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION);
        if (permissionCheck2 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        int permissionCheck3 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck3 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);


    }

    @Override
    public void onStop() {
        super.onStop();
        lm.removeUpdates(mLocationListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_find_candidate_by_site, container, false);
        locationText = v.findViewById(R.id.text_current_location);

        geocoder = new Geocoder(getActivity());
        reverseCoding1();

        lm = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        try {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1, mLocationListener);
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100, 1, mLocationListener);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        return  v;
    }

    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitude = location.getLongitude(); //경도
            latitude = location.getLatitude();   //위도
            reverseCoding1();
        }
        public void onProviderDisabled(String provider) { }
        public void onProviderEnabled(String provider) { }
        public void onStatusChanged(String provider, int status, Bundle extras) { }
    };

    public void reverseCoding1() {
        // 권한 체크
        int permissionCheck1 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.INTERNET);
        if (permissionCheck1 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET}, 1);
        int permissionCheck2 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION);
        if (permissionCheck2 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        int permissionCheck3 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck3 == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);




        List<Address> list = null;
        if (latitude == 0 && longitude == 0)
            return;
        try {
            list = geocoder.getFromLocation(latitude, longitude, 10); // 위도, 경도, 얻어올 값의 개수
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "오류", Toast.LENGTH_SHORT).show();
            Log.e("test", "입출력 오류 - 서버에서 주소변환시 에러발생");
        }
        if (list != null) {
            if (list.size() == 0) {
                locationText.setText("해당되는 주소 정보는 없습니다");
            } else {
                //locationText.setText(list.get(0).toString());

                // 문자열을 자르자!
                String cut[] = list.get(0).toString().split(" ");
                for (int i = 0; i < cut.length; i++) {
                    System.out.println("cut[" + i + "] : " + cut[i]);
                } // cut[0] : Address[addressLines=[0:"대한민국
                // cut[1] : 서울특별시  cut[2] : 송파구  cut[3] : 오금동
                // cut[4] : cut[4] : 41-26"],feature=41-26,admin=null ~~~~
                locationText.setText(cut[1] + " " + cut[2] + " " + cut[3]); // 내가 원하는 구의 값을 뽑아내 출력
            }
        }
    }

}
