package com.example.android.todolistbeta;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Created by kellyzelaya on 4/10/18.
 */

public class CourseMake extends AppCompatActivity {

    FloatingActionButton caldendarButton;
    final Calendar myCalendar = Calendar.getInstance();
    EditText currDate;
    EditText courseName;
    CheckBox checkBox;
    FloatingActionButton addButton;
    EditText task;
    TextView taskToBeDone;

    FloatingActionButton addTime;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_maker);

        currDate = findViewById(R.id.data_saver);
        caldendarButton = findViewById(R.id.calendar);
        // myCalendar  = Calendar.getInstance(); // Returns calendar fields that have been
        //Initialized with the current date and time


        checkBox = findViewById(R.id.check_box);
        addButton = findViewById(R.id.add_course);
        task = findViewById(R.id.Task_done);
        taskToBeDone= findViewById(R.id.task_to_be_done);
        addTime = findViewById(R.id.time);

        courseName = findViewById(R.id.course_name);


        //Sets the calendar to the current year, month and day of the month
        //When selected. The fields are pre-selected.
        //They always stay the same, no matter
        //The listener used to indicate the user has finished selecting a date.
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view,int year, int monthOfYear,int dayOfMonth){
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updatelabel(); //Puts date on text view
            }
        };



        //Once the button is clicked, shows a "dialog" box of the calendar with the
        //current YEAR, MONTH, DAY OF THE MONTH
        //When this comes up, calls the date method
        caldendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CourseMake.this,date,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        currDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CourseMake.this,date,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });




        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBox.isChecked()){
                    caldendarButton.setVisibility(View.INVISIBLE);
                    currDate.setVisibility(View.INVISIBLE);
                    task.setVisibility(View.INVISIBLE);
                    taskToBeDone.setVisibility(View.INVISIBLE);

                }
                else {
                    caldendarButton.setVisibility(View.VISIBLE);
                    currDate.setVisibility(View.VISIBLE);
                    task.setVisibility(View.VISIBLE);
                    taskToBeDone.setVisibility(View.VISIBLE);
                }
            }
        });




        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
 {

        }

    }





    //This gives you the correct format you want
    //SimpleDateFormat is the thing that affects what is displayed
    //MyCalendar fields are always set behind the scenes
    private void updatelabel(){
        String myFormat = "EE, MMM dd, yyyy"; // Gives you the format you want for date
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat,Locale.US);

        currDate.setText(sdf.format(myCalendar.getTime()));
        //currDate.setText(sdf.format(myCalendar.getTime()));

    }


}
