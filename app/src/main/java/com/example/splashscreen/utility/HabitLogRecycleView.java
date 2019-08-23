package com.example.splashscreen.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.Classes.HabitDetails;
import com.example.splashscreen.Classes.MoodDetails;
import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class HabitLogRecycleView extends RecyclerView.Adapter<HabitLogRecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<HabitDetails> mHabit_data = new ArrayList<>();
    private final int TAG_ONLINE_ID = R.string.happy_lablebackground;

    private Context mContext;


    public HabitLogRecycleView(Context context, List<HabitDetails> mData) {
        mContext = context;
        mHabit_data = mData;
        LayoutInflater inflater;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habit_viewxml, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        HabitDetails habitDetails = mHabit_data.get(position);
        holder.habitName.setText(habitDetails.getHabitName());

        holder.sevenView.setTag(TAG_ONLINE_ID, "");
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

        holder.sevenView.setOnClickListener(view -> {
            if (TextUtils.isEmpty(holder.sevenView.getTag(TAG_ONLINE_ID).toString())) {
                holder.sevenView.setBackground(mContext.getResources().getDrawable(R.drawable.angrymoodcolor));
                holder.sevenView.setTag(TAG_ONLINE_ID, "WRITE");
            } else {
                holder.sevenView.setBackground(mContext.getResources().getDrawable(R.drawable.border_line));
                holder.sevenView.setTag(TAG_ONLINE_ID, "");
            }
        });



    }

    @Override
    public int getItemCount() {
        return mHabit_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView habitName;
        TextView firstView;
        TextView secondView;
        TextView thirdView;
        TextView fourView;
        TextView fivetView;
        TextView sixtView;
        TextView sevenView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            habitName = itemView.findViewById(R.id.habit_text);
            firstView = itemView.findViewById(R.id.color_view1);
            secondView = itemView.findViewById(R.id.color_view2);
            thirdView = itemView.findViewById(R.id.color_view3);
            fourView = itemView.findViewById(R.id.color_view4);
            fivetView = itemView.findViewById(R.id.color_view5);
            sixtView = itemView.findViewById(R.id.color_view6);
            sevenView = itemView.findViewById(R.id.color_view7);


        }
    }
}

