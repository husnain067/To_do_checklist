package com.example.splashscreen.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Constants {
    static Constants _instance;

    Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor sharedPrefEditor;

    public static Constants instance(Context context) {
        if (_instance == null) {
            _instance = new Constants();
            _instance.configSessionUtils(context);
        }
        return _instance;
    }

    public static Constants instance() {
        return _instance;
    }

    public void configSessionUtils(Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences("AppPreferences", Activity.MODE_PRIVATE);
        sharedPrefEditor = sharedPref.edit();
    }

    public void storeValueString(String key, String value) {
        sharedPrefEditor.putString(key, value);
        sharedPrefEditor.commit();
    }

    public String fetchValueString(String key) {
        return sharedPref.getString(key, null);
    }
}
// add these linesn to acess data
/*
Constants.instance(this.getApplicationContext()); ist paste in activity
        Constants.instance().storeValueString("companyKey", "Brainwash Inc."); for read data
        String companyName = (Constants.instance().fetchValueString("companyKey"));   for fetch data */