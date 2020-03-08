package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import database.TasksDatabase;

public class AddEditTaskActivity extends AppCompatActivity {
    EditText name = findViewById(R.id.editText);
    EditText description = findViewById(R.id.editText2);
    EditText time = findViewById(R.id.editText3);
    EditText id = findViewById(R.id.editText4);

    CheckBox done = findViewById(R.id.checkBox2);
    TextView textView = findViewById(R.id.textView3);

    Button add = findViewById(R.id.button3);
    Button edit = findViewById(R.id.button4);
    Button delete = findViewById(R.id.button5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);
        updateTextView();
    }

    public void onAdd(View v) {
        if(done.isChecked()) {
            TasksDatabase.myDB.insertData(name.getText().toString(), description.getText().toString(), time.getText().toString());
        } else {
            TasksDatabase.myDB.insertTempData(name.getText().toString(), description.getText().toString(), time.getText().toString());
        }
        updateTextView();
    }

    public void onDelete(View v) {
        if (done.isChecked()) {
            TasksDatabase.myDB.deleteData(id.getText().toString());
        } else {
            TasksDatabase.myDB.deleteTempData(id.getText().toString());
        }
        updateTextView();
    }

    public void onEdit(View v) {
        if (done.isChecked()) {
            TasksDatabase.myDB.updateData(id.getText().toString(), name.getText().toString(), description.getText().toString(), time.getText().toString());
        } else {
            TasksDatabase.myDB.updateTempData(id.getText().toString(), name.getText().toString(), description.getText().toString(), time.getText().toString());
        }
        updateTextView();
    }

    public void updateTextView() {
        textView.setText(TasksDatabase.myDB.getAllData().toString() + "\n\n" + TasksDatabase.myDB.getTempData().toString());
    }
}
