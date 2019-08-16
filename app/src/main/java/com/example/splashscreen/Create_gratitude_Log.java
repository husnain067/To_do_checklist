package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.utility.OnSwipeTouchListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Create_gratitude_Log extends AppCompatActivity {
    private ImageView edit_noteView;
    private EditText edit_noteText;
    private Button save_note;
    private ConstraintLayout layout;
    private TextView dateView;
    private Integer layoutDate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_gratitude__log);

        init_controls();
        dateView.setText(getCurrentDate());
        setEdit_noteView();
        gestureOn_activity();
    }

    private void init_controls() {
        edit_noteView = findViewById(R.id.edit_note_image);
        edit_noteText = findViewById(R.id.add_editNotes);
        save_note = findViewById(R.id.save_note);
        layout = findViewById(R.id.create_gratitude_layout);
        dateView = findViewById(R.id.date_view_editNote);
    }

    private void setEdit_noteView() {
        edit_noteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_noteText.setVisibility(View.VISIBLE);
                edit_noteView.setVisibility(View.GONE);
            }
        });
        save_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Create_gratitude_Log.this, Gratitude_log_activity.class);
                startActivity(i);
                finish();
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
        layout.setOnTouchListener(new OnSwipeTouchListener(Create_gratitude_Log.this) {

            public void onSwipeRight() {
                Toast.makeText(Create_gratitude_Log.this, "right", Toast.LENGTH_SHORT).show();


                layoutDate--;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());


            }

            public void onSwipeLeft() {
                Toast.makeText(Create_gratitude_Log.this, "left", Toast.LENGTH_SHORT).show();
                if (layoutDate == 0) {
                    return;
                }
                layoutDate++;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());


            }


        });
    }
}
