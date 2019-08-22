package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.splashscreen.Classes.BucketLog_Details;
import com.example.splashscreen.Classes.SpendingLogDetails;
import com.example.splashscreen.utility.BucketlogRecycleView;
import com.example.splashscreen.utility.SpendingLogRecycleView;

import java.util.ArrayList;

public class BucketList extends AppCompatActivity {
    private ImageView menu_popup;
    private ImageView new_spendIcon;
    private BucketlogRecycleView bucketlogRecycleView;
    private ArrayList<BucketLog_Details> bucketLog_details = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list);
        menu_popup = findViewById(R.id.bucketLog_to);
        new_spendIcon = findViewById(R.id.add_new_bucket);


        setMenu_popup();
        setonClick();

        bucketLog_details.add(new BucketLog_Details("Daily walk 6km"));
        bucketLog_details.add(new BucketLog_Details("Go to walk"));
        setBucket_logRecycle();
    }

    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(BucketList.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.bucketlog, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                BucketList.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.bucketLog_to_today) {
                            Intent i = new Intent(BucketList.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.bucketLog_to_week) {
                            Intent i = new Intent(BucketList.this, WeekCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.bucketLog_t0_daily_thoughts) {
                            Intent i = new Intent(BucketList.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.bucketLog_t0_booksLog) {
                            Intent i = new Intent(BucketList.this, Books_to_Read_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.bucketLog_t0_spendingLog) {
                            Intent i = new Intent(BucketList.this, Spending_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.bucketLog_to_movies) {
                            Intent i = new Intent(BucketList.this, MoviesToWatch.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.bucketLog_t0_gratiude) {
                            Intent i = new Intent(BucketList.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.bucket_to_mood) {
                            Intent i = new Intent(BucketList.this, SelectMoods.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.bucket_to_habit) {
                            Intent i = new Intent(BucketList.this, HabitTracker.class);
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

    private void setonClick() {
        new_spendIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BucketList.this, AddNewbucketLog.class);
                startActivity(i);
            }
        });
    }
    private void setBucket_logRecycle() {
        RecyclerView recyclerView = findViewById(R.id.bucketList_View);
        bucketlogRecycleView = new BucketlogRecycleView(this, bucketLog_details);
        recyclerView.setAdapter(bucketlogRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
