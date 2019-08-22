package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.Classes.MoodDetails;
import com.example.splashscreen.utility.OnSwipeTouchListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class HabitTracker extends AppCompatActivity {
    private ImageView menu_popup;
    private ConstraintLayout habitLayout;
    Integer sevenDAys = 0;
    TextView[] labels = new TextView[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habbit_tracker);
        menu_popup = findViewById(R.id.habit_to_others);
        habitLayout = findViewById(R.id.habbit_layout);
        labels[0] = findViewById(R.id.text);
        labels[1] = findViewById(R.id.coloum1);
        labels[2] = findViewById(R.id.coloum2);
        labels[3] = findViewById(R.id.coloum3);
        labels[4] = findViewById(R.id.coloum4);
        labels[5] = findViewById(R.id.coloum5);
        labels[6] = findViewById(R.id.coloum6);
        labels[7] = findViewById(R.id.coloum7);


        setMenu_popup();
        gestureOn_activity();
        for (int i = 1; i <= 7; i++) {
            labels[i].setText((addOneDayCalendar((sevenDAys + i-1))));

        }


    }

    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(HabitTracker.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.habit, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                HabitTracker.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.habit_t0_today) {
                            Intent i = new Intent(HabitTracker.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.habit_t0_week) {
                            Intent i = new Intent(HabitTracker.this, WeekCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.habit_t0_daily_thoughts) {
                            Intent i = new Intent(HabitTracker.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.habit_t0_gratiude) {
                            Intent i = new Intent(HabitTracker.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.habit_t0_spendingLog) {
                            Intent i = new Intent(HabitTracker.this, Spending_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.habit_to_movies) {
                            Intent i = new Intent(HabitTracker.this, MoviesToWatch.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.habit_to_mood) {
                            Intent i = new Intent(HabitTracker.this, SelectMoods.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.habit_t0_booksLog) {
                            Intent i = new Intent(HabitTracker.this, Books_to_Read_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.habit_to_bucketLog) {
                            Intent i = new Intent(HabitTracker.this, BucketList.class);
                            startActivity(i);
                            finish();
                        }

                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void gestureOn_activity() {
        habitLayout.setOnTouchListener(new OnSwipeTouchListener(HabitTracker.this) {
            public void onSwipeRight() {
                Toast.makeText(HabitTracker.this, "left", Toast.LENGTH_SHORT).show();
                if ((sevenDAys - 7) == -7) {
                    return;
                }
                sevenDAys -= 7;

                for (int i = 1; i <= 7; i++) {
                    labels[i].setText((addOneDayCalendar((sevenDAys + i-1))));

                }
            }

            public void onSwipeLeft() {

                Toast.makeText(HabitTracker.this, "right", Toast.LENGTH_SHORT).show();
                sevenDAys += 7;
                for (int i = 1; i <= 7; i++) {
                    labels[i].setText((addOneDayCalendar((sevenDAys + i-1))));

                }
            }


        });
    }

    private String getCurrentDate() {
        String DATE_FORMAT_4 = "dd/MM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    private String addOneDayCalendar(int i) {

        String date = getCurrentDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, -i);
        return sdf.format(c.getTime());
    }
}
