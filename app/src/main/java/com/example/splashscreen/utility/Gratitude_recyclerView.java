package com.example.splashscreen.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class Gratitude_recyclerView extends RecyclerView.Adapter<Gratitude_recyclerView.ViewHolder> implements View.OnClickListener{
    private static final String TAG = "RecyclerViewAdapter";
    ClickListner clickListnerl;
    private ArrayList<String> mDate = new ArrayList<>();
    List<CardView> itemViewList = new ArrayList<>();

    private Context mContext;

    public Gratitude_recyclerView(Context context, List<String> mDates,ClickListner clickListner) {
        mContext = context;
        mDate = (ArrayList<String>) mDates;
        clickListnerl = clickListner;
        LayoutInflater inflater;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gratitude_xml_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String var = mDate.get(position);
        holder.date_view.setText(var);
        itemViewList.add(holder.cardView);
       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (clickListnerl!=null){clickListnerl.onClick(position);}

           }
       });

    }



    @Override
    public int getItemCount() {
        return mDate.size();
    }

    @Override
    public void onClick(View view) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView date_view;
        ImageView imageView;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date_view = itemView.findViewById(R.id.date_id);
            imageView = itemView.findViewById(R.id.imageView_color_font);
            cardView = itemView.findViewById(R.id.gratitudeLog_cardView);


        }
    }
}
