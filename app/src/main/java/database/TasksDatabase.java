package database;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cmdf2020new.MyApp;

public class TasksDatabase extends SQLiteOpenHelper {
    public static TasksDatabase myDB  = new TasksDatabase(MyApp.getContext());

    //finalized, completed tasks
    public static final String DATABASE_NAME = "TASKS.db";
    public static final String TABLE_NAME = "tasks_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "END_TIME";

    //unfinished tasks
    public static final String TEMP_TABLE_NAME = "new_tasks_table";


    public TasksDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    /*
    ID | NAME | DESCRIPTION | END TIME
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // this method executes SQL queries on the database
        // here we are creating our table we have to give the table name, and then specify the name for each column
        // as well as its data type.  You can use the constant names as well here.
        db.execSQL("create table " + TABLE_NAME + " (COL_1 INTEGER PRIMARY KEY AUTOINCREMENT, COL_2 TEXT, COL_3 TEXT, COL_4 STRING)");
        db.execSQL("create table " + TEMP_TABLE_NAME + " (COL_1 INTEGER PRIMARY KEY AUTOINCREMENT, COL_2 TEXT, COL_3 TEXT, COL_4 STRING)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TEMP_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String description, String endTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // contentValues instance allows us to put data in the columns using the put method.
        // First parameter is name of column, second parameter is the value to insert there.

        contentValues.put(COL_2, name);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, endTime);

        //now need to insert this data into the database using the database instance db
        // three parameters, table name, null, contentValues instance
        // if the insert is unsuccessful the method returns -1 as a type long

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean insertTempData(String name, String description, String endTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // contentValues instance allows us to put data in the columns using the put method.
        // First parameter is name of column, second parameter is the value to insert there.

        contentValues.put(COL_2, name);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, endTime);

        //now need to insert this data into the database using the database instance db
        // three parameters, table name, null, contentValues instance
        // if the insert is unsuccessful the method returns -1 as a type long

        long result = db.insert(TEMP_TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME, null);
        return result;
    }

    public Cursor getTempData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TEMP_TABLE_NAME, null);
        return result;
    }

    public boolean updateData(String id, String name, String description, String endTime) {
        SQLiteDatabase db = this.getWritableDatabase(); // instance of the SQLite database
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, endTime);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        // first param is table name, second is the contentValues which we have set up and
        // will go into the correct spot when we find the slot where ID is = the id
        // provided.  The third param is telling the update method what to look for.
        // In this case we are checking to see if the ID is equal to the value that is
        // passed in the String array which is the fourth argument

        return true;
    }

    public boolean updateTempData(String id, String name, String description, String endTime) {
        SQLiteDatabase db = this.getWritableDatabase(); // instance of the SQLite database
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, endTime);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        // first param is table name, second is the contentValues which we have set up and
        // will go into the correct spot when we find the slot where ID is = the id
        // provided.  The third param is telling the update method what to look for.
        // In this case we are checking to see if the ID is equal to the value that is
        // passed in the String array which is the fourth argument

        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
        // first param is table name, second is telling the delete method what to look for.
        // In this case we are checking to see if the ID is equal to the value that is
        // passed in the String array which is the third argument
        // delete method returns the number of rows that are affected
    }

    public Integer deleteTempData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TEMP_TABLE_NAME, "ID = ?", new String[] {id});
        // first param is table name, second is telling the delete method what to look for.
        // In this case we are checking to see if the ID is equal to the value that is
        // passed in the String array which is the third argument
        // delete method returns the number of rows that are affected
    }

}

