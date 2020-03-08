package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import model.plant.Plant;

public class MainActivity extends AppCompatActivity {

    //public static Plant userPlant = new Plant(2, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToPlant(View v) {
        Intent intent = new Intent(this, PlantActivity.class);
        startActivity(intent);
    }

    public void goMakeTask(View v) {
        Intent intent = new Intent(this, AddEditTaskActivity.class);
        startActivity(intent);
    }

    public void goToTasks(View v) {
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }

    public void goToCalendar(View v){
        Intent intent = new Intent (this, TaskCalendarActivity.class);
        startActivity(intent);
    }

    public void goToSettings(View v){
        Intent intent = new Intent (this, SettingsActivity.class);
        startActivity(intent);
    }


}
