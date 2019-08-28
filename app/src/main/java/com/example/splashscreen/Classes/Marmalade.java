package com.example.splashscreen.Classes;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import lombok.Getter;
import lombok.val;

public class Marmalade extends Application {
    static Context mContext;
    @Getter
    FirebaseAuth mAuth;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initFireBase();
    }

    //*************************
    private void initFireBase()
    //*************************
    {
        val app = FirebaseApp.initializeApp(this);
        FirebaseApp.initializeApp(getApplicationContext());
        mAuth = FirebaseAuth.getInstance();

    }

    //***********************
    public static @NonNull
    Marmalade instance()
    //***********************
    {
        return (Marmalade) mContext;

    }
}
