package com.example.splashscreen.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.Classes.HabitDetails;
import com.example.splashscreen.HabitTracker;
import com.example.splashscreen.R;
import com.example.splashscreen.utility.HabitLogRecycleView;
import com.example.splashscreen.utility.OnSwipeTouchListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class HabitTrackerLog extends Fragment {
    private View rootView;


    private ConstraintLayout habitLayout;
    private HabitLogRecycleView habitLogRecycleView;
    private ArrayList<HabitDetails> habitDetails = new ArrayList<>();
    Integer sevenDAys = 0;
    TextView[] labels = new TextView[8];

    public HabitTrackerLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_habit_tracker_log, container, false);


        habitLayout = rootView.findViewById(R.id.habbit_layout);
        labels[0] =rootView. findViewById(R.id.text);
        labels[1] = rootView.findViewById(R.id.coloum1);
        labels[2] = rootView.findViewById(R.id.coloum2);
        labels[3] = rootView.findViewById(R.id.coloum3);
        labels[4] = rootView.findViewById(R.id.coloum4);
        labels[5] = rootView.findViewById(R.id.coloum5);
        labels[6] =rootView. findViewById(R.id.coloum6);
        labels[7] = rootView.findViewById(R.id.coloum7);



        gestureOn_activity();
        for (int i = 1; i <= 7; i++) {
            labels[i].setText((addOneDayCalendar((sevenDAys + i - 1))));

        }

        habitDetails.add(new HabitDetails(""));
        habitDetails.add(new HabitDetails(""));
        habitDetails.add(new HabitDetails(""));
        habitDetails.add(new HabitDetails(""));
        habitDetails.add(new HabitDetails(""));
        habitDetails.add(new HabitDetails(""));
        habitDetails.add(new HabitDetails(""));

        initRecycleView();


        return rootView;
    }
    private void initRecycleView() {

        RecyclerView recyclerView =rootView. findViewById(R.id.habit_recycle_view);
        habitLogRecycleView = new HabitLogRecycleView(getActivity(), habitDetails);
        recyclerView.setAdapter(habitLogRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @SuppressLint("ClickableViewAccessibility")
    private void gestureOn_activity() {
        habitLayout.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            public void onSwipeRight() {
                Toast.makeText(getActivity(), "left", Toast.LENGTH_SHORT).show();
                if ((sevenDAys - 7) == -7) {
                    return;
                }
                sevenDAys -= 7;

                for (int i = 1; i <= 7; i++) {
                    labels[i].setText((addOneDayCalendar((sevenDAys + i - 1))));
                    initRecycleView();

                }
            }

            public void onSwipeLeft() {

                Toast.makeText(getActivity(), "right", Toast.LENGTH_SHORT).show();
                sevenDAys += 7;
                for (int i = 1; i <= 7; i++) {
                    labels[i].setText((addOneDayCalendar((sevenDAys + i - 1))));
                    initRecycleView();

                }
            }


        });
    }

    private String getCurrentDate() {
        String DATE_FORMAT_4 = "dd/MM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    private String addOneDayCalendar(int i) {

        String date = getCurrentDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, -i);
        return sdf.format(c.getTime());
    }
}
