package com.example.antsoft.animation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.antsoft.animation.App;
import com.example.antsoft.animation.FontButton;
import com.example.antsoft.animation.FontTextView;
import com.example.antsoft.animation.R;

import java.util.List;

public class TestAdapter extends
        RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private List<String> list;
    public Context context;
    ViewHolder viewHolder;
    App app = new App();
    int lastPosition = -1;

    public TestAdapter(List<String> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void onBindViewHolder(final ViewHolder viewHolder,
                                 final int position) {
        viewHolder.textView.setText("hello android " + position);

        viewHolder.btnfont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                viewHolder.btnfont.setFont("test.ttf");
//                app.setFont();
            }

        });
        if(position >lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            viewHolder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        //Inflate the layout, initialize the View Holder
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null);

        viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // initializes textview and imageview to be used by RecyclerView.
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public FontTextView textView;
        public FontButton btnfont;

        public ViewHolder(View view) {
            super(view);

            textView =  view.findViewById(R.id.text);
            btnfont =  view.findViewById(R.id.btn_font);
        }
    }
}