package com.example.android.loremaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.loremaster.controllers.ScoreController;
import com.example.android.loremaster.repository.QuestionsRepository;

public class ScoreActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        QuestionsRepository repository =
                (QuestionsRepository) getIntent()
                        .getSerializableExtra(HomeActivity.INTENT_KEY_REPOSITORY);

        ScoreController scoreController = new ScoreController(this, repository);

    }

    public void navigateToQuestion(View v) {
        int questionId = v.getId();

        Intent quizQuestionView = new Intent(this, QuizActivity.class);
        quizQuestionView.putExtra(HomeActivity.INTENT_KEY_START_INDEX, questionId);
        startActivity(quizQuestionView);
    }
}
