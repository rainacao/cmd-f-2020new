package com.example.cmdf2020new;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.cmdf2020new.tasksActivityHelpers.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.TasksDatabase;
import model.task.Task;

/*
source: Jerry Zhao
from: dev2qa.com
 */
public class TasksActivity extends AppCompatActivity {
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

                //Toast.makeText(getApplicationContext(), "select item text : " + itemDto.getItemText(), Toast.LENGTH_SHORT).show();
                // Click this button to disselect all listview items with checkbox unchecked.
                Button selectNoneButton = (Button)findViewById(R.id.add);
                selectNoneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int size = initItemList.size();
                        for(int i=0;i<size;i++)
                        {
                            ListViewItemDTO dto = initItemList.get(i);
                            dto.setChecked(false);
                        }

                        listViewDataAdapter.notifyDataSetChanged();
                    }
                });

            }
        });
    }

    // Return an initialize list of ListViewItemDTO.
    private List<ListViewItemDTO> getInitViewItemDtoList() {
        TasksDatabase myDB = TasksDatabase.myBD;
        Cursor result = myDB.getWritableDatabase().rawQuery("SELECT * FROM " + TasksDatabase.TABLE_NAME + " WHERE " + TasksDatabase.COL_5 + "= ?", new String[]{"0"});
        String[] itemTextArr = new String[result.getCount()];

        for(int i= 0; i < itemTextArr.length; i++) {    // while there is more data to read
            StringBuffer buffer = new StringBuffer();
            buffer.append("time: " + result.getString(3) + "\n");
            buffer.append("name: " + result.getString(1));
            itemTextArr[i] = buffer.toString();
        }

        List<ListViewItemDTO> ret = new ArrayList<ListViewItemDTO>();

        int length = itemTextArr.length;

        for(int i=0;i<length;i++)
        {
            String itemText = itemTextArr[i];

            ListViewItemDTO dto = new ListViewItemDTO();
            dto.setChecked(false);
            dto.setItemText(itemText);

            ret.add(dto);
        }
        return ret;
    }


}
