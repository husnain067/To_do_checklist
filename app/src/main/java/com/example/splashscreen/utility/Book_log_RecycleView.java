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
import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class Book_log_RecycleView extends RecyclerView.Adapter<Book_log_RecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<BookLog_Details> mBook_data = new ArrayList<>();

    private Context mContext;


    public Book_log_RecycleView(Context context, List<BookLog_Details> mData) {
        mContext = context;
        mBook_data = mData;
        LayoutInflater inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_log_xml_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        BookLog_Details bookLog_details=mBook_data.get(position);
        holder.mAuthor_name.setText(bookLog_details.getAuthorName());
        holder.mBook_name.setText(bookLog_details.getBookNAme());
        holder.mDate.setText(bookLog_details.getCurrentDate());
        holder.cardView.setCardBackgroundColor(Integer.parseInt(bookLog_details.getCardBackground()));

    }

    @Override
    public int getItemCount() {
        return mBook_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mBook_name;
        TextView mAuthor_name;
        TextView mDate;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mBook_name = itemView.findViewById(R.id.book_name);
            mAuthor_name = itemView.findViewById(R.id.author_name);
            cardView = itemView.findViewById(R.id.recyleAdapter_bookLog);
            mDate = itemView.findViewById(R.id.book_date);



        }
    }
}
