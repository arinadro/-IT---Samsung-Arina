package com.example.guessthemelody;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "melody";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "b_melody_list";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "melody_name";
    private static final String COL_ANS  = "melody_ans";
    private static final String COL_LEVEL  = "melody_level";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = String.format( "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL);", TABLE_NAME, COL_ID, COL_NAME, COL_ANS, COL_LEVEL);

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}


    public void clear() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
    }

    public void insertData(ArrayList<Melody> melody){
        SQLiteDatabase db = this.getWritableDatabase();

        String count = "SELECT count(*) FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(count, null);
        cursor.moveToFirst();
        int icount = cursor.getInt(0);
        if(icount == 0) {
            ContentValues value = new ContentValues();
            for(int i = 0; i < melody.size(); i++){
                value.put(COL_NAME, melody.get(i).getName());
                value.put(COL_ANS, melody.get(i).getAnswe());
                value.put(COL_LEVEL, melody.get(i).getLevel());
                db.insertWithOnConflict(
                        TABLE_NAME, null, value, SQLiteDatabase.CONFLICT_REPLACE);
            }
        }
    }

    public ArrayList<Melody> getData(int level){
        String levelSt = Integer.toString(level);

        Melody melody;
        ArrayList<Melody> allMelody = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int intName = cursor.getColumnIndex(COL_NAME);
            int intAns = cursor.getColumnIndex(COL_ANS);
            int intLevel = cursor.getColumnIndex(COL_LEVEL);

            String name = cursor.getString(intName);
            int ans = Integer.parseInt(cursor.getString(intAns));
            int levelData = Integer.parseInt(cursor.getString(intLevel));

            if(level == levelData){
                melody = new Melody(name, ans, levelData);
                allMelody.add(melody);
            }
        }

        return allMelody;
    }
}
