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
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.Classes.BookLog_Details;
import com.example.splashscreen.Classes.MoviesDetails;
import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesLogRecycleView extends RecyclerView.Adapter<MoviesLogRecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<MoviesDetails> mMovies_details = new ArrayList<>();

    private Context mContext;


    public MoviesLogRecycleView(Context context, List<MoviesDetails> mData) {
        mContext = context;
        mMovies_details = mData;
        LayoutInflater inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xmlview_movielog, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        MoviesDetails moviesDetails=mMovies_details.get(position);
        holder.mMovie_name.setText(moviesDetails.getMovieName());


    }

    @Override
    public int getItemCount() {
        return mMovies_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
TextView mMovie_name;
RatingBar ratingBar;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mMovie_name = itemView.findViewById(R.id.movie_title);
            ratingBar=itemView.findViewById(R.id.rating_bar_xml);



        }
    }
}
