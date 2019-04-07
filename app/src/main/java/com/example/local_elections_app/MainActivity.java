package com.example.local_elections_app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.local_elections_app.View.ElectionsInfoMainFragment;
import com.example.local_elections_app.View.FindCandidateBySiteFragment;
import com.example.local_elections_app.View.FindCandidateFragment;
import com.example.local_elections_app.View.FindPollsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ElectionsInfoMainFragment electionsInfoMainFragment;
    private FindCandidateFragment findCandidateFragment;
    private FindCandidateBySiteFragment findCandidateBySiteFragment;
    private FindPollsFragment findPollsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // DrawerLayout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        // NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // 프래그먼트 초기화
        electionsInfoMainFragment = new ElectionsInfoMainFragment();
        findCandidateFragment = new FindCandidateFragment();
        findCandidateBySiteFragment = new FindCandidateBySiteFragment();
        findPollsFragment = new FindPollsFragment();

        // MainActivity 첫 화면
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container,electionsInfoMainFragment).commit();

        // BottomBar Fragment
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fr = null;

                switch (item.getItemId()) {
                    case R.id.navigation_elections_info:    // 선거 정보 프래그먼트
                        fr=electionsInfoMainFragment;
                        break;
                    case R.id.navigation_find_candidate:    // 후보자 검색 프래그먼트
                        fr=findCandidateFragment;
                        break;
                    case R.id.navigation_find_candidate_by_site:    // 사용자 위치에서 후보자 검색 프래그먼트
                        fr=findCandidateBySiteFragment;
                        break;
                    case R.id.navigation_find_polls:                // 사용자 위치에서 투표소 검색 프래그먼트
                        fr=findPollsFragment;
                        break;
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fr).commit();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
