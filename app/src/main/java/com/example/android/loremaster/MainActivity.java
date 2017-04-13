package com.example.android.loremaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//    public static final String INTENT_KEY_CONSTANTS = "EXTRA_CONSTANTS";
//    public static final String INTENT_KEY_REPOSITORY = "EXTRA_QUESTIONS_DATA";
    public static final String INTENT_KEY_START_INDEX = "EXTRA_START_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
//        intent.putExtra(INTENT_KEY_START_INDEX, this.questionsData);
//        intent.putExtra(INTENT_KEY_CONSTANTS, this.questionsData);
//        intent.putExtra(INTENT_KEY_REPOSITORY, this.repository);
        startActivity(intent);
    }
}

