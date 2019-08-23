package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.splashscreen.utility.MoodLogRecycleView;
import com.example.splashscreen.utility.OnSwipeTouchListener;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MoodTracker extends AppCompatActivity {
    private ImageView menu_popup;
    private ConstraintLayout moodLayout;
    private ImageView imageView;
    private Integer layoutDate = 0;
    private MoodLogRecycleView moodLogRecycleView;
    private ArrayList<MoodDetails> moodDetails = new ArrayList<>();
    private String startdate;
    private String enddate;
    DateFormat formatter;
    private TextView[] labels = new TextView[6];
    private Date ebdDate;
    private List<String> set_moodsName = new ArrayList<>();

    int tenDays = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracker);
        menu_popup = findViewById(R.id.mood_toOthers);
        moodLayout = findViewById(R.id.mood_layout);
        imageView = findViewById(R.id.select_moods);
        labels[0] = findViewById(R.id.mood_1);
        labels[1] = findViewById(R.id.mood_2);
        labels[2] = findViewById(R.id.mood_3);
        labels[3] = findViewById(R.id.mood_4);
        labels[4] = findViewById(R.id.mood_5);
        labels[5] = findViewById(R.id.mood_6);

        ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");


for (int i=0; i<=5; i++){

    labels[i].setText(myList.get(i));

}



        int a = 1;

        setMenu_popup();
        gestureOn_activity();


        for (int i = 0; i < 10; i++) {
            moodDetails.add(new MoodDetails(addOneDayCalendar(tenDays + i)));


        }
        initRecycleView();

        startdate = String.valueOf(moodDetails.get(0));
        enddate = String.valueOf(moodDetails.get(9));


//        Log.d("ADebugTag", "Value: " + addOneDayCalendar(-10));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MoodTracker.this, SelectMoods.class);
                startActivity(i);
                finish();

            }
        });


    }

    private void initRecycleView() {

        RecyclerView recyclerView = findViewById(R.id.mood_recycleView);
        moodLogRecycleView = new MoodLogRecycleView(this, moodDetails);
        recyclerView.setAdapter(moodLogRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MoodTracker.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.moodlog, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MoodTracker.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.mood_to_today) {
                            Intent i = new Intent(MoodTracker.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_weekly) {
                            Intent i = new Intent(MoodTracker.this, WeekCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.movies_to_book_log) {
                            Intent i = new Intent(MoodTracker.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_grattitude) {
                            Intent i = new Intent(MoodTracker.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_spending_log) {
                            Intent i = new Intent(MoodTracker.this, Spending_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_movies) {
                            Intent i = new Intent(MoodTracker.this, MoviesToWatch.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_bucketLog) {
                            Intent i = new Intent(MoodTracker.this, MoodTracker.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_habit) {
                            Intent i = new Intent(MoodTracker.this, HabitTracker.class);
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
        moodLayout.setOnTouchListener(new OnSwipeTouchListener(MoodTracker.this) {

            public void onSwipeTop() {
                Toast.makeText(MoodTracker.this, "up", Toast.LENGTH_SHORT).show();
//
                tenDays += 10;

                moodDetails = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    moodDetails.add(new MoodDetails(addOneDayCalendar(tenDays + i)));

                }
                initRecycleView();
            }

            public void onSwipeBottom() {
                Toast.makeText(MoodTracker.this, "down", Toast.LENGTH_SHORT).show();

                if ((tenDays - 10) < 0) {
                    return;
                }
                tenDays -= 10;
                moodDetails = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    moodDetails.add(new MoodDetails(addOneDayCalendar(tenDays + i)));

                }
                initRecycleView();

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
