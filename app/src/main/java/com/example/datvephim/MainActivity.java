package com.example.datvephim;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.datvephim.fragment.placeholder.BookingFragment;
import com.example.datvephim.fragment.placeholder.ContactFragment;
import com.example.datvephim.fragment.placeholder.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int Fragment_home = 0;
    private static final int Fragment_booking = 1;
    private static final int Fragment_contact = 2;
    private int mCurrentFragment = Fragment_home;

    private DrawerLayout mDrawrlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mDrawrlayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawrlayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawrlayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationview = findViewById(R.id.navigation_view);
        navigationview.setNavigationItemSelectedListener(this);

        replaceFragment(new HomeFragment());
        navigationview.getMenu().findItem(R.id.nav_btn_home).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_btn_home){
            if(mCurrentFragment != Fragment_home){
                replaceFragment(new HomeFragment());
                mCurrentFragment = Fragment_home;
            }
        } else if(id == R.id.nav_btn_booking){
            replaceFragment(new BookingFragment());
            mCurrentFragment = Fragment_booking;
        } else if(id == R.id.nav_btn_contact){
            replaceFragment(new ContactFragment());
            mCurrentFragment = Fragment_contact;
        }

        mDrawrlayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawrlayout.isDrawerOpen(GravityCompat.START)){
            mDrawrlayout.closeDrawer(GravityCompat.START);
        }else{
            moveTaskToBack(true);
        }
    }

    private void replaceFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
}