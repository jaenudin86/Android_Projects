package com.example.thomas.activitymonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

// Class: Main activity containing a layout with two buttons
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivitylayout);
    }

    // Method: Used to jump to StepDataActivity once button is clicked
    public void onStepButtonClicked(View view)
    {
        Intent intent = new Intent(this, StepDataActivity.class);
        startActivity(intent);
    }

    // Method: Used to jump to Maps Activity once button is clicked
    public void onLocationButtonClicked(View view)
    {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
