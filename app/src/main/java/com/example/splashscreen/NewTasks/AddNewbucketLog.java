package com.example.splashscreen.NewTasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.splashscreen.BucketList;
import com.example.splashscreen.R;

public class AddNewbucketLog extends AppCompatActivity {
private Button saveBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_newbucket_log);
        saveBt=findViewById(R.id.save_bucket_log);
        setonClick();
    }
    private void setonClick() {
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddNewbucketLog.this, BucketList.class);
                startActivity(i);
            }
        });
    }
}
