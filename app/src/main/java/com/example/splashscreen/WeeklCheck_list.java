package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class WeeklCheck_list extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekl_check_list);
        imageView= findViewById(R.id.imageView_weekly_Activity);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(WeeklCheck_list.this, imageView);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.weekly_to_today_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                WeeklCheck_list.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getItemId()==R.id.week_t0_today){
                            Intent i = new Intent(WeeklCheck_list.this,TodysChecklit_Activity.class);
                            startActivity(i);
                        }
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing th
    }

}
