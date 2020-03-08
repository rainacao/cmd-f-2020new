package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View v) {
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }

    public void goToCalendar(View v){
        Intent intent = new Intent (this, TaskCalendarActivity.class);
        startActivity(intent);
    }

}
