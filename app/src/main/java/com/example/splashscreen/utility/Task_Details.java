package com.example.splashscreen.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class Task_Details {
String taskName;
int priorty;

    public Task_Details(String taskName,int priorty) {
        this.taskName = taskName;
        this.priorty = priorty;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPriorty() {
        return priorty;
    }

    public void setPriorty(int priorty) {
        this.priorty = priorty;
    }
}
