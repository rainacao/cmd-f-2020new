package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import database.TasksDatabase;

import static com.example.cmdf2020new.NotificationActivity.CHANNEL_ID;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //save temp data into perm
    }



}

