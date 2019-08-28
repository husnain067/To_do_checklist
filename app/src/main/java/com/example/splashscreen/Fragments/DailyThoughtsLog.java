package com.example.splashscreen.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.Daily_Thoughts;
import com.example.splashscreen.R;
import com.example.splashscreen.utility.OnSwipeTouchListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyThoughtsLog extends Fragment {
    private View rootView;

    private ImageView menu_popup;
    private ConstraintLayout daily_thought_layout;
    private TextView dateView;
    private Integer layoutDate = 0;

    public DailyThoughtsLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_daily_thoughts_log, container, false);

        menu_popup = rootView.findViewById(R.id.daily_thoughts_to);
        daily_thought_layout =rootView. findViewById(R.id.daily_thoughts_layout);
        dateView =rootView. findViewById(R.id.date_view_dailyThought);
        dateView.setText(getCurrentDate());

        gestureOn_activity();
        return rootView;
    }

    public  String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    public  String addOneDayCalendar(int i) {

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

    @SuppressLint("ClickableViewAccessibility")
    private void gestureOn_activity() {
        daily_thought_layout.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {

            public void onSwipeRight() {
                Toast.makeText(getActivity(), "right", Toast.LENGTH_SHORT).show();


                layoutDate--;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());


            }

            public void onSwipeLeft() {
                Toast.makeText(getActivity(), "left", Toast.LENGTH_SHORT).show();
                if (layoutDate == 0) {
                    return;
                }
                layoutDate++;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());


            }


        });
    }

}
