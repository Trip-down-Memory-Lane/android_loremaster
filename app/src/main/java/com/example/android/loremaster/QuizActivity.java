package com.example.android.loremaster;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.loremaster.controllers.QuizController;
import com.example.android.loremaster.repository.QuestionsRepository;

public class QuizActivity extends AppCompatActivity {

    private static final int VIEW_PAGER_DEFAULT_INDEX = 0;

    private QuestionsRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        this.repository = (QuestionsRepository) intent.getSerializableExtra(MainActivity.INTENT_KEY_REPOSITORY);
        int viewPagerStartIndex =
                intent.getIntExtra(
                        MainActivity.INTENT_KEY_START_INDEX,
                        VIEW_PAGER_DEFAULT_INDEX);

        setContentView(R.layout.activity_quiz);

        ViewPager activityRoot = (ViewPager) findViewById(R.id.quiz_view_pager);
        QuizController quizController = new QuizController(getSupportFragmentManager(), this.repository);

        activityRoot.setAdapter(quizController);
        activityRoot.setCurrentItem(viewPagerStartIndex);
    }

    /**
     * Launches the <activity_score.xml> and passes quiz answers data
     *
     * @param v Button view that triggers it
     */
    public void viewScore(View v) {
        Intent activityScore = new Intent(this, ScoreActivity.class);
        activityScore.putExtra(MainActivity.INTENT_KEY_REPOSITORY, this.repository);
        startActivity(activityScore);
    }
}
