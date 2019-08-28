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

import com.example.splashscreen.Classes.SpendingLogDetails;
import com.example.splashscreen.NewTasks.AddNewSpendLog;
import com.example.splashscreen.utility.SpendingLogRecycleView;

import java.util.ArrayList;

public class Spending_Log extends AppCompatActivity {
    private ImageView menu_popup;
    private ImageView new_spendIcon;
    private SpendingLogRecycleView spendingLogRecycleView;
    private ArrayList<SpendingLogDetails> spendingLogDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending__log);
        menu_popup = findViewById(R.id.spending_Log_to);
        new_spendIcon = findViewById(R.id.add_new_spentView);

        setMenu_popup();
        setonClick();


        spendingLogDetails.add(new SpendingLogDetails("19/8","100","100","Alfa",R.drawable.tick,R.drawable.x_mark));
        spendingLogDetails.add(new SpendingLogDetails("20/8","200","300","Xyz",R.drawable.x_mark,R.drawable.tick));
        spendingLogDetails.add(new SpendingLogDetails("21/8","1000","2000","Mart",R.drawable.tick,R.drawable.tick));
        spendingLogDetails.add(new SpendingLogDetails("22/8","80","100","Metro",R.drawable.x_mark,R.drawable.x_mark));

        setSpending_logRecycle();
    }

    private void setonClick() {
        new_spendIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Spending_Log.this, AddNewSpendLog.class);
                startActivity(i);
            }
        });
    }

    private void setSpending_logRecycle() {
        RecyclerView recyclerView = findViewById(R.id.spendingLog_view);
        spendingLogRecycleView = new SpendingLogRecycleView(this, spendingLogDetails);
        recyclerView.setAdapter(spendingLogRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Spending_Log.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.spending_log, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                Spending_Log.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.spending_to_today) {
                            Intent i = new Intent(Spending_Log.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();

                        }
                        if (item.getItemId() == R.id.spending_to_grattitude) {
                            Intent i = new Intent(Spending_Log.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.spending_to_Daily) {
                            Intent i = new Intent(Spending_Log.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.spending_to_book_log) {
                            Intent i = new Intent(Spending_Log.this, Books_to_Read_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.spending_to_weekly) {
                            Intent i = new Intent(Spending_Log.this, WeekCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.spending_to_movies) {
                            Intent i = new Intent(Spending_Log.this, MoviesToWatch.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.spending_to_bucketLog) {
                            Intent i = new Intent(Spending_Log.this, BucketList.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.spending_to_mood) {
                            Intent i = new Intent(Spending_Log.this, SelectMoods.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.spending_to_habit) {
                            Intent i = new Intent(Spending_Log.this, HabitTracker.class);
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
}
