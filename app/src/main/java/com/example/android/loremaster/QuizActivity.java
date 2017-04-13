package com.example.android.loremaster;

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

import com.example.android.loremaster.controllers.QuizController;
import com.example.android.loremaster.utilities.Repository;

public class QuizActivity extends AppCompatActivity {

    private static final int VIEW_PAGER_DEFAULT_INDEX = 0;

    private ViewPager activityRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        int viewPagerStartIndex =
                intent.getIntExtra(
                        MainActivity.INTENT_KEY_START_INDEX,
                        VIEW_PAGER_DEFAULT_INDEX);

        setContentView(R.layout.activity_quiz);

        this.activityRoot = (ViewPager) findViewById(R.id.quiz_view_pager_root);
        QuizController quizController =
                new QuizController(activityRoot, getSupportFragmentManager());

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
        startActivity(activityScore);
    }

    /**
     * Called when user clicks on answer button. Inflatable at: <layout_question_template.xml>
     *
     * @param selectedButton Button view that the user selected as the correct answer
     */
    public void selectAnswer(View selectedButton) {
        int questionId = (int) this.activityRoot.getTag(); //??
        unSelectAllButtons();
        changeColor(selectedButton);
        Repository.findById(questionId).selectAnswer(selectedButton.getId());
    }

    private void unSelectAllButtons() {
        unSelect((Button) findViewById(R.id.quiz_answer_0_btn));
        unSelect((Button) findViewById(R.id.quiz_answer_1_btn));
        unSelect((Button) findViewById(R.id.quiz_answer_2_btn));
        unSelect((Button) findViewById(R.id.quiz_answer_3_btn));
    }

    private void unSelect(Button buttonToUnSelect) {
        buttonToUnSelect.getBackground().clearColorFilter();
    }

    private void changeColor(View selectedButton) {
        Drawable drawable = selectedButton.getBackground();
        drawable.setColorFilter(
                new PorterDuffColorFilter(
                        Color.BLUE, PorterDuff.Mode.MULTIPLY));
    }

}
