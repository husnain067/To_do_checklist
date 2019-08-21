package com.example.splashscreen.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.Classes.MoodDetails;
import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class MoodLogRecycleView extends RecyclerView.Adapter<MoodLogRecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<MoodDetails> mMood_data = new ArrayList<>();

    private Context mContext;


    public MoodLogRecycleView(Context context, List<MoodDetails> mData) {
        mContext = context;
        mMood_data = mData;
        LayoutInflater inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modetracker_xmlview, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        MoodDetails moodDetails = mMood_data.get(position);
        holder.dateView.setText(moodDetails.getDate());
        //holder.firstView.setBackgroundColor(R.drawable.happymoodcolor);



    }

    @Override
    public int getItemCount() {
        return mMood_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dateView;
        TextView firstView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dateView = itemView.findViewById(R.id.mood_date_view);
            firstView=itemView.findViewById(R.id.first_view);


        }
    }
}
