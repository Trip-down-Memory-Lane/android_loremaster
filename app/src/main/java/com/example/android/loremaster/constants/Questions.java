package com.example.android.loremaster.constants;

import android.content.Context;

import com.example.android.loremaster.R;

import java.io.Serializable;

/**
 * Holds sample questions data for testing and presentation.
 */
public class Questions implements Serializable {

    public final int QUESTION_1_ID;
    public final String QUESTION_1_SUBJECT;
    public final String QUESTION_1_QUESTION_BODY;
    public final String QUESTION_1_ANSWER_01;
    public final String QUESTION_1_ANSWER_02;
    public final String QUESTION_1_ANSWER_03;
    public final String QUESTION_1_ANSWER_04;

    public final int QUESTION_2_ID;
    public final String QUESTION_2_SUBJECT;
    public final String QUESTION_2_QUESTION_BODY;
    public final String QUESTION_2_ANSWER_01;
    public final String QUESTION_2_ANSWER_02;
    public final String QUESTION_2_ANSWER_03;
    public final String QUESTION_2_ANSWER_04;

    public final int QUESTION_3_ID;
    public final String QUESTION_3_SUBJECT;
    public final String QUESTION_3_QUESTION_BODY;
    public final String QUESTION_3_ANSWER_01;
    public final String QUESTION_3_ANSWER_02;
    public final String QUESTION_3_ANSWER_03;
    public final String QUESTION_3_ANSWER_04;


    /**
     * Initializes constant variables to be reused across the app.
     *
     * @param context Application context
     */
    public Questions(Context context) {
        this.QUESTION_1_ID = 0;
        this.QUESTION_1_SUBJECT = context.getResources().getString(R.string.question_1_subject);
        this.QUESTION_1_QUESTION_BODY = context.getResources().getString(R.string.question_1_body);
        this.QUESTION_1_ANSWER_01 = context.getResources().getString(R.string.question_1_answer_01);
        this.QUESTION_1_ANSWER_02 = context.getResources().getString(R.string.question_1_answer_02);
        this.QUESTION_1_ANSWER_03 = context.getResources().getString(R.string.question_1_answer_03);
        this.QUESTION_1_ANSWER_04 = context.getResources().getString(R.string.question_1_answer_04);

        this.QUESTION_2_ID = 1;
        this.QUESTION_2_SUBJECT = context.getResources().getString(R.string.question_2_subject);
        this.QUESTION_2_QUESTION_BODY = context.getResources().getString(R.string.question_2_body);
        this.QUESTION_2_ANSWER_01 = context.getResources().getString(R.string.question_2_answer_01);
        this.QUESTION_2_ANSWER_02 = context.getResources().getString(R.string.question_2_answer_02);
        this.QUESTION_2_ANSWER_03 = context.getResources().getString(R.string.question_2_answer_03);
        this.QUESTION_2_ANSWER_04 = context.getResources().getString(R.string.question_2_answer_04);

        this.QUESTION_3_ID = 2;
        this.QUESTION_3_SUBJECT = context.getResources().getString(R.string.question_3_subject);
        this.QUESTION_3_QUESTION_BODY = context.getResources().getString(R.string.question_3_body);
        this.QUESTION_3_ANSWER_01 = context.getResources().getString(R.string.question_3_answer_01);
        this.QUESTION_3_ANSWER_02 = context.getResources().getString(R.string.question_3_answer_02);
        this.QUESTION_3_ANSWER_03 = context.getResources().getString(R.string.question_3_answer_03);
        this.QUESTION_3_ANSWER_04 = context.getResources().getString(R.string.question_3_answer_04);
    }
}
