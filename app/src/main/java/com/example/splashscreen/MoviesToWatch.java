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

import com.example.splashscreen.Classes.MoviesDetails;
import com.example.splashscreen.utility.MoviesLogRecycleView;

import java.util.ArrayList;

public class MoviesToWatch extends AppCompatActivity {
    private ImageView menu_popup;
    private ImageView new_movieIcon;
    private MoviesLogRecycleView moviesLogRecycleView;
    private ArrayList<MoviesDetails> moviesDetails = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_to_wtch);
        menu_popup = findViewById(R.id.movies_to);
        new_movieIcon = findViewById(R.id.add_new_movie);

        new_movieIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MoviesToWatch.this, CreateNewMovieLog.class);
                startActivity(i);
            }
        });
        moviesDetails.add(new MoviesDetails("Focus"));
        moviesDetails.add(new MoviesDetails("Captin Fantastic"));
        moviesDetails.add(new MoviesDetails("The switch"));

        setNew_movieRecycleView();
        setMenu_popup();
    }

    private void setMenu_popup() {
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MoviesToWatch.this, menu_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.weekly_to_today_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MoviesToWatch.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId() == R.id.week_t0_today) {
                            Intent i = new Intent(MoviesToWatch.this, TodysChecklit_Activity.class);
                            startActivity(i);
                            finish();

                        }
                        if (item.getItemId() == R.id.week_t0_gratiude) {
                            Intent i = new Intent(MoviesToWatch.this, Gratitude_log_activity.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.week_t0_daily_thoughts) {
                            Intent i = new Intent(MoviesToWatch.this, Daily_Thoughts.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.week_t0_booksLog) {
                            Intent i = new Intent(MoviesToWatch.this, Books_to_Read_Log.class);
                            startActivity(i);
                            finish();
                        }
                        if (item.getItemId() == R.id.week_t0_spendingLog) {
                            Intent i = new Intent(MoviesToWatch.this, Spending_Log.class);
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

    private void setNew_movieRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.movie_title_view);
        moviesLogRecycleView = new MoviesLogRecycleView(this, moviesDetails);
        recyclerView.setAdapter(moviesLogRecycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }


}
