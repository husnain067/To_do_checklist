package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.utility.OnSwipeTouchListener;
import com.example.splashscreen.utility.RecycleAdapterView;
import com.example.splashscreen.utility.Task_Details;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.example.splashscreen.Add_New_Tasks.priorty;


public class TodysChecklit_Activity extends AppCompatActivity {
    private ArrayList<Task_Details> task_details = new ArrayList<>();

    private RecycleAdapterView radapter;
    private ImageView new_TaskView;
    private String newString;
    private TextView dateView;
    private ConstraintLayout layout;
    private Integer layoutDate = 0;
    private ImageView button1;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todys_checklit_);
        button1 = (ImageView) findViewById(R.id.imageView);
        layout = findViewById(R.id.layout_id);
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
            task_details.add(new Task_Details(newString, priorty));


        initRecycleView();
        gestureOn_activity();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(TodysChecklit_Activity.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                TodysChecklit_Activity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.two) {
                            Intent i = new Intent(TodysChecklit_Activity.this, WeekCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.today_t0_gratiude) {
                            Intent i = new Intent(TodysChecklit_Activity.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.today_t0_daily_thoughts) {
                            Intent i = new Intent(TodysChecklit_Activity.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.today_t0_booksLog) {
                            Intent i = new Intent(TodysChecklit_Activity.this, Books_to_Read_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.today_t0_spendingLog) {
                            Intent i = new Intent(TodysChecklit_Activity.this, Spending_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.today_to_movies) {
                            Intent i = new Intent(TodysChecklit_Activity.this, MoviesToWatch.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.today_to_bucketLog) {
                            Intent i = new Intent(TodysChecklit_Activity.this, BucketList.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.today_to_mood) {
                            Intent i = new Intent(TodysChecklit_Activity.this, MoodTracker.class);
                            startActivity(i);
                            finish();
                        }
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method


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
        layout.setOnTouchListener(new OnSwipeTouchListener(TodysChecklit_Activity.this) {

            public void onSwipeRight() {
                Toast.makeText(TodysChecklit_Activity.this, "right", Toast.LENGTH_SHORT).show();


                layoutDate--;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());

                new_TaskView.setVisibility(View.GONE);
            }

            public void onSwipeLeft() {
                Toast.makeText(TodysChecklit_Activity.this, "left", Toast.LENGTH_SHORT).show();
                if (layoutDate == 0) {
                    return;
                }
                layoutDate++;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());
                new_TaskView.setVisibility(View.VISIBLE);

            }


        });
    }
}



