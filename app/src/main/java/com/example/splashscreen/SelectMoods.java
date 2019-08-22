package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.splashscreen.Classes.SelectMoodDetails;
import com.example.splashscreen.databinding.ActivitySelectMoodsBinding;
import com.example.splashscreen.utility.RecycleAdapterView;
import com.example.splashscreen.utility.SelectMoodsLogRecycleView;
import com.example.splashscreen.utility.Task_Details;

import java.util.ArrayList;

public class SelectMoods extends AppCompatActivity {
    ActivitySelectMoodsBinding mBinding;
    private SelectMoodsLogRecycleView selectMoodsLogRecycleView;
    private ArrayList<SelectMoodDetails> selectMoodDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_select_moods);
        mBinding.submitMoodBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectMoods.this, MoodTracker.class);
                startActivity(intent);
            }
        });
        setMenu_popup();
        initRecycleView();

        selectMoodDetails.add(new SelectMoodDetails("Happy"));
        selectMoodDetails.add(new SelectMoodDetails("Sad"));
        selectMoodDetails.add(new SelectMoodDetails("Mellow"));
        selectMoodDetails.add(new SelectMoodDetails("Motivated"));
        selectMoodDetails.add(new SelectMoodDetails("Stressed"));
        selectMoodDetails.add(new SelectMoodDetails("Agitated"));
        selectMoodDetails.add(new SelectMoodDetails("Optimistic"));
        selectMoodDetails.add(new SelectMoodDetails("Calm"));
        selectMoodDetails.add(new SelectMoodDetails("Energetic"));
        selectMoodDetails.add(new SelectMoodDetails("Frustrated"));
        selectMoodDetails.add(new SelectMoodDetails("Fearful"));
        selectMoodDetails.add(new SelectMoodDetails("Content"));


    }

    private void setMenu_popup() {
        mBinding.selectMoodToOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(SelectMoods.this, mBinding.selectMoodToOthers);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.moodlog, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                SelectMoods.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.mood_to_today) {
                            Intent i = new Intent(SelectMoods.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_weekly) {
                            Intent i = new Intent(SelectMoods.this, WeekCheck_list.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.movies_to_book_log) {
                            Intent i = new Intent(SelectMoods.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_grattitude) {
                            Intent i = new Intent(SelectMoods.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_spending_log) {
                            Intent i = new Intent(SelectMoods.this, Spending_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_movies) {
                            Intent i = new Intent(SelectMoods.this, MoviesToWatch.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_bucketLog) {
                            Intent i = new Intent(SelectMoods.this, SelectMoods.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.mood_to_habit) {
                            Intent i = new Intent(SelectMoods.this, HabitTracker.class);
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

    private void initRecycleView() {

        RecyclerView recyclerView = findViewById(R.id.name_recycle_view);
        selectMoodsLogRecycleView = new SelectMoodsLogRecycleView(this, selectMoodDetails);
        recyclerView.setAdapter(selectMoodsLogRecycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));


    }
}
