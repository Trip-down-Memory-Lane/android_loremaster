package com.example.android.loremaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.loremaster.controllers.ScoreController;
import com.example.android.loremaster.utilities.Repository;

/**
 * Score screen of the app.
 */
public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ScoreController scoreController = new ScoreController(this);
    }

    public void viewQuiz(View v) {
        Intent quiz = new Intent(this, QuizActivity.class);
        startActivity(quiz);
    }
}
