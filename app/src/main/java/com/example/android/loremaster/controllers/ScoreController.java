package com.example.android.loremaster.controllers;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.loremaster.MainActivity;
import com.example.android.loremaster.QuizActivity;
import com.example.android.loremaster.R;
import com.example.android.loremaster.entity.Question;
import com.example.android.loremaster.utilities.Repository;
import com.example.android.loremaster.utilities.ScoreButton;

import java.util.List;
import java.util.Locale;

/**
 * Controls UI on the activity_score.xnl
 * Calculates  total score in %, based on user answers
 * Creates dynamic Buttons (__AT-THIS-STAGE__ upgrade planned ) for every question
 * -- GREEN or RED colors for correct or incorrect answer.
 * -- Link to the question, revealing the correct answer.
 */
public class ScoreController {

    private static final boolean QUIZ_SUBMITTED_MODE = true;
    private TextView resultScore_Tv;

    public ScoreController(Context context) {
        double score = calculateScore();
        this.resultScore_Tv = (TextView) ((Activity) context).findViewById(R.id.activity_score_result_score_tv);
        setQuizModePreference(context);
        printScore(score);
        injectButtons(context);
    }

    /**
     * Calculates user-specific quiz score
     *
     * @return double, 0.00 - 1.00 user score ratio
     */
    private double calculateScore() {
        double correctAnswers = 0;
        double amountOfQuestions = 0;
        List<Question> questions = Repository.getQuestions();
        for (Question question : questions) {
            amountOfQuestions++;
            if (question.isAnsweredCorrectly()) {
                correctAnswers++;
            }
        }

        return correctAnswers / amountOfQuestions;
    }

    /**
     * Formats and prints the score in %
     *
     * @param score double, 0.00 - 1.00
     */
    private void printScore(double score) {
        String scorePercentage = String.format(Locale.US, "%d%%", (int) (score * 100));
        this.resultScore_Tv.setText(scorePercentage);
    }

    /**
     * Calls initButton and then adds the ScoreButton instance for every question
     * in the activity root ViewGroup.
     * Retrieves device pixel density to achieve density-independent button dimensions.
     *
     * @param context App context
     */
    private void injectButtons(Context context) {
        LinearLayout activityRoot = (LinearLayout) ((Activity) context).findViewById(R.id.activity_score_root);

        List<Question> questions = Repository.getQuestions();
        float pixelDensity = context.getResources().getDisplayMetrics().density;
        for (Question question: questions) {
            ScoreButton button = initButton(context, question, pixelDensity);
            activityRoot.addView(button);
        }
    }

    /**
     * Instantiates ScoreButton, sets the necessary parameters and attaches
     * click listener, which resumes QuizActivity and shows the View at given position.
     *
     * @param context App context
     * @param question Question Entity
     * @param pixelDensity Device's pixel density
     * @return ScoreButton instance object
     */
    private ScoreButton initButton(final Context context, Question question, float pixelDensity) {
        String subject = question.QUESTION_SUBJECT;
        int tag = question.getID();

        ScoreButton button =  new ScoreButton(context);
        button.setText(subject);
        button.setTag(tag);
        button.setMargins(16, 16, 16, 0, pixelDensity);
        button.style(question.isAnsweredCorrectly());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int questionId = (int) v.getTag();

                Intent questionActivity = new Intent(context, QuizActivity.class);
                questionActivity.putExtra(MainActivity.INTENT_KEY_START_INDEX, questionId);
                questionActivity.putExtra(QuizActivity.KEY_QUIZ_MODE, QUIZ_SUBMITTED_MODE);
                context.startActivity(questionActivity);
            }
        });

        return button;
    }

    /**
     * Sets Quiz to submitted mode. The QuizController then indicates the correct answers
     * for each question and disables further button selection.
     *
     * @param context App context
     */
    private void setQuizModePreference(Context context) {
        SharedPreferences settings =
                context.getSharedPreferences(QuizController.KEY_QUIZ_SETTINGS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(QuizActivity.KEY_QUIZ_MODE, QUIZ_SUBMITTED_MODE);
        editor.apply();
    }
}
