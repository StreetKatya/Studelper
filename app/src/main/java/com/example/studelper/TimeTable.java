//package com.example.studelper;
//
//import androidx.annotation.NonNull;
//import androidx.room.Database;
//import androidx.room.DatabaseConfiguration;
//import androidx.room.Entity;
//import androidx.room.InvalidationTracker;
//import androidx.room.PrimaryKey;
//import androidx.room.RoomDatabase;
//import androidx.sqlite.db.SupportSQLiteOpenHelper;
//
//@Entity(tableName = "TimeTable")
//@Database(entities = {TimeTable.class}, version = 1)
//public class TimeTable extends RoomDatabase{
//
//    @PrimaryKey(autoGenerate = true)
//    public int id;
//
//    public String dayOfWeek; // День недели (например, "Понедельник", "Вторник")
//    public String subject; // Название предмета
//    public String teacher; // Имя преподавателя
//    public String timeStart; // Время начала занятия (например, "09:00")
//    public String timeEnd; // Время окончания занятия (например, "10:30")
//    public String classroom; // Номер аудитории
//
//    // Конструктор
//    public TimeTable(String dayOfWeek, String subject, String teacher, String timeStart, String timeEnd, String classroom) {
//        this.dayOfWeek = dayOfWeek;
//        this.subject = subject;
//        this.teacher = teacher;
//        this.timeStart = timeStart;
//        this.timeEnd = timeEnd;
//        this.classroom = classroom;
//    }
//    public TimeTable(String dayOfWeek, String subject, String teacher, String timeStart, String timeEnd, String classroom) {
//        super(dayOfWeek, subject, teacher, timeStart, timeEnd, classroom);
//    }
//
//    @Override
//    public void clearAllTables() {
//
//    }
//
//    @NonNull
//    @Override
//    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
//        return null;
//    }
//
//    @NonNull
//    @Override
//    protected InvalidationTracker createInvalidationTracker() {
//        return null;
//    }
//}
//
