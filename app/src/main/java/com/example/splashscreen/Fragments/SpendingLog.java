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

import com.example.splashscreen.NewTasks.AddNewSpendLog;
import com.example.splashscreen.Classes.SpendingLogDetails;
import com.example.splashscreen.R;
import com.example.splashscreen.utility.SpendingLogRecycleView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpendingLog extends Fragment {
private View rootView;

    private ImageView menu_popup;
    private ImageView new_spendIcon;
    private SpendingLogRecycleView spendingLogRecycleView;
    private ArrayList<SpendingLogDetails> spendingLogDetails = new ArrayList<>();

    public SpendingLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_spending_log, container, false);

        new_spendIcon = rootView.findViewById(R.id.add_new_spentView);


        setonClick();


        spendingLogDetails.add(new SpendingLogDetails("19/8","100","100","Alfa",R.drawable.tick,R.drawable.x_mark));
        spendingLogDetails.add(new SpendingLogDetails("20/8","200","300","Xyz",R.drawable.x_mark,R.drawable.tick));
        spendingLogDetails.add(new SpendingLogDetails("21/8","1000","2000","Mart",R.drawable.tick,R.drawable.tick));
        spendingLogDetails.add(new SpendingLogDetails("22/8","80","100","Metro",R.drawable.x_mark,R.drawable.x_mark));

        setSpending_logRecycle();




        return  rootView;
    }
    private void setonClick() {
        new_spendIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddNewSpendLog.class);
                startActivity(i);
            }
        });
    }

    private void setSpending_logRecycle() {
        RecyclerView recyclerView = rootView.findViewById(R.id.spendingLog_view);
        spendingLogRecycleView = new SpendingLogRecycleView(getActivity(), spendingLogDetails);
        recyclerView.setAdapter(spendingLogRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
