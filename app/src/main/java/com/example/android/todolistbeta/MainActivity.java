package com.example.android.todolistbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Course> courseList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CourseAdapter mCourseAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_main);

        mCourseAdapter = new CourseAdapter(courseList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mCourseAdapter);


        prepareCourseList();


    }


    private void prepareCourseList() {
        Course course1 = new Course("CMSC", "131");
        courseList.add(course1);

        Course course2 = new Course("CMSC", "132");
        courseList.add(course2);



        mCourseAdapter.notifyDataSetChanged();
    }
}
