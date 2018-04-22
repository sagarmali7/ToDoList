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

        button = findViewById(R.id.floating_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CourseMake.class);
                startActivity(intent);

            }
        });
    }

    private void prepareCourseList() {
        Course course1 = new Course("CMSC131", "Number of tasks: 3");
        courseList.add(course1);

        Course course2 = new Course("CMSC131", "Number of tasks: 3");
        courseList.add(course2);

        Course course3 = new Course("CMSC131", "Number of tasks: 3");
        courseList.add(course3);

        mCourseAdapter.notifyDataSetChanged();
    }
}
