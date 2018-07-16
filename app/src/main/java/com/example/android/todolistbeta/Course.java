package com.example.android.todolistbeta;

import java.util.ArrayList;
import java.util.List;

public class Course {
    String courseName;
    int courseNumber;
    List<Task> courseTasks;

    public Course(String courseName, int courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.courseTasks = new ArrayList<>();
    }

    String getCourseName (){ return courseName; }
    int getCourseNumber() { return courseNumber; }

    void setCourseName(String name){
        this.courseName = name;
    }

    void setCourseNumber(int number){
        this.courseNumber = number;
    }

    void addTask(Task newTask){
        this.courseTasks.add(newTask);
    }

}
