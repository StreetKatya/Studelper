package com.example.studelper;

public class DataTime {
    String TEACHER_NAME;
    String GROUP_NAME;
    String SUBJECT_NAME;
    String DAY;
    String CLASSROOM;
    int CHISL_VERSEL;
    int NUMBER_LESSON;

    public DataTime(String SUBJECT_NAME, String TEACHER_NAME, String GROUP_NAME,String DAY,
                    String CLASSROOM, int CHISL_VERSEL, int NUMBER_LESSON) {
        this.TEACHER_NAME = TEACHER_NAME;
        this.GROUP_NAME = GROUP_NAME;
        this.SUBJECT_NAME = SUBJECT_NAME;
        this.DAY = DAY;
        this.CLASSROOM = CLASSROOM;
        this.CHISL_VERSEL = CHISL_VERSEL;
        this.NUMBER_LESSON = NUMBER_LESSON;
    }
}
