package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.utility.OnSwipeTouchListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Daily_Thoughts extends AppCompatActivity {
    private ImageView menu_popup;
    private ConstraintLayout daily_thought_layout;
    private TextView dateView;
    private Integer layoutDate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily__thoughts);
        menu_popup = findViewById(R.id.daily_thoughts_to);
        daily_thought_layout = findViewById(R.id.daily_thoughts_layout);
        dateView = findViewById(R.id.date_view_dailyThought);
        dateView.setText(getCurrentDate());
        setMenu_popup();
        gestureOn_activity();

    }

    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Daily_Thoughts.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.daily_thoughts_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                Daily_Thoughts.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.daily_thoughts_to_today) {
                            Intent i = new Intent(Daily_Thoughts.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.daily_thoughts_t0_weekly) {
                            Intent i = new Intent(Daily_Thoughts.this, WeekCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.daily_thoughts_t0_gratitude) {
                            Intent i = new Intent(Daily_Thoughts.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.daily_thoughts_to_spendingLog) {
                            Intent i = new Intent(Daily_Thoughts.this, Spending_Log.class);
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

    public static String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    public static String addOneDayCalendar(int i) {

        String date = getCurrentDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, i);
        return sdf.format(c.getTime());
    }

    private void gestureOn_activity() {
        daily_thought_layout.setOnTouchListener(new OnSwipeTouchListener(Daily_Thoughts.this) {

            public void onSwipeRight() {
                Toast.makeText(Daily_Thoughts.this, "right", Toast.LENGTH_SHORT).show();


                layoutDate--;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());


            }

            public void onSwipeLeft() {
                Toast.makeText(Daily_Thoughts.this, "left", Toast.LENGTH_SHORT).show();
                if (layoutDate == 0) {
                    return;
                }
                layoutDate++;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());


            }


        });
    }
}
