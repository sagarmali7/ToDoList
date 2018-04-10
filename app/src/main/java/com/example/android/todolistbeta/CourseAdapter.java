package com.example.android.todolistbeta;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kellyzelaya on 4/9/18.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {
    private List<Course> courses;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView coursename, coursenumber;


        public MyViewHolder(View v) {
            super(v);
            coursename = v.findViewById(R.id.course_name);
            coursenumber = v.findViewById(R.id.course_number);
        }
    }


    public CourseAdapter(List <Course> courses){
        this.courses = courses;
    }



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_layout,parent,false);
            return new MyViewHolder(itemView);
        }



        @Override
        public void onBindViewHolder(MyViewHolder holder, int position){
            Course course = courses.get(position);
            holder.coursename.setText(course.getCourseName());
            holder.coursenumber.setText(course.getCourseNumber());
        }


        @Override
        public int getItemCount(){
            return courses.size();
        }


    }
