package com.example.splashscreen.Fragments;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.NewTasks.Add_new_Weekly_Tasks;
import com.example.splashscreen.R;
import com.example.splashscreen.utility.OnSwipeTouchListener;
import com.example.splashscreen.utility.RecycleAdapterView;
import com.example.splashscreen.utility.Task_Details;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.example.splashscreen.NewTasks.Add_new_Weekly_Tasks.weekly_priorty;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeeklyLog extends Fragment {
    private View rootView;

    private ImageView menu_popup;
    private ImageView new_TaskView;
    private ArrayList<Task_Details> task_details = new ArrayList<>();

    private RecycleAdapterView radapter;

    String newString;
    private TextView dateView;
    private ConstraintLayout layout;
    private Integer layoutDate = 0;

    public WeeklyLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_weekly_log, container, false);

        init_controls();

        setCalender_dialog();
        Onclick();

        if (savedInstanceState == null) {
            Bundle extras = getActivity().getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("string");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("string");
        }

        if (!TextUtils.isEmpty(newString))
            task_details.add(new Task_Details(newString, weekly_priorty));


        initRecycleView();
        gestureOn_activity();

        return rootView;
    }

    private void Onclick() {
        new_TaskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Add_new_Weekly_Tasks.class);
                startActivity(i);

            }
        });
    }

    private void init_controls() {
        menu_popup = rootView.findViewById(R.id.imageView_weekly_Activity);
        new_TaskView = rootView.findViewById(R.id.newtask);
        layout = rootView.findViewById(R.id.weeklygesture);
        new_TaskView = rootView.findViewById(R.id.newtask);
        dateView = rootView.findViewById(R.id.editText_Date);
        dateView.setText(getCurrentDate().toLowerCase());

    }

    private void setCalender_dialog() {
        TextView okClick;
        TextView cancelClick;
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.calenderdialog);
        ImageView imageView;
        CalendarView calendarView;
        calendarView = dialog.findViewById(R.id.calendarView);

        imageView = rootView.findViewById(R.id.calenderImage);
        okClick = dialog.findViewById(R.id.onOk_click);
        cancelClick = dialog.findViewById(R.id.onCanel_click);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        okClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        cancelClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.setCancelable(false);

    }

    private void initRecycleView() {

        RecyclerView recyclerView = rootView.findViewById(R.id.weekly_recycle_view);
        radapter = new RecycleAdapterView(getActivity(), task_details);
        recyclerView.setAdapter(radapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }

    private String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    private String addOneDayCalendar(int i) {

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
        layout.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {

            public void onSwipeRight() {
                Toast.makeText(getActivity(), "right", Toast.LENGTH_SHORT).show();


                layoutDate--;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());

                new_TaskView.setVisibility(View.GONE);
            }

            public void onSwipeLeft() {
                Toast.makeText(getActivity(), "left", Toast.LENGTH_SHORT).show();
                if (layoutDate == 0) {
                    return;
                }
                layoutDate++;
                dateView.setText(addOneDayCalendar(layoutDate).toLowerCase());
                new_TaskView.setVisibility(View.VISIBLE);

            }


        });
    }

}
