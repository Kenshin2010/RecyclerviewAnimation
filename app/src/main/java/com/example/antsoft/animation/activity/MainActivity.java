package com.example.antsoft.animation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.antsoft.animation.R;
import com.example.antsoft.animation.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<String>();
    TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList();
        mAdapter = new TestAdapter(list, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void arrayList() {
        for (int i = 0; i < 1000; i++) {
            list.add("This is row of number " + i);
        }
    }
}
