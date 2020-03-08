package com.example.cmdf2020new;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import database.SystemDatabase;
import model.plant.Plant;

public class PlantActivity extends AppCompatActivity {

    private ImageView image;   // the plant and its evolution
    private TextView lvlNow; //current level
    private TextView lvlNext; //next level

    Plant testPlant0 = new Plant(0, 1);
    Plant testPlant1 = new Plant(2, 1);
    Plant testPlant2 = new Plant(5, 4);
    Plant testPlant3 = new Plant(6, 4);
    Plant plant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        plant = SystemDatabase.myDB.getPlant();
        getLvlNow(testPlant3);
        getLvlNext(testPlant3);
        //lvlNow = (TextView) findViewById(R.id.initLevelText);
        //lvlNext = (TextView) findViewById(R.id.nextLevelText);
        updatePlantImage(testPlant3);

    }

    public TextView getLvlNow(Plant p) {
        lvlNow = (TextView) findViewById(R.id.initLevelText);
        lvlNow.setText(Integer.toString(p.getCurrentLevel()));
        return lvlNow;
    }

    public TextView getLvlNext(Plant p) {
        lvlNext = (TextView) findViewById(R.id.nextLevelText);
        lvlNext.setText(Integer.toString(p.getCurrentLevel() + 1));
        return lvlNext;
    }

    public void goMakeTask(View v) {
        Intent intent = new Intent(this, AddEditTaskActivity.class);
        startActivity(intent);
    }

    public void goToTasks(View v) {
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }

    public void goToCalendar(View v) {
        Intent intent = new Intent(this, TaskCalendarActivity.class);
        startActivity(intent);
    }

    public void goToSettings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void updatePlantImage(Plant p) {
        image = findViewById(R.id.plantImg);
        p.addEXP(TasksActivity.exp);
        int level = p.getCurrentLevel();
        if (level < 2) {
            image.setImageResource(R.drawable.plant_img0);
        } else if (level < 4) {
            image.setImageResource(R.drawable.plant_img1);
        } else if (level < 6) {
            image.setImageResource(R.drawable.plant_img2);
        } else {
            image.setImageResource(R.drawable.plant_img3);
        }
        TasksActivity.resetEXP();
    }
}
