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
import android.widget.Toast;

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
        name = (EditText)findViewById(R.id.editText);
        description = (EditText)findViewById(R.id.editText2);
        time = (EditText)findViewById(R.id.editText3);
        id = (EditText)findViewById(R.id.editText4);

        done = (CheckBox)findViewById(R.id.checkBox2);
        textView = (TextView)findViewById(R.id.textView3);

        myDB = TasksDatabase.myBD;
        //MyApp.getContext().deleteDatabase("Tasks.db");
        //this.deleteDatabase("Tasks.db");

        updateTextView();
    }

    public void onAdd(View v) {
        showMessage("", "" + myDB.insertData(name.getText().toString(), description.getText().toString(), time.getText().toString(), done.isChecked()));

        updateTextView();
    }

    public void onDelete(View v) {
        Integer deletedRows = myDB.deleteData(id.getText().toString());
        if(deletedRows > 0)
            Toast.makeText(this, "Data Deleted",
                    Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Data NOT Deleted",
                    Toast.LENGTH_LONG).show();

        updateTextView();
    }

    public void onEdit(View v) {
        myDB.updateData(id.getText().toString(), name.getText().toString(), description.getText().toString(), time.getText().toString(), done.isChecked());
        updateTextView();
    }

    public void updateTextView() {
        Cursor result = myDB.getAllData();
        StringBuffer buffer = new StringBuffer();

        while (result.moveToNext()) {    // while there is more data to read
            buffer.append("Id: " + result.getString(0) + "\n");     // column 1
            buffer.append("name: " + result.getString(1) + "\n");
            buffer.append("description: " + result.getString(2) + "\n");
            buffer.append("time: " + result.getString(3) + "\n");
            buffer.append("done: " + result.getString(4) + "\n\n");
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
