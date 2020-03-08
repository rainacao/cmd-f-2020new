package com.example.cmdf2020new;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import model.plant.Plant;

public class PlantActivity extends AppCompatActivity {

    Plant testPlant1 = new Plant(2, 1);
    Plant testPlant2 = new Plant(4, 1);
    Plant testPlant3 = new Plant(6, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
    }

    public void goMakeTask(View v){
        Intent intent = new Intent(this, AddEditTaskActivity.class);
        startActivity(intent);
    }

    public void goToCalendar(View v){
        Intent intent = new Intent(this, TaskCalendarActivity.class);
        startActivity(intent);
    }

    public void goToSettings(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    final ImageView imageView = (ImageView) findViewById(R.id.plantImg);

    public void changePlantImg(Plant p){
        int level = p.getCurrentLevel();
        if (level < 2){
            imageView.setImageResource(R.drawable.plant_img0);
        }
        else if (level < 4){
            imageView.setImageResource(R.drawable.plant_img1);
        }
        else if (level < 6){
            imageView.setImageResource(R.drawable.plant_img2);
        }
        else{
            imageView.setImageResource(R.drawable.plant_img3);
        }
    }
}
