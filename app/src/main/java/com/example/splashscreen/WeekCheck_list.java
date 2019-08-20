package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
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

import static com.example.splashscreen.Add_new_Weekly_Tasks.weekly_priorty;


public class WeekCheck_list extends AppCompatActivity {
    private ImageView menu_popup;
    ImageView new_TaskView;
    private ArrayList<Task_Details> task_details = new ArrayList<>();

    private RecycleAdapterView radapter;

    String newString;
    TextView dateView;
    ConstraintLayout layout;
    Integer layoutDate = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekl_check_list);

        init_controls();
        setMenu_popup();
        setCalender_dialog();
        new_TaskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WeekCheck_list.this, Add_new_Weekly_Tasks.class);
                startActivity(i);

            }
        });
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("string");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("string");
        }

        if (!TextUtils.isEmpty(newString))
            task_details.add(new Task_Details(newString, weekly_priorty));


        initRecycleView();
        gestureOn_activity();
    }

    private void init_controls() {
        menu_popup = findViewById(R.id.imageView_weekly_Activity);
        new_TaskView = findViewById(R.id.newtask);
        layout = findViewById(R.id.weeklygesture);
        new_TaskView = findViewById(R.id.newtask);
        dateView = findViewById(R.id.editText_Date);
        dateView.setText(getCurrentDate().toLowerCase());

    }

    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(WeekCheck_list.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.weekly_to_today_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                WeekCheck_list.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.week_t0_today) {
                            Intent i = new Intent(WeekCheck_list.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();

                        }
                        if (item.getItemId() == R.id.week_t0_gratiude) {
                            Intent i = new Intent(WeekCheck_list.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.week_t0_daily_thoughts) {
                            Intent i = new Intent(WeekCheck_list.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.week_t0_booksLog) {
                            Intent i = new Intent(WeekCheck_list.this, Books_to_Read_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.week_t0_spendingLog) {
                            Intent i = new Intent(WeekCheck_list.this, Spending_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.week_to_movies) {
                            Intent i = new Intent(WeekCheck_list.this, MoviesToWatch.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.week_to_bucketLog) {
                            Intent i = new Intent(WeekCheck_list.this, BucketList.class);
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

    private void setCalender_dialog() {
        TextView okClick;
        TextView cancelClick;
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.calenderdialog);
        ImageView imageView;
        CalendarView calendarView;
        calendarView=dialog.findViewById(R.id.calendarView);

       imageView=findViewById(R.id.calenderImage);
       okClick=dialog.findViewById(R.id.onOk_click);
       cancelClick=dialog.findViewById(R.id.onCanel_click);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        okClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        cancelClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.setCancelable(false);

    }
    private void initRecycleView() {

        RecyclerView recyclerView = findViewById(R.id.weekly_recycle_view);
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
        layout.setOnTouchListener(new OnSwipeTouchListener(WeekCheck_list.this) {

            public void onSwipeRight() {
                Toast.makeText(WeekCheck_list.this, "right", Toast.LENGTH_SHORT).show();


                layoutDate--;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());

                new_TaskView.setVisibility(View.GONE);
            }

            public void onSwipeLeft() {
                Toast.makeText(WeekCheck_list.this, "left", Toast.LENGTH_SHORT).show();
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