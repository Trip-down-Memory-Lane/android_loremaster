package com.example.android.loremaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
     * Called on Button press at <activity_main.xml>
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
     * Called on Button press at <activity_main.xml>. Shows or hides the rules container
     * based on current state - if VISIBLE -> set to GONE;
     *
     * @param v Button view
     */
    public void showHideRules(View v) {
        View rulesContainer =  findViewById(R.id.home_rules_container_rl);
        int buttonTextId;
        int containerVisibilityId;
        if (rulesContainer.getVisibility() == View.GONE) {
            containerVisibilityId = View.VISIBLE;
            buttonTextId = R.string.home_hide_rules_btn;
        } else {
            containerVisibilityId = View.GONE;
            buttonTextId = R.string.home_show_rules_btn;
        }

        rulesContainer.setVisibility(containerVisibilityId);
        ((Button) findViewById(R.id.home_show_rules_btn)).setText(buttonTextId);
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

