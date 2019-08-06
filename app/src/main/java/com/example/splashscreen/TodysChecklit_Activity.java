package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splashscreen.utility.RecycleAdapterView;
import com.example.splashscreen.utility.Task_Details;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;



public class TodysChecklit_Activity extends AppCompatActivity {
    public static ArrayList<Task_Details> task_details = new ArrayList<>();

    private RecycleAdapterView radapter;
    ImageView new_TaskView;
    String newString;
    TextView dateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todys_checklit_);


        new_TaskView = findViewById(R.id.newtask);
        dateView = findViewById(R.id.editText_Date);
        dateView.setText(getCurrentDate().toLowerCase());

        new_TaskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TodysChecklit_Activity.this, Add_New_Tasks.class);
                startActivity(i);
            }
        });

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("STRING_I_NEED");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

        if (!TextUtils.isEmpty(newString))
            task_details.add(new Task_Details(newString));


        initRecycleView();

    }

    private void initRecycleView() {

        RecyclerView recyclerView = findViewById(R.id.recyleadapter);
        radapter = new RecycleAdapterView(this, task_details);
        recyclerView.setAdapter(radapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public static String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }


}


