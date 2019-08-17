package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.splashscreen.utility.ClickListner;
import com.example.splashscreen.utility.Gratitude_recyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Gratitude_log_activity extends AppCompatActivity {
    private ImageView menu_popup;
    List<String> submit_dates = new ArrayList();
    private Gratitude_recyclerView adapterView;
    String dateView_dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gratitude_log_activity);
        menu_popup = findViewById(R.id.gratitudeLog_to);

        setMenu_popup();
        submit_dates.add(getCurrentDate());
        submit_dates.add("august 15,2019");
        submit_dates.add("august 14,2019");
        submit_dates.add("august 13,2019");
        submit_dates.add("august 12,2019");
        submit_dates.add("august 11,2019");
        submit_dates.add("august 10,2019");
        submit_dates.add("august 9,2019");
        submit_dates.add("august 8,2019");
        submit_dates.add("august 7,2019");
        submit_dates.add("august 6,2019");
        initRecycleView();
    }


    private void initRecycleView() {

        RecyclerView recyclerView = findViewById(R.id.gratitude_recycleView);
        adapterView = new Gratitude_recyclerView(this, submit_dates, new ClickListner() {
            @Override
            public void onClick(int position) {
                Intent i = new Intent(Gratitude_log_activity.this, Create_gratitude_Log.class);
                i.putExtra("STRING_I_NEED", submit_dates.get(position));
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapterView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


    }

    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Gratitude_log_activity.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.grattitudelog, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                Gratitude_log_activity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.gratitude_t0_today) {
                            Intent i = new Intent(Gratitude_log_activity.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.gratitude_t0_weekly) {
                            Intent i = new Intent(Gratitude_log_activity.this, WeeklCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.gratitude_t0_daily_thoughts) {
                            Intent i = new Intent(Gratitude_log_activity.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.gratitude_t0_booksLog) {
                            Intent i = new Intent(Gratitude_log_activity.this, Books_to_Read_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.gratitude_t0_spendingLog) {
                            Intent i = new Intent(Gratitude_log_activity.this, Spending_Log.class);
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
}
