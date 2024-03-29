package com.example.splashscreen.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.Classes.MoviesDetails;
import com.example.splashscreen.Classes.SelectMoodDetails;
import com.example.splashscreen.R;
import com.example.splashscreen.databinding.ActivitySelectMoodsBinding;

import java.util.ArrayList;
import java.util.List;

public class SelectMoodsLogRecycleView extends RecyclerView.Adapter<SelectMoodsLogRecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<SelectMoodDetails> mSelectMood_details = new ArrayList<>();
    private final int TAG_ONLINE_ID = R.string.happy_lablebackground;
    private List<String> moodsClick = new ArrayList<>();
    MoodsClickListener moodsClickListener;
    private Context mContext;


    public SelectMoodsLogRecycleView(Context context, List<SelectMoodDetails> mData, MoodsClickListener mClickListener) {
        mContext = context;
        mSelectMood_details = mData;
        LayoutInflater inflater;
        moodsClick = new ArrayList<>();
        moodsClickListener = mClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selctmood_viewxml, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        SelectMoodDetails selectMoodDetails = mSelectMood_details.get(position);
        holder.mMood_name.setText(selectMoodDetails.getMoodName());


        holder.cardView.setTag(TAG_ONLINE_ID, "");
        holder.cardView.setOnClickListener(view -> {


            if (TextUtils.isEmpty(holder.cardView.getTag(TAG_ONLINE_ID).toString())) {
                if (moodsClick.size() >= 6) {
                    Toast.makeText(mContext, "You can select only six moods", Toast.LENGTH_SHORT).show();
                    return;
                }

                moodsClick.add(String.valueOf(holder.mMood_name.getText()));
                if (moodsClickListener != null) {
                    moodsClickListener.onListSelected(moodsClick);

                }
                holder.mMood_name.setTextColor(mContext.getColor(R.color.mdtp_white));
                holder.cardView.setCardBackgroundColor((mContext.getColor(R.color.button)));
                holder.cardView.setTag(TAG_ONLINE_ID, "WRITE");
            } else {
                moodsClick.remove(holder.mMood_name.getText());
                holder.mMood_name.setTextColor(mContext.getColor(R.color.mdtp_transparent_black));
                holder.cardView.setCardBackgroundColor(mContext.getColor(R.color.mdtp_white));
                holder.cardView.setTag(TAG_ONLINE_ID, "");
            }
        });


    }

    @Override
    public int getItemCount() {
        return mSelectMood_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mMood_name;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mMood_name = itemView.findViewById(R.id.mood_text);
            cardView = itemView.findViewById(R.id.card_view_mood);

        }
    }

    public interface MoodsClickListener {
        void onListSelected(List<String> mMoods_name);
    }
}
