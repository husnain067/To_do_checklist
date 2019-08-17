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
import com.example.splashscreen.Classes.Finish_book_names;
import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class Finish_Book_log_RecycleView extends RecyclerView.Adapter<Finish_Book_log_RecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<Finish_book_names> mBook_data = new ArrayList<>();

    private Context mContext;


    public Finish_Book_log_RecycleView(Context context, List<Finish_book_names> mData) {
        mContext = context;
        mBook_data = mData;
        LayoutInflater inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.finish_book_log, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Finish_book_names bookLog_details=mBook_data.get(position);

        holder.mBook_name.setText(bookLog_details.getBookName());


    }

    @Override
    public int getItemCount() {
        return mBook_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mBook_name;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mBook_name = itemView.findViewById(R.id.finish_book_name);



        }
    }
}
