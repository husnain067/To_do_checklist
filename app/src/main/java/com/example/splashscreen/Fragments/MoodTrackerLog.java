package com.example.splashscreen.Fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.example.splashscreen.Classes.MoodDetails;
import com.example.splashscreen.MoodTracker;
import com.example.splashscreen.R;
import com.example.splashscreen.SelectMoods;
import com.example.splashscreen.utility.MoodLogRecycleView;
import com.example.splashscreen.utility.OnSwipeTouchListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoodTrackerLog extends Fragment {
    private View rootView;

    private ConstraintLayout moodLayout;
    private ImageView imageView;
    private Integer layoutDate = 0;
    private MoodLogRecycleView moodLogRecycleView;
    private ArrayList<MoodDetails> moodDetails = new ArrayList<>();
    private String startdate;
    private String enddate;
    DateFormat formatter;
    private TextView[] labels = new TextView[6];
    private Date ebdDate;
    private List<String> set_moodsName = new ArrayList<>();

    int tenDays = 0;

    public MoodTrackerLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mood_tracker_log, container, false);


        moodLayout = rootView.findViewById(R.id.mood_layout);
        imageView = rootView.findViewById(R.id.select_moods);
        labels[0] = rootView.findViewById(R.id.mood_1);
        labels[1] = rootView.findViewById(R.id.mood_2);
        labels[2] = rootView.findViewById(R.id.mood_3);
        labels[3] = rootView.findViewById(R.id.mood_4);
        labels[4] = rootView.findViewById(R.id.mood_5);
        labels[5] = rootView.findViewById(R.id.mood_6);

        ArrayList<String> myList = (ArrayList<String>) getActivity().getIntent().getSerializableExtra("mylist");

        for (int i = 0; i <= 5; i++) {

            labels[i].setText(myList.get(i));

        }


        gestureOn_activity();


        for (int i = 0; i < 10; i++) {
            moodDetails.add(new MoodDetails(addOneDayCalendar(tenDays + i)));


        }
        initRecycleView();

        startdate = String.valueOf(moodDetails.get(0));
        enddate = String.valueOf(moodDetails.get(9));


//        Log.d("ADebugTag", "Value: " + addOneDayCalendar(-10));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SelectMoods.class);
                startActivity(i);
                getActivity().finish();

            }
        });


        return rootView;
    }

    private void initRecycleView() {

        RecyclerView recyclerView = rootView.findViewById(R.id.mood_recycleView);
        moodLogRecycleView = new MoodLogRecycleView(getActivity(), moodDetails);
        recyclerView.setAdapter(moodLogRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }

    @SuppressLint("ClickableViewAccessibility")
    private void gestureOn_activity() {
        moodLayout.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {

            public void onSwipeTop() {
                Toast.makeText(getActivity(), "up", Toast.LENGTH_SHORT).show();
//
                tenDays += 10;

                moodDetails = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    moodDetails.add(new MoodDetails(addOneDayCalendar(tenDays + i)));

                }
                initRecycleView();
            }

            public void onSwipeBottom() {
                Toast.makeText(getActivity(), "down", Toast.LENGTH_SHORT).show();

                if ((tenDays - 10) < 0) {
                    return;
                }
                tenDays -= 10;
                moodDetails = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    moodDetails.add(new MoodDetails(addOneDayCalendar(tenDays + i)));

                }
                initRecycleView();

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
