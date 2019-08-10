package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.splashscreen.utility.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.example.splashscreen.Add_New_Tasks.getCurrentDate;

public class Add_new_Weekly_Tasks extends AppCompatActivity {
    private Button TimePicker_View;
    private EditText add_newNotes;
    private TextView setTime;
    private TextView reminderSet;
    private Button submitBt;
    private LinearLayout reminderLayout;
    private TextView dateView;
    public static int weekly_priorty;

    private String newTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new__weekly__tasks);
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
                    Toast.makeText(Add_new_Weekly_Tasks.this, "Enter note first", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent i = new Intent(Add_new_Weekly_Tasks.this, WeeklCheck_list.class);

                //submit_challengeList = Collections.singletonList(newTask);

                i.putExtra("string", newTask);
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
                mTimePicker = new TimePickerDialog(Add_new_Weekly_Tasks.this, R.style.datepicker, new TimePickerDialog.OnTimeSetListener() {
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
                mTimePicker = new TimePickerDialog(Add_new_Weekly_Tasks.this, R.style.datepicker, new TimePickerDialog.OnTimeSetListener() {
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
                        weekly_priorty = 0;
                        break;

                    case 1:
                        weekly_priorty = 1;
                        break;
                    case 2:
                        weekly_priorty = 2;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public static String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
