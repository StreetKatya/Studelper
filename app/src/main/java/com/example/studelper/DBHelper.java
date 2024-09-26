package com.example.studelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TIME_TABLE = "TimeTable";
    private static final String ID = "id";
    private static final String TEACHER_ID = "teacher_id";
    private static final String GROUP_ID = "group_id";
    private static final String SUBJECT_NAME = "subject_name";
    private static final String TIME_START = "timeStart";
    private static final String TIME_END = "timeEnd";
    private static final String CLASSROOM = "classroom";
    private static final String CHISL_VERSEL = "chisl_versel";
    private static final String DAY = "day_of_week";

    public DBHelper(@Nullable Context context) {
        super(context, "stud.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TIME_TABLE + "(\n" +
                "\t " + ID + " integer PRIMARY KEY AUTOINCREMENT,\n" +
                "  \t " + SUBJECT_NAME + " varchar(50),\n" +
                "  \t " + TEACHER_ID + " integer,\n" +
                "  \t " + GROUP_ID + " integer,\n" +
                "  \t " + DAY + " varchar(20),\n" +
                "  \t " + TIME_START + " varchar(20),\n" +
                "  \t " + TIME_END + " varchar(20),\n" +
                "  \t " + CLASSROOM + " varchar(20),\n" +
                "  \t " + CHISL_VERSEL + " integer CHECK ("+CHISL_VERSEL+" IN (0, 1))\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void DeleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TIME_TABLE, null,null);
        db.close();
    }

    public void Add(DataTime data){
        boolean isAccess = true;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SUBJECT_NAME, data.SUBJECT_NAME);
        cv.put(TEACHER_ID, data.TEACHER_ID);
        cv.put(GROUP_ID, data.GROUP_ID);
        cv.put(DAY, data.DAY);
        cv.put(TIME_START, data.TIME_START);
        cv.put(TIME_END, data.TIME_END);
        cv.put(CLASSROOM, data.CLASSROOM);
        cv.put(CHISL_VERSEL, data.CHISL_VERSEL);
        db.insert(TIME_TABLE,null, cv);
        db.close();
    }

    public LinkedList<DataTime> GetAll(){
        LinkedList<DataTime> list = new LinkedList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TIME_TABLE,null,null,null,
                null,null,null);
        if(cursor.moveToFirst()){
            do{
                int id_1 = cursor.getColumnIndex(SUBJECT_NAME);
                int id_2 = cursor.getColumnIndex(TEACHER_ID);
                int id_3 = cursor.getColumnIndex(TIME_START);
                int id_4 = cursor.getColumnIndex(TIME_END);
                int id_5 = cursor.getColumnIndex(CLASSROOM);
                int id_6 = cursor.getColumnIndex(CHISL_VERSEL);
                int id_7 = cursor.getColumnIndex(GROUP_ID);
                int id_8 = cursor.getColumnIndex(DAY);

                DataTime data = new DataTime(cursor.getString(id_1),cursor.getInt(id_2),
                        cursor.getInt(id_7),cursor.getString(id_8),cursor.getString(id_3),
                        cursor.getString(id_4),cursor.getString(id_5), cursor.getInt(id_6));
                list.add(data);
            }while(cursor.moveToNext());
        }
        db.close();
        return list;
    }
}
