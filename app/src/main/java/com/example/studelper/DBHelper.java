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
    private static final String TEACHER_NAME = "teacher_name";
    private static final String GROUP_NAME = "group_id";
    private static final String SUBJECT_NAME = "subject_name";
    private static final String CLASSROOM = "classroom";
    private static final String CHISL_VERSEL = "chisl_versel";
    private static final String DAY = "day_of_week";
    private static final String NUMBER_LESSON = "number_of_lesson";

    public DBHelper(@Nullable Context context) {
        super(context, "schedule.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TIME_TABLE + "(\n" +
                "\t " + ID + " integer PRIMARY KEY AUTOINCREMENT,\n" +
                "  \t " + SUBJECT_NAME + " varchar(50),\n" +
                "  \t " + TEACHER_NAME + " varchar(50),\n" +
                "  \t " + GROUP_NAME + " varchar(50),\n" +
                "  \t " + DAY + " varchar(20),\n" +
                "  \t " + CLASSROOM + " varchar(20),\n" +
                "  \t " + CHISL_VERSEL + " integer CHECK ("+CHISL_VERSEL+" IN (0, 1)),\n" +
                "  \t " + NUMBER_LESSON + " integer\n" +
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
        cv.put(TEACHER_NAME, data.TEACHER_NAME);
        cv.put(GROUP_NAME, data.GROUP_NAME);
        cv.put(DAY, data.DAY);
        cv.put(CLASSROOM, data.CLASSROOM);
        cv.put(CHISL_VERSEL, data.CHISL_VERSEL);
        cv.put(NUMBER_LESSON, data.NUMBER_LESSON);
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
                int id_2 = cursor.getColumnIndex(TEACHER_NAME);
                int id_5 = cursor.getColumnIndex(CLASSROOM);
                int id_6 = cursor.getColumnIndex(CHISL_VERSEL);
                int id_7 = cursor.getColumnIndex(GROUP_NAME);
                int id_8 = cursor.getColumnIndex(DAY);
                int id_9 = cursor.getColumnIndex(NUMBER_LESSON);

                DataTime data = new DataTime(cursor.getString(id_1),cursor.getString(id_2),
                        cursor.getString(id_7),cursor.getString(id_8),cursor.getString(id_5),
                        cursor.getInt(id_6), cursor.getInt(id_9));
                list.add(data);
            }while(cursor.moveToNext());
        }
        db.close();
        return list;
    }
}
