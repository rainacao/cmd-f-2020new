package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import database.SystemDatabase;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button button;
    private Spinner spinner;
    //private static final String[] paths = {"english", "中文", "🗾"};
    SeekBar music;
    SeekBar sfx;

    SystemDatabase myDB = SystemDatabase.myDB;

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

        Cursor savedData = myDB.getSettings();
        int saved_music = Integer.parseInt(savedData.getString(0));
        int saved_sfx = Integer.parseInt(savedData.getString(1));
        int saved_language_position = Integer.parseInt(savedData.getString(2));

        spinner = findViewById(R.id.languageChoose);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(saved_language_position);

        music = findViewById(R.id.seekBar);
        music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //int pval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //pval = progress;
                UpdateDatabase();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //tView.setText(pval + "/" + seekBar.getMax());
                UpdateDatabase();
            }
        });
        music.setProgress(saved_music);

        sfx = findViewById(R.id.seekBar2);
        sfx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //int pval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //pval = progress;
                UpdateDatabase();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //tView.setText(pval + "/" + seekBar.getMax());
                UpdateDatabase();
            }
        });
        sfx.setProgress(saved_sfx);
    }

    public void backToMenu(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        UpdateDatabase();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void UpdateDatabase() {
        myDB.updateSettingsData(music.getProgress(), sfx.getProgress(), spinner.getSelectedItemPosition());
    }
}
