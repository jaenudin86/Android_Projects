package com.example.thomas.activitymonitor;

import java.util.Date;

// Class: Used to store the information to be sent to the FireBase database
public class LocationData
{
    private double longitude;
    private double latitude;
    private Date currentTime;
    private long stepCount;

    // Method: Constructor
    public LocationData(double longi, double lati, Date time, long steps)
    {
        longitude = longi;
        latitude = lati;
        currentTime = time;
        stepCount = steps;
    }

    // Method: Used to get longitude
    public double getLongitude()
    {
        return longitude;
    }

    // Method: Used to set longitude
    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    // Method: Used to get latitude
    public double getLatitude()
    {
        return latitude;
    }

    // Method: Used to set latitude
    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    // Method: Used to get current time
    public Date getCurrentTime()
    {
        return currentTime;
    }

    // Method: Used to set current time
    public void setCurrentTime(Date currentTime)
    {
        this.currentTime = currentTime;
    }

    // Method: Used to get step count
    public long getStepCount()
    {
        return stepCount;
    }

    // Method: Used to set step count
    public void setStepCount(long stepCount)
    {
        this.stepCount = stepCount;
    }
}
