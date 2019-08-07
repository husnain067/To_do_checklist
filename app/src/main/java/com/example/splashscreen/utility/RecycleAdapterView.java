package com.example.splashscreen.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
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

public class RecycleAdapterView extends RecyclerView.Adapter<RecycleAdapterView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<Task_Details> mText = new ArrayList<>();

    private Context mContext;

    public RecycleAdapterView(Context context, List<Task_Details> mtexts) {
        mContext = context;
        mText = (ArrayList<Task_Details>) mtexts;
        LayoutInflater inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xmldesginview, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        final Task_Details var = mText.get(position);
        holder.name.setText(var.getTaskName());
        if (var.getPriorty()==0){
            holder.priorty_check.setText("Low");
            holder.cardView.setCardBackgroundColor(mContext.getColor(R.color.low_priorty));
        }
         if (var.getPriorty()==1){
            holder.priorty_check.setText("Meduim");
            holder.cardView.setCardBackgroundColor(mContext.getColor(R.color.meduim_priorty));
        }
         if (var.getPriorty()==2){
            holder.priorty_check.setText("High");
            holder.cardView.setCardBackgroundColor(mContext.getColor(R.color.high_priorty));
        }



    }

    @Override
    public int getItemCount() {
        return mText.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
      TextView priorty_check;
      CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.pass_text);
            priorty_check= itemView.findViewById(R.id.priorty_check);
            cardView= itemView.findViewById(R.id.priorty_card);



        }
    }
}
