package database;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cmdf2020new.R;

public class TasksDatabase extends SQLiteOpenHelper {

    //public static TasksDatabase;
    public static final String DATABASE_NAME = "TASKS.db";
    public static final String TABLE_NAME = "tasks_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "END_TIME";
    public static final String COL_5 = "STATUS";


    public TasksDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    /*
    ID | NAME | DESCRIPTION | END TIME| STATUS
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // this method executes SQL queries on the database
        // here we are creating our table we have to give the table name, and then specify the name for each column
        // as well as its data type.  You can use the constant names as well here.
        db.execSQL("create table " + TABLE_NAME + " (COL_1 INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, ENDTIME STRING, STATUS BIT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String description, String endTime, boolean status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // contentValues instance allows us to put data in the columns using the put method.
        // First parameter is name of column, second parameter is the value to insert there.

        contentValues.put(COL_2, name);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, endTime);
        if (status) contentValues.put(COL_5, 1);
        else contentValues.put(COL_5, 0);

        //now need to insert this data into the database using the database instance db
        // three parameters, table name, null, contentValues instance
        // if the insert is unsuccessful the method returns -1 as a type long

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }


}

