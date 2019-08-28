package com.example.splashscreen.NewTasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.splashscreen.R;
import com.example.splashscreen.Spending_Log;

public class AddNewSpendLog extends AppCompatActivity {
private Button saveBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_spend_log);
        saveBt=findViewById(R.id.save_spend);
        setonClick();
    }

    private void setonClick() {
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddNewSpendLog.this, Spending_Log.class);
                startActivity(i);
                finish();
            }
        });
    }
}
