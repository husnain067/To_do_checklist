package com.example.splashscreen.NewTasks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.splashscreen.R;
import com.example.splashscreen.TodysChecklit_Activity;
import com.example.splashscreen.utility.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;




public class Add_New_Tasks extends AppCompatActivity {
   private Button TimePicker_View;
    private  EditText add_newNotes;
    private  TextView setTime;
    private TextView reminderSet;
    private Button submitBt;
    private LinearLayout reminderLayout;
    private TextView dateView;
    public static int priorty;


   private String newTask;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__new__tasks);
        add_newNotes = findViewById(R.id.add_notes);
        reminderSet = findViewById(R.id.reminder_timeView);
        submitBt = findViewById(R.id.submitBT);
        setTime = findViewById(R.id.Time_view);
        reminderLayout = findViewById(R.id.reminderLayout);
        dateView = findViewById(R.id.editText_date);


        Constants.instance(this.getApplicationContext());

        dateView.setText(getCurrentDate().toLowerCase());

        setTimePicker_View();
        setReminderLayoutTimePicker_View();

        submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newTask = add_newNotes.getText().toString();
                if (TextUtils.isEmpty(newTask)) {
                    Toast.makeText(Add_New_Tasks.this, "Enter note first", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent i = new Intent(Add_New_Tasks.this, TodysChecklit_Activity.class);

                //submit_challengeList = Collections.singletonList(newTask);

                i.putExtra("STRING_I_NEED", newTask);
                startActivity(i);
                finish();

            }
        });
        reminder_spinner();
        priorty_spinner();
    }


    private void setTimePicker_View() {
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Add_New_Tasks.this, R.style.datepicker, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        // setTime.setText( selectedHour + ":" + selectedMinute + "PM");
                        String AM_PM;
                        if (selectedHour < 12) {
                            AM_PM = "AM";
                        } else {
                            AM_PM = "PM";
                        }

                        setTime.setText(selectedHour + " : " + selectedMinute + " " + AM_PM);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();


            }


        });

    }

    private void setReminderLayoutTimePicker_View() {
        reminderSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Add_New_Tasks.this, R.style.datepicker, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        // setTime.setText( selectedHour + ":" + selectedMinute + "PM");
                        String AM_PM;
                        if (selectedHour < 12) {
                            AM_PM = "AM";
                        } else {
                            AM_PM = "PM";
                        }

                        reminderSet.setText(selectedHour + " : " + selectedMinute + " " + AM_PM);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();


            }


        });

    }

    private void reminder_spinner() {
        Spinner sp = (Spinner) findViewById(R.id.remind_timePicker);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        reminderLayout.setVisibility(View.GONE);
                        break;

                    case 1:
                        reminderLayout.setVisibility(View.VISIBLE);
                        break;
                    default:
                        reminderLayout.setVisibility(View.INVISIBLE);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void priorty_spinner() {
        Spinner sp = (Spinner) findViewById(R.id.spinner_priorty);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        priorty = 0;
                        break;

                    case 1:
                        priorty = 1;
                        break;
                    case 2:
                        priorty = 2;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public  String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }


}
