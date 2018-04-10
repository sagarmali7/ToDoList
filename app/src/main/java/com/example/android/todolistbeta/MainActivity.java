package com.example.android.todolistbeta;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Course> courseList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CourseAdapter mCourseAdapter;
    private FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References the recycler view
        recyclerView = findViewById(R.id.recycler_view_main);

        //Sets up the adapter with the array list that will hold the courses
        mCourseAdapter = new CourseAdapter(courseList);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        //Sets up the layout manager
        recyclerView.setLayoutManager(layoutManager);

        //This provides the child view for each section in the recycler view
        recyclerView.setAdapter(mCourseAdapter);


        prepareCourseList();

    }


    

    private void prepareCourseList() {
        Course course1 = new Course("CMSC131", "Number of tasks: 3");
        courseList.add(course1);

        Course course2 = new Course("CMSC132", "Number of tasks: 5");
        courseList.add(course2);

        Course course3 = new Course("ENEE205", "Number of tasks: 2");
        courseList.add(course3);

        Course course4 = new Course("ENEE222", "Number of tasks: 1");
        courseList.add(course4);

        Course course5 = new Course("ENEE322", "Number of tasks: 10");
        courseList.add(course5);

        Course course6 = new Course("ENEE303", "Number of tasks: 0");
        courseList.add(course6);

        Course course7 = new Course("ENEE307", "Number of tasks: 6");
        courseList.add(course7);

        Course course8 = new Course("MATH241", "Number of tasks: 0");
        courseList.add(course8);

        mCourseAdapter.notifyDataSetChanged();
    }
}
