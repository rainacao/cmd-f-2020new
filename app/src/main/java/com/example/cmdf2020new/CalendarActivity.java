package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import android.graphics.Color;

public class CalendarActivity extends AppCompatActivity {

    CalendarView simpleCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        simpleCalendarView = findViewById(R.id.CalendarViewer);
        simpleCalendarView.setFocusedMonthDateColor(Color.RED);
        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE);
        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED);
        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN);

        final Button viewTasksButton = findViewById(R.id.viewTasksButton);
        final Button makeTaskButton = findViewById(R.id.makeTaskButton);

        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(), dayOfMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_LONG).show();
                viewTasksButton.setVisibility(View.VISIBLE);
                makeTaskButton.setVisibility(View.VISIBLE);
            }
        });
    }

    public void goToTasks(View v) {
        Intent intent = new Intent (this, TasksActivity.class);
        startActivity(intent);
    }

    public void goMakeTask(View v) {
        Intent intent = new Intent (this, AddEditTaskActivity.class);
        startActivity(intent);
    }

    public void goToPlant(View v) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}