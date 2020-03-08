package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cmdf2020new.MyApp;

import model.plant.Plant;

public class SystemDatabase extends SQLiteOpenHelper {
    public static SystemDatabase myDB = new SystemDatabase(MyApp.getContext());

    public static final String DATABASE_NAME = "System.db";
    public static final String TREE_TABLE = "tree_table";
    //LV | XP

    public static final String SETTINGS_TABLE = "settings_table";
    //MUSIC | SFX | LANGUAGE

    public SystemDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TREE_TABLE + " (LV INTEGER, XP INTEGER)");
        db.execSQL("create table " + SETTINGS_TABLE + " (MUSIC INTEGER, SFX INTEGER, LANGUAGE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TREE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SETTINGS_TABLE);
        onCreate(db);
    }

    public boolean updatePlantData(int lv, int xp) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("LV", lv);
        contentValues.put("XP", xp);

        SQLiteDatabase db = this.getWritableDatabase(); // instance of the SQLite database
        Cursor result = db.rawQuery("select * from " + TREE_TABLE, null);
        if (result.getCount() == 0) {
            db.insert(TREE_TABLE, null, contentValues);
        } else {
            db.execSQL("DELETE FROM " + TREE_TABLE);
            db.insert(TREE_TABLE, null, contentValues);
        }
        return true;
    }

    public Plant getPlant() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TREE_TABLE, null);
        if (result.getCount() == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("LV", 0);
            contentValues.put("XP", 0);
            db.insert(TREE_TABLE, null, contentValues);
        }
        return new Plant(Integer.parseInt(result.getString(0)), Integer.parseInt(result.getString(1)));
    }

    public boolean updateSettingsData(int music, int sfx, int language) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("MUSIC", music);
        contentValues.put("SFX", sfx);
        contentValues.put("LANGUAGE", language);

        SQLiteDatabase db = this.getWritableDatabase(); // instance of the SQLite database
        Cursor result = db.rawQuery("select * from " + SETTINGS_TABLE, null);
        if (result.getCount() == 0) {
            db.insert(SETTINGS_TABLE, null, contentValues);
        } else {
            db.execSQL("DELETE FROM " + SETTINGS_TABLE);
            db.insert(SETTINGS_TABLE, null, contentValues);
        }
        return true;
    }

    public Cursor getSettings() {
        SQLiteDatabase db = this.getWritableDatabase(); // instance of the SQLite database
        Cursor result = db.rawQuery("select * from " + SETTINGS_TABLE, null);
        if (result.getCount() == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("MUSIC", 0);
            contentValues.put("SFX", 0);
            contentValues.put("LANGUAGE", 0);
            db.insert(SETTINGS_TABLE, null, contentValues);
        }
        return result;
    }
}
