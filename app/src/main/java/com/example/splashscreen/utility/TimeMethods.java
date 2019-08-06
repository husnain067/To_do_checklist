package com.example.splashscreen.utility;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeMethods extends AppCompatActivity {

    private static final String TAG = "Utility";
    private static final String CHANNEL_ID = "personal_notification";

    public static String getCurrentTimeStamp() {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //MUST USE LOWERCASE 'y'. API 23- can't use uppercase
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

    }

    public static String addOneDayCalendar(int i)
            throws ParseException {

        String date = getCurrentTimeStamp();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, i);
        return sdf.format(c.getTime());
    }

    public static String getCurrent_TimeStamp() {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //MUST USE LOWERCASE 'y'. API 23- can't use uppercase
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

    }

    public static String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM-dd-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
        //to lower case
    }


    }




