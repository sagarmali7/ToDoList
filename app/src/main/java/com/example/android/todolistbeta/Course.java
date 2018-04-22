package com.example.android.todolistbeta;

/**
 * Created by kellyzelaya on 4/9/18.
 */

public class Course {
    String courseName;
    String courseNumber;
    String courseTaskNumber;

    public Course(String courseName, String courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
    }

    String getCourseName (){
        return courseName;
    }

    String getCourseNumber(){
        return courseNumber;
    }

    void setCourseName(String name){
        this.courseName = name;
    }

    void setCourseNumber(String number){
        this.courseNumber = number;
    }

}
