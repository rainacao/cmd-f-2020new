package com.example.cmdf2020new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.cmdf2020new.tasksActivityHelpers.*;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import database.TasksDatabase;
import model.task.Task;
import model.time.Time;

/*
source: Jerry Zhao
from: dev2qa.com
 */
public class TasksActivity extends AppCompatActivity {

    //parallel arrays
    List<Task> taskList = new ArrayList<>();
    List<String> idList = new ArrayList<>();

    TasksDatabase myDB = TasksDatabase.myBD;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        listView = findViewById(R.id.list_view_with_checkbox);
        map = new HashMap<>();

        for (Task t: getDisplayItems()) {
            map.put(t, false);
        }

    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        // Get listview checkbox.
        final ListView listViewWithCheckbox = (ListView) findViewById(R.id.list_view_with_checkbox);

        // Initiate listview data.
        final List<ListViewItemDTO> initItemList = this.getInitViewItemDtoList();

        // Create a custom list view adapter with checkbox control.
        final ListViewItemCheckboxBaseAdapter listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemList);

        listViewDataAdapter.notifyDataSetChanged();

        // Set data adapter to list view.
        listViewWithCheckbox.setAdapter(listViewDataAdapter);

        // When list view item is clicked.
        listViewWithCheckbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                // Get user selected item.
                Object itemObject = adapterView.getAdapter().getItem(itemIndex);

                // Translate the selected item to DTO object.
                ListViewItemDTO itemDto = (ListViewItemDTO) itemObject;

                // Get the checkbox.
                CheckBox itemCheckbox = (CheckBox) view.findViewById(R.id.list_view_item_checkbox);

                // Reverse the checkbox and clicked item check state.
                if (itemDto.isChecked()) {
                    itemCheckbox.setChecked(false);
                    itemDto.setChecked(false);
                } else {
                    itemCheckbox.setChecked(true);
                    itemDto.setChecked(true);
                }

                Button done = (Button)findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int size = initItemList.size();
                        for(int i=0;i<size;i++)
                        {
                            ListViewItemDTO dto = initItemList.get(i);
                            if (dto.isChecked()) {
                                Task t= taskList.get(i);
                                myDB.updateData(idList.get(i), t.getName(), t.getDescription(), "", true);
                                //!!!!!! end time not set for testing purpose
                            }
                        }
                        listViewDataAdapter.notifyDataSetChanged();
                        finish();
                        startActivity(getIntent());
                    }
                });

            }
        });
    }

    // Return an initialize list of ListViewItemDTO.
    private List<ListViewItemDTO> getInitViewItemDtoList() {
        Cursor result = myDB.getAllData();

        while (result.moveToNext()) {
            if (result.getString(4).equals("0")) {
                taskList.add(new Task(result.getString(1), false, result.getString(2), null));
                idList.add(result.getString(0));
            }
        }

        List<ListViewItemDTO> ret = new ArrayList<ListViewItemDTO>();


        for(Task t: taskList)
        {
            String itemText = "\t" + t.getName();

            ListViewItemDTO dto = new ListViewItemDTO();
            dto.setChecked(false);
            dto.setItemText(itemText);

            ret.add(dto);
        }
        return ret;
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void onAddClicked(View v) {
        Intent intent = new Intent(this, AddEditTaskActivity.class);
        startActivity(intent);
    }


}
