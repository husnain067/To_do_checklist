package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.splashscreen.Classes.MoodDetails;
import com.example.splashscreen.utility.MoodLogRecycleView;
import com.example.splashscreen.utility.OnSwipeTouchListener;

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
    private Integer layoutDate = 0;
    private MoodLogRecycleView moodLogRecycleView;
    private ArrayList<MoodDetails> moodDetails = new ArrayList<>();
    private String startdate;
    private String enddate;
    DateFormat formatter;

    private Date ebdDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracker);
        menu_popup = findViewById(R.id.mood_toOthers);
        moodLayout = findViewById(R.id.mood_layout);


        setMenu_popup();
        gestureOn_activity();

        startdate = getCurrentDate();
        enddate = fetchNextDate(-10, startdate);

        addToListView(enddate, startdate);


//        Log.d("ADebugTag", "Value: " + addOneDayCalendar(-10));


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
//                addToListView("10/08", "20/08");
//                String start = String.valueOf(moodDetails.get(9));
//                addToListView(start, fetchNextDate(-10, start));
                addToListView(fetchNextDate(10, enddate), fetchNextDate(10, startdate));

                int a=10;

            }

            public void onSwipeBottom() {
                Toast.makeText(MoodTracker.this, "down", Toast.LENGTH_SHORT).show();
                addToListView(fetchNextDate(-10, startdate), fetchNextDate(-10, enddate));
                int b=10;

            }

        });
    }

    private void addToListView(String startDate, String endDate) {
        moodDetails = new ArrayList<>();

        List<Date> dates = getDates(startDate, endDate);for (Date date : dates) {

            moodDetails.add(new MoodDetails(convertDateToString(date)));

        }

        initRecycleView();

    }

    private static String getCurrentDate() {
        String DATE_FORMAT_4 = "dd/MM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    private static String addOneDayCalendar(int i) {

        String date = getCurrentDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, i);
        return sdf.format(c.getTime());
    }

    private static String fetchNextDate(int i, String date) {

//        String date = getCurrentDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, i);
        return sdf.format(c.getTime());
    }



    private static List<Date> getDates(String dateString1, String dateString2) {
        ArrayList<Date> dates = new ArrayList<Date>();
        DateFormat df1 = new SimpleDateFormat("dd/MM");

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = df1.parse(dateString1);
            date2 = df1.parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);


        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        while (!cal1.after(cal2)) {
            dates.add(cal1.getTime());
            cal1.add(Calendar.DATE, 1);
        }
        return dates;
    }

    private static String convertDateToString(Date date) {
        String DATE_FORMAT_4 = "dd/MM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        return dateFormat.format(date);
    }
}
