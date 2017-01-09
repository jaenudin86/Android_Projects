package com.example.thomas.activitymonitor;

// Class: Used to store the information to be sent to the FireBase database
public class LocationData
{
    public double longitude;
    public double latitude;
    public String currentDate;
    public long stepCount;

    // Method: Constructor
    public LocationData(double longi, double lati, String date)
    {
        longitude = longi;
        latitude = lati;
        currentDate = date;
    }

    public LocationData(double longi, double lati, String date, long steps)
    {
        longitude = longi;
        latitude = lati;
        currentDate = date;
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

    // Method: Used to get current date
    public String getCurrentTime()
    {
        return currentDate;
    }

    // Method: Used to set current time
    public void setCurrentTime(String currentDate)
    {
        this.currentDate = currentDate;
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
