package com.example.behnam.exercise;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import ernestoyaquello.com.verticalstepperform.VerticalStepperFormLayout;
import ernestoyaquello.com.verticalstepperform.interfaces.VerticalStepperForm;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity  {
    my_AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/iran_sans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

//--------------------------------------------------------------
        bottomNavigation = (my_AHBottomNavigation) findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (position == 0) {
                    /*
                    Fragment_info infoFragment = new Fragment_info();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_id, infoFragment).commit();*/
                    Intent i=new Intent(MainActivity.this,NewAlarmFormActivity.class);
                    startActivity(i);
                } else if (position == 1) {
                    Fragment_charts chartsFragment = new Fragment_charts();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_id, chartsFragment).commit();
                } else if (position == 2) {
                    Fragment_home homeFragment = new Fragment_home();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_id, homeFragment).commit();
                } else if (position == 3) {
                    Fragment_message messageFragment = new Fragment_message();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_id, messageFragment).commit();
                } else if (position == 4) {
                    Fragment_profile progileFragment = new Fragment_profile();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_id, progileFragment).commit();

                }
                return true;
            }
        });
        bottomNavigation.setCurrentItem(2);
        //---------------------------------------------------------------
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



}
