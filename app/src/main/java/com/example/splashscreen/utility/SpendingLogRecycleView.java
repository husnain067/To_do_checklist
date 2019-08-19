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
import com.example.splashscreen.Classes.SpendingLogDetails;
import com.example.splashscreen.R;

import java.util.ArrayList;
import java.util.List;

public class SpendingLogRecycleView extends RecyclerView.Adapter<SpendingLogRecycleView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<SpendingLogDetails> mSpend_data = new ArrayList<>();

    private Context mContext;


    public SpendingLogRecycleView(Context context, List<SpendingLogDetails> mData) {
        mContext = context;
        mSpend_data = mData;
        LayoutInflater inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xml_view_splendinglog, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        SpendingLogDetails spendingLogDetails=mSpend_data.get(position);

        holder.mDateView.setText(spendingLogDetails.getDate());
        holder.spentM.setText(spendingLogDetails.getSpentMoney());
        holder.storeN.setText(spendingLogDetails.getStoreName());
        holder.itemBudget.setText(spendingLogDetails.getItemBudget());
       holder.tick.setImageResource(spendingLogDetails.getTick());
       holder.cross.setImageResource(spendingLogDetails.getCross());
    }

    @Override
    public int getItemCount() {
        return mSpend_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mDateView;
        TextView spentM;
        TextView itemBudget;
        TextView storeN;
        ImageView tick;
        ImageView cross;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mDateView = itemView.findViewById(R.id.xml_date_view);
            spentM = itemView.findViewById(R.id.xml_spent_view);
            itemBudget = itemView.findViewById(R.id.xml_budget_view);
            storeN = itemView.findViewById(R.id.xml_storeN_view);
            tick = itemView.findViewById(R.id.xml_tick);
            cross = itemView.findViewById(R.id.xml_cross);


        }
    }
}
