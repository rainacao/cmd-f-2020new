package com.example.cmdf2020new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import database.TasksDatabase;
import model.task.Task;

public class AddEditTaskActivity extends AppCompatActivity {
    EditText name;
    EditText description;
    EditText time;
    EditText id;

    CheckBox done;
    TextView textView;

    TasksDatabase myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);
         name = findViewById(R.id.editText);
         description = findViewById(R.id.editText2);
         time = findViewById(R.id.editText3);
         id = findViewById(R.id.editText4);

         done = findViewById(R.id.checkBox2);
         textView = findViewById(R.id.textView3);

         myDB = new TasksDatabase(this);

        updateTextView();
    }

    public void onAdd(View v) {
        if(done.isChecked()) {
            showMessage("", "" + myDB.insertData(name.getText().toString(), description.getText().toString(), time.getText().toString()));
        } else {
            showMessage("", "" + myDB.insertTempData(name.getText().toString(), description.getText().toString(), time.getText().toString()));
        }
        updateTextView();
    }

    public void onDelete(View v) {
        if (done.isChecked()) {
            myDB.deleteData(id.getText().toString());
        } else {
            myDB.deleteTempData(id.getText().toString());
        }
        updateTextView();
    }

    public void onEdit(View v) {
        if (done.isChecked()) {
            myDB.updateData(id.getText().toString(), name.getText().toString(), description.getText().toString(), time.getText().toString());
        } else {
            myDB.updateTempData(id.getText().toString(), name.getText().toString(), description.getText().toString(), time.getText().toString());
        }
        updateTextView();
    }

    public void updateTextView() {
        //Cursor result = TasksDatabase.myDB.getAllData();
        Cursor result2 = myDB.getTempData();
        StringBuffer buffer = new StringBuffer();
        /*
        while (result.moveToNext()) {    // while there is more data to read
            buffer.append("Id: " + result.getString(0) + "\n");     // column 1
            buffer.append("name: " + result.getString(1) + "\n");
            buffer.append("description: " + result.getString(2) + "\n");
            buffer.append("time: " + result.getString(3) + "\n\n");
        }*/

        while (result2.moveToNext()) {    // while there is more data to read
            buffer.append("Id: " + result2.getString(0) + "\n");     // column 1
            buffer.append("name: " + result2.getString(1) + "\n");
            buffer.append("description: " + result2.getString(2) + "\n");
            buffer.append("time: " + result2.getString(3) + "\n\n");
        }

        textView.setText(buffer.toString());
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
