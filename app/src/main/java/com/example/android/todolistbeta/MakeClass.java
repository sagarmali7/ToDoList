package com.example.android.todolistbeta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by kellyzelaya on 4/10/18.
 */
//Anytime you use AppCompatActivity, use SupportBar, no matter what
public class MakeClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_course);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //This adds the back button and takes you a level up
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //Can be used with other options being put onto Support bar
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        switch(menuItem.getItemId()){
            //Ends the activity
            case R.id.home:
                    this.finish();
        }


        return super.onOptionsItemSelected(menuItem);
    }




}
