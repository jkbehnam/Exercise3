
package com.example.behnam.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.behnam.exercise.objects.Object_HomeRecycleView;
import com.example.behnam.exercise.adapters.*;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;


public class Fragment_home extends Fragment {
    ArrayList<Object_HomeRecycleView> OH_list;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);




        final FragmentActivity c = getActivity();
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.HomeRecycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        OH_list = new ArrayList<>();
        OH_list.add(new Object_HomeRecycleView("ثبت شاخص های امروز", "ff", R.drawable.icon_plus_recyclerview));
        OH_list.add(new Object_HomeRecycleView("ورزش", " b", R.drawable.icon_ridingbike_recyclerview));
        OH_list.add(new Object_HomeRecycleView("روان", "b ", R.drawable.icon_sleeping_recyclerview));
        OH_list.add(new Object_HomeRecycleView("آموزش", " b", R.drawable.icon_chromecast_recyclerview));


        adapter_home_recycle madapter = new adapter_home_recycle(OH_list);
        SlideInBottomAnimationAdapter alphaAdapter = new SlideInBottomAnimationAdapter(madapter);
        alphaAdapter.setFirstOnly(true);
        recyclerView.setAdapter(alphaAdapter);

        madapter.setOnCardClickListner(new adapter_home_recycle.OnCardClickListner() {
            @Override
            public void OnCardClicked(View view, int position) {
                switch (position){
                    case 0:
                        Toast.makeText(c, "0", Toast.LENGTH_SHORT).show();
                      //  Intent i=new Intent(c,NewAlarmFormActivity.class);
                      //  startActivity(i);


                        Fragment_AddDailyData AddDailyData = new Fragment_AddDailyData();
                        c.getSupportFragmentManager().beginTransaction().replace(R.id.content_id, AddDailyData).commit();
                        break;
                    case 1:
                        Toast.makeText(c, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(c, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(c, "3", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        return rootView;
    }
}