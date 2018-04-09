package com.example.android.todolistbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] myDataSet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataSet = new String[1000];

        mRecyclerView = findViewById(R.id.recycler_view_main);

        //If content does not change, improves performances
        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        mAdapter = new MyAdapter(myDataSet);
        mRecyclerView.setAdapter(mAdapter);
    }
}
