package com.example.splashscreen.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.splashscreen.NewTasks.AddNewbucketLog;
import com.example.splashscreen.Classes.BucketLog_Details;
import com.example.splashscreen.R;
import com.example.splashscreen.utility.BucketlogRecycleView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BucketListLog extends Fragment {
    private View rootView;

    private ImageView new_spendIcon;
    private BucketlogRecycleView bucketlogRecycleView;
    private ArrayList<BucketLog_Details> bucketLog_details = new ArrayList<>();


    public BucketListLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_bucket_list_log, container, false);

        new_spendIcon = rootView.findViewById(R.id.add_new_bucket);

        setonClick();

        bucketLog_details.add(new BucketLog_Details("Daily walk 6km"));
        bucketLog_details.add(new BucketLog_Details("Go to walk"));
        setBucket_logRecycle();
        return rootView;
    }


    private void setonClick() {
        new_spendIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddNewbucketLog.class);
                startActivity(i);
            }
        });
    }

    private void setBucket_logRecycle() {
        RecyclerView recyclerView = rootView.findViewById(R.id.bucketList_View);
        bucketlogRecycleView = new BucketlogRecycleView(getActivity(), bucketLog_details);
        recyclerView.setAdapter(bucketlogRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
