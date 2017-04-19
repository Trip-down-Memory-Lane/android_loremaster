package com.example.android.trial_of_knowledge;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.trial_of_knowledge.controllers.QuizController;
import com.example.android.trial_of_knowledge.fragment.QuestionFragment;
import com.example.android.trial_of_knowledge.utilities.Repository;

public class QuizActivity extends AppCompatActivity {

    private static final int VIEW_PAGER_DEFAULT_INDEX = 0;
    public static final String KEY_QUIZ_MODE = "KEY_QUIZ_MODE";
    public static final boolean QUIZ_NOT_SUBMITTED = false;

    private ViewPager viewPager;
    private QuizController quizController;
    private boolean isQuizSubmitted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        int viewPagerStartIndex =
                intent.getIntExtra(
                        MainActivity.INTENT_KEY_START_INDEX,
                        VIEW_PAGER_DEFAULT_INDEX);

        setContentView(R.layout.activity_quiz);

        this.viewPager = (ViewPager) findViewById(R.id.quiz_view_pager_root);
        this.isQuizSubmitted =
                getSharedPreferences(QuizController.KEY_QUIZ_SETTINGS, MODE_PRIVATE)
                        .getBoolean(KEY_QUIZ_MODE, QUIZ_NOT_SUBMITTED);
        if (this.isQuizSubmitted) {
            findViewById(R.id.toolbar_view_score_tvBtn).setVisibility(View.VISIBLE);
        }

        this.quizController =
                new QuizController(getSupportFragmentManager(), this.isQuizSubmitted);

        this.viewPager.setAdapter(this.quizController);
        this.viewPager.setCurrentItem(viewPagerStartIndex);
    }

    /**
     * Launches the <activity_score.xml>
     *
     * @param v Button view that triggers it
     */
    public void viewScore(View v) {
        Intent activityScore = new Intent(this, ScoreActivity.class);
        startActivity(activityScore);
    }

    /**
     * Launches the <activity_main.xml>
     *
     * @param v Button view that triggers it
     */
    public void viewHome(View v) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    /**
     * Called when user clicks on answer button. Inflatable at: <layout_question_template.xml>
     *
     * @param selectedButton Button view that the user selected as the correct answer
     */
    public void selectAnswerButton(View selectedButton) {
        if (this.isQuizSubmitted) {
            return;
        }

        int currentFragmentPosition = this.viewPager.getCurrentItem();
        QuestionFragment currentFragment =
                this.quizController.getFragmentAtPosition(
                        currentFragmentPosition);
        int questionId = currentFragment.getQuestionId(); //??
        unSelectAllButtons(currentFragment);
        changeColor(selectedButton);
        Repository.findById(questionId).selectAnswer(selectedButton.getId());
    }

    /**
     * Calls unSelect for each button.
     *
     * @param currentFragment The currently visible fragment object
     */
    private void unSelectAllButtons(QuestionFragment currentFragment) {
        unSelect(currentFragment.getAnswer_0_Btn());
        unSelect(currentFragment.getAnswer_1_Btn());
        unSelect(currentFragment.getAnswer_2_Btn());
        unSelect(currentFragment.getAnswer_3_Btn());
    }

    /**
     * Resets background color of a given button.
     *
     * @param buttonToUnSelect The Button object
     */
    private void unSelect(Button buttonToUnSelect) {
        buttonToUnSelect.getBackground().clearColorFilter();
    }

    /**
     * Sets color filter on the button background, to flag as selected answer by the user
     *
     * @param selectedButton The Button object, that the user selected as a correct answer
     */
    private void changeColor(View selectedButton) {
        Drawable drawable = selectedButton.getBackground();
        drawable.setColorFilter(
                new PorterDuffColorFilter(
                        Color.BLUE, PorterDuff.Mode.MULTIPLY));
    }

}
