package com.example.splashscreen.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.Classes.BookLog_Details;
import com.example.splashscreen.Classes.BucketLog_Details;
import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class BucketlogRecycleView extends RecyclerView.Adapter<BucketlogRecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<BucketLog_Details> mBucket_data = new ArrayList<>();

    private Context mContext;


    public BucketlogRecycleView(Context context, List<BucketLog_Details> mData) {
        mContext = context;
        mBucket_data = mData;
        LayoutInflater inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bucketxm_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        BucketLog_Details bucketLog_details = mBucket_data.get(position);
        holder.name.setText(bucketLog_details.getName());


    }

    @Override
    public int getItemCount() {
        return mBucket_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.pass_text_bucket);


        }
    }
}
