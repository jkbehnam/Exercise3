package com.example.behnam.exercise;

import android.content.Context;
import android.util.AttributeSet;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

/**
 * Created by behnam on 4/18/2018.
 */

public class my_AHBottomNavigation extends AHBottomNavigation {
    public my_AHBottomNavigation(Context context) {
        super(context);
        this.createNavItems();
    }

    public my_AHBottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.createNavItems();
    }

    public my_AHBottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.createNavItems();
    }
    private void createNavItems() {
        //CREATE ITEMS
        AHBottomNavigationItem infoItem = new AHBottomNavigationItem(R.string.info, R.drawable.icon_info_navigationbar, R.color.colorBottomNavigationAccent);
        AHBottomNavigationItem profileItem = new AHBottomNavigationItem(R.string.profile, R.drawable.icon_profile_navigationbar, R.color.colorBottomNavigationAccent);
        AHBottomNavigationItem homeItem = new AHBottomNavigationItem(R.string.home, R.drawable.icon_home_navigationbar, R.color.colorBottomNavigationAccent);
        AHBottomNavigationItem messageItem = new AHBottomNavigationItem(R.string.message, R.drawable.icon_message_navigationbar, R.color.colorBottomNavigationAccent);
        AHBottomNavigationItem chartsItem = new AHBottomNavigationItem(R.string.chart, R.drawable.icon_chart_navigationbar, R.color.colorBottomNavigationAccent);

        //ADD THEM to bar
        this.addItem(infoItem);
        this.addItem(chartsItem);
        this.addItem(homeItem);
        this.addItem(messageItem);
        this.addItem(profileItem);


        //set properties
        //bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        //set current item

        this.setForceTint(true);
        this.setTranslucentNavigationEnabled(true);
        this.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);

        this.setNotification("1", 3);
        this.setBehaviorTranslationEnabled(true);


    }

}
