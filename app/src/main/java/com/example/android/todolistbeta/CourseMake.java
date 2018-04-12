package com.example.android.todolistbeta;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Created by kellyzelaya on 4/10/18.
 */

public class CourseMake extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_maker);

        FloatingActionButton caldendarButton = findViewById(R.id.calendar);
        final Calendar myCalendar  = Calendar.getInstance(); // Returns calendar fields that have been
        //Initialized with the current date and time



        //Sets the calendar to the current year, month and day of the month
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view,int year, int monthOfYear,int dayOfMonth){
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            }
        };



        //Once the button is clicked, shows a "dialog" box of the calendar with the
        //current YEAR, MONTH, DAY OF THE MONTH
        caldendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CourseMake.this,date,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



    }



}
