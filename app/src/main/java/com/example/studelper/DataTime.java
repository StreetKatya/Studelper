package com.example.studelper;

public class DataTime {
    int TEACHER_ID;
    int GROUP_ID;
    String SUBJECT_NAME;
    String DAY;
    String TIME_START;
    String TIME_END;
    String CLASSROOM;
    int CHISL_VERSEL;

    public DataTime(String SUBJECT_NAME, int TEACHER_ID,int GROUP_ID,String DAY, String TIME_START, String TIME_END, String CLASSROOM, int CHISL_VERSEL) {
        this.TEACHER_ID = TEACHER_ID;
        this.GROUP_ID = GROUP_ID;
        this.SUBJECT_NAME = SUBJECT_NAME;
        this.DAY = DAY;
        this.TIME_START = TIME_START;
        this.TIME_END = TIME_END;
        this.CLASSROOM = CLASSROOM;
        this.CHISL_VERSEL = CHISL_VERSEL;
    }
}
