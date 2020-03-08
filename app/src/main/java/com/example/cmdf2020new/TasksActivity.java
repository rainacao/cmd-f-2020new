package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import database.TasksDatabase;

public class TasksActivity extends AppCompatActivity {
    public static TasksDatabase myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        myDB = new TasksDatabase(this);
    }
}
