package com.example.splashscreen.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.Classes.MoodDetails;
import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class MoodLogRecycleView extends RecyclerView.Adapter<MoodLogRecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<MoodDetails> mMood_data = new ArrayList<>();
    private final int TAG_ONLINE_ID = R.string.happy_lablebackground;

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
        holder.firstView.setTag(TAG_ONLINE_ID, "");
        holder.secondView.setTag(TAG_ONLINE_ID, "");
        holder.thirdView.setTag(TAG_ONLINE_ID, "");
        holder.fourView.setTag(TAG_ONLINE_ID, "");
        holder.fivetView.setTag(TAG_ONLINE_ID, "");
        holder.sixtView.setTag(TAG_ONLINE_ID, "");

        holder.firstView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(holder.firstView.getTag(TAG_ONLINE_ID).toString())) {
                holder.firstView.setBackground(mContext.getResources().getDrawable(R.drawable.happymoodcolor));
                holder.firstView.setTag(TAG_ONLINE_ID, "WRITE");
            } else {
                holder.firstView.setBackground(mContext.getResources().getDrawable(R.drawable.border_line));
                holder.firstView.setTag(TAG_ONLINE_ID, "");
            }
        });

        holder.secondView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(holder.secondView.getTag(TAG_ONLINE_ID).toString())) {
                holder.secondView.setBackground(mContext.getResources().getDrawable(R.drawable.angrymoodcolor));
                holder.secondView.setTag(TAG_ONLINE_ID, "WRITE");
            } else {
                holder.secondView.setBackground(mContext.getResources().getDrawable(R.drawable.border_line));
                holder.secondView.setTag(TAG_ONLINE_ID, "");
            }
        });

        holder.thirdView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(holder.thirdView.getTag(TAG_ONLINE_ID).toString())) {
                holder.thirdView.setBackground(mContext.getResources().getDrawable(R.drawable.tiredmoodcolor));
                holder.thirdView.setTag(TAG_ONLINE_ID, "WRITE");
            } else {
                holder.thirdView.setBackground(mContext.getResources().getDrawable(R.drawable.border_line));
                holder.thirdView.setTag(TAG_ONLINE_ID, "");
            }
        });

        holder.fourView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(holder.fourView.getTag(TAG_ONLINE_ID).toString())) {
                holder.fourView.setBackground(mContext.getResources().getDrawable(R.drawable.sadmoodcolor));
                holder.fourView.setTag(TAG_ONLINE_ID, "WRITE");
            } else {
                holder.fourView.setBackground(mContext.getResources().getDrawable(R.drawable.border_line));
                holder.fourView.setTag(TAG_ONLINE_ID, "");
            }
        });

        holder.fivetView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(holder.fivetView.getTag(TAG_ONLINE_ID).toString())) {
                holder.fivetView.setBackground(mContext.getResources().getDrawable(R.drawable.fearfulmoodcolor));
                holder.fivetView.setTag(TAG_ONLINE_ID, "WRITE");
            } else {
                holder.fivetView.setBackground(mContext.getResources().getDrawable(R.drawable.border_line));
                holder.fivetView.setTag(TAG_ONLINE_ID, "");
            }
        });

        holder.sixtView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(holder.sixtView.getTag(TAG_ONLINE_ID).toString())) {
                holder.sixtView.setBackground(mContext.getResources().getDrawable(R.drawable.mellowmoodcolor));
                holder.sixtView.setTag(TAG_ONLINE_ID, "WRITE");
            } else {
                holder.sixtView.setBackground(mContext.getResources().getDrawable(R.drawable.border_line));
                holder.sixtView.setTag(TAG_ONLINE_ID, "");
            }
        });


    }

    @Override
    public int getItemCount() {
        return mMood_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dateView;
        TextView firstView;
        TextView secondView;
        TextView thirdView;
        TextView fourView;
        TextView fivetView;
        TextView sixtView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dateView = itemView.findViewById(R.id.mood_date_view);
            firstView = itemView.findViewById(R.id.first_view);
            secondView = itemView.findViewById(R.id.second_view);
            thirdView = itemView.findViewById(R.id.third_view);
            fourView = itemView.findViewById(R.id.four_view);
            fivetView = itemView.findViewById(R.id.five_view);
            sixtView = itemView.findViewById(R.id.six_view);


        }
    }
}

