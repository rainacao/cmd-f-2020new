package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity{
    private Button button;
    private Spinner spinner;
    //private static final String[] paths = {"english", "中文", "🗾"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        button = (Button) findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v){
                backToMenu();
            }
        });
    }

    public void backToMenu(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

}
