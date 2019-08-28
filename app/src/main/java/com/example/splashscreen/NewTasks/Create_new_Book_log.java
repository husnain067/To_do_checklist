package com.example.splashscreen.NewTasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splashscreen.Books_to_Read_Log;
import com.example.splashscreen.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import yuku.ambilwarna.AmbilWarnaDialog;


public class Create_new_Book_log extends AppCompatActivity {
    private CardView cardView;
    int mDefaultColor;
    private ImageView color_pickerView;
    private TextView mDateView;
    private Button saveBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new__book_log);
        color_pickerView = findViewById(R.id.colorPicker);
        cardView = findViewById(R.id.cardLayout);
        mDateView = findViewById(R.id.book_log_dateView);
        saveBt=findViewById(R.id.save_bookLog);

        mDateView.setText(getCurrentDate());
        mDefaultColor = ContextCompat.getColor(Create_new_Book_log.this, R.color.colorPrimary);

        color_pickerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker();
            }


        });
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Create_new_Book_log.this, Books_to_Read_Log.class);
                startActivity(i);
            }
        });


    }

    private void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                cardView.setCardBackgroundColor(mDefaultColor);
            }
        });
        colorPicker.show();

    }

    public  String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
