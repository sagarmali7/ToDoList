package com.example.android.todolistbeta;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import static com.example.android.todolistbeta.MainActivity.courseList;
import static com.example.android.todolistbeta.MainActivity.mCourseAdapter;


/**
 * Created by kellyzelaya on 4/10/18.
 */

public class CourseMake extends AppCompatActivity {

    //FloatingActionButton caldendarButton;
    final Calendar myCalendar = Calendar.getInstance();
    EditText currDate;
    EditText courseName;
    CheckBox checkBox;
    FloatingActionButton addButton;
    EditText task;
    //TextView taskToBeDone;

    static EditText timeEdit;

    TimePickerFragment timePick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_maker);

        timePick =  new TimePickerFragment();

        currDate = findViewById(R.id.date_saver);
        //caldendarButton = findViewById(R.id.calendar);
        // myCalendar  = Calendar.getInstance(); // Returns calendar fields that have been
        //Initialized with the current date and time

        checkBox = findViewById(R.id.check_box);
        addButton = findViewById(R.id.add_course);
        task = findViewById(R.id.Task_done);
        //taskToBeDone = findViewById(R.id.task_to_be_done);
        //addTime = findViewById(R.id.time);
        timeEdit = findViewById(R.id.time_edit);

        courseName = findViewById(R.id.course_name);

        //Sets the calendar to the current year, month and day of the month
        //When selected. The fields are pre-selected.
        //They always stay the same, no matter
        //The listener used to indicate the user has finished selecting a date.
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updatelabel(); //Puts date on text view
            }
        };

        //Once the button is clicked, shows a "dialog" box of the calendar with the
        //current YEAR, MONTH, DAY OF THE MONTH
        //When this comes up, calls the date method

        //removing calander button
        /*caldendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CourseMake.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });*/

        currDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CourseMake.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        //If check box is clicked, will display the
        //The task information

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkBox.isChecked()) {
                    //caldendarButton.setVisibility(View.INVISIBLE);
                    currDate.setVisibility(View.INVISIBLE);
                    task.setVisibility(View.INVISIBLE);
                    //taskToBeDone.setVisibility(View.INVISIBLE);
                    //addButton.setVisibility(View.INVISIBLE);
                    //addTime.setVisibility(View.INVISIBLE);
                    timeEdit.setVisibility(View.INVISIBLE);

                } else {
                    //caldendarButton.setVisibility(View.VISIBLE);
                    currDate.setVisibility(View.VISIBLE);
                    task.setVisibility(View.VISIBLE);
                    //taskToBeDone.setVisibility(View.VISIBLE);
                    //addButton.setVisibility(View.VISIBLE);
                    //addTime.setVisibility(View.VISIBLE);
                    timeEdit.setVisibility(View.VISIBLE);
                }
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseNameEdit = courseName.getText().toString();
                String taskEdit = task.getText().toString();
                if (courseNameEdit.matches("")) {
                    Toast.makeText(getBaseContext(), "Please enter course name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                else if (checkBox.isChecked()) {
                    if (courseNameEdit.matches("")) {
                        Toast.makeText(getBaseContext(), "Please enter course name!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    else if(taskEdit.matches("")) {
                        Toast.makeText(getBaseContext(), "Please enter task description!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    else {
                        finish();
                    }
                }
                else {
                    Course newCourse = new Course(courseNameEdit, "Number of Tasks: 99");
                    courseList.add(newCourse);
                    mCourseAdapter.notifyDataSetChanged();
                    finish();
                }
                /*else if (!checkBox.isChecked()) {

                }*/

            }
        });

       /* addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(v);
            }
        });*/


        timeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(v);
            }
        });
    }

    //Class that allows you to put a clock onto the app

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstance){
            final Calendar c = Calendar.getInstance(); //Need to get current time and hour
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            //Displays the clock  when someone picks the time
            return new TimePickerDialog(getActivity(),this,hour, minute, false);
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute){
            int h = hourOfDay;
            int m = minute;
            String a;

            if (h > 12) {
                h = h - 12;
                a = "PM";
            }  else if (h == 0) {
                h = 12;
                a = "AM";
            }  else if (h == 12) {
                a = "PM";
            }  else {
                a = "AM";
            }

            timeEdit.setText(h + ":" + m + " " + a);
        }
    }

    //When picked, the clock is shown onto the screen
    public void onButtonClicked(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"TimePicker");
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
