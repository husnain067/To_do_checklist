package com.example.splashscreen.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.splashscreen.NewTasks.Create_gratitude_Log;
import com.example.splashscreen.R;
import com.example.splashscreen.utility.ClickListner;
import com.example.splashscreen.utility.Gratitude_recyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class GratitudeLog extends Fragment {
    private View rootView;

    List<String> submit_dates = new ArrayList();
    private Gratitude_recyclerView adapterView;
    String dateView_dates;
    public GratitudeLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_gratitude_log, container, false);




        submit_dates.add(getCurrentDate());
        submit_dates.add("august 15,2019");
        submit_dates.add("august 14,2019");
        submit_dates.add("august 13,2019");
        submit_dates.add("august 12,2019");
        submit_dates.add("august 11,2019");
        submit_dates.add("august 10,2019");
        submit_dates.add("august 9,2019");
        submit_dates.add("august 8,2019");
        submit_dates.add("august 7,2019");
        submit_dates.add("august 6,2019");
        initRecycleView();
        return rootView;
    }

    private void initRecycleView() {

        RecyclerView recyclerView = rootView.findViewById(R.id.gratitude_recycleView);
        adapterView = new Gratitude_recyclerView(getActivity(), submit_dates, new ClickListner() {
            @Override
            public void onClick(int position) {
                Intent i = new Intent(getActivity(), Create_gratitude_Log.class);
                i.putExtra("STRING_I_NEED", submit_dates.get(position));
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapterView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


    }

    public  String getCurrentDate() {
        String DATE_FORMAT_4 = "MMMM dd, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_4);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
