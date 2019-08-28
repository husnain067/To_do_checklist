package com.example.splashscreen.NewTasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.splashscreen.MoviesToWatch;
import com.example.splashscreen.R;

public class CreateNewMovieLog extends AppCompatActivity {
    private RatingBar mRatingBar;
    int rating;
    private Button saveBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);
        mRatingBar = findViewById(R.id.rating_bar);
        saveBt = findViewById(R.id.save_movieLog);
        Float ratingNumber = mRatingBar.getRating();


        setOnClick();
    }

    private void setOnClick() {
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateNewMovieLog.this, MoviesToWatch.class);
                startActivity(i);
                finish();
            }
        });
    }
}
