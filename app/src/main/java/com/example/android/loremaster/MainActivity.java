package com.example.android.loremaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.loremaster.controllers.QuizController;
import com.example.android.loremaster.entity.Question;
import com.example.android.loremaster.utilities.Repository;

import java.util.List;

/**
 * Home screen of the app. Button press starts the quiz
 */
public class MainActivity extends AppCompatActivity {

    public static final String INTENT_KEY_START_INDEX = "EXTRA_START_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called on Button press at activity_main.xml
     *
     * @param v Button view, which was presses
     */
    public void startQuiz(View v) {
        resetQuestionEntities();
        resetQuizMode();
        Intent intent = new Intent(this, QuizActivity.class);

        startActivity(intent);
    }

    /**
     * Deletes QUIZ SETTINGS from sharedPreferences, thus QuizActivity starts in
     * NOT SUBMITTED mode.
     */
    private void resetQuizMode() {
        SharedPreferences settings =
                getSharedPreferences(QuizController.KEY_QUIZ_SETTINGS, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(QuizActivity.KEY_QUIZ_MODE);
        editor.commit();
    }

    /**
     * Resets user interaction from the question entities.
     */
    private void resetQuestionEntities() {
        List<Question> questions = Repository.getQuestions();
        for (Question question : questions) {
            question.reset();
        }
    }
}

