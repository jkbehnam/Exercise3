package com.example.behnam.exercise.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.behnam.exercise.MyCustomComponent.JustifyTexts.TextViewEx;
import com.example.behnam.exercise.R;
import com.example.behnam.exercise.objects.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by behnam_b on 7/5/2016.
 */
public class adapter_home_recycle extends RecyclerView.Adapter<adapter_home_recycle.MyViewHolder> {
    private List<Object_HomeRecycleView> data_services_list;


    OnCardClickListner onCardClickListner;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextViewEx card_title, card_info;
        public ImageView card_image;
        public CardView CV;
        public MyViewHolder(View view) {
            super(view);
            card_title = (TextViewEx) view.findViewById(R.id.home_card_title);
            card_info = (TextViewEx) view.findViewById(R.id.home_card_info);
            card_image= (ImageView)view.findViewById(R.id.home_card_image) ;
            CV = (CardView) view.findViewById(R.id.cardview_be_intelligent);
            // Toast.makeText(view.getContext(),"تست", Toast.LENGTH_SHORT).show();


        }
    }


    public adapter_home_recycle(ArrayList<Object_HomeRecycleView> data_services_list) {
        this.data_services_list = data_services_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_recycleview_cardview, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Object_HomeRecycleView data_service = data_services_list.get(position);


        holder.card_title.setText(data_service.getMainText(), true);
        holder.card_info.setText(data_service.getSubText());
        holder.card_image.setImageResource(data_service.getMianImage());
        holder.CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCardClickListner.OnCardClicked(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_services_list.size();
    }

    public interface OnCardClickListner {
        void OnCardClicked(View view, int position);
    }

    public void setOnCardClickListner(OnCardClickListner onCardClickListner) {
        this.onCardClickListner = onCardClickListner;
    }
}