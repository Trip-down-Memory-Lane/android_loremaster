package com.example.android.loremaster.controllers;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.android.loremaster.MainActivity;
import com.example.android.loremaster.QuizActivity;
import com.example.android.loremaster.R;
import com.example.android.loremaster.entity.Question;
import com.example.android.loremaster.utilities.Repository;
import com.example.android.loremaster.utilities.ScoreButton;

import java.util.List;
import java.util.Locale;

public class ScoreController {

    public ScoreController(Context context) {
        double score = calculateScore();
        printScore(score);
        inflateButtons(context);
    }

    private double calculateScore() {
        double correctAnswers = 0;
        double amountOfQuestions = 0;
        List<Question> questions = Repository.getQuestions();
        for (Question question : questions) {
            amountOfQuestions++;
            if (question.isAnswered()) {
                correctAnswers++;
            }
        }

        return correctAnswers / amountOfQuestions;
    }

    private void printScore(double score) {
        String scorePercentage = String.format(Locale.US, "%.2f", score * 100);
        // print score
    }

    private void inflateButtons(Context context) {
        LinearLayout activityRoot = (LinearLayout) ((Activity) context).findViewById(R.id.activity_score_root);

        List<Question> questions = Repository.getQuestions();
        float pixelDensity = context.getResources().getDisplayMetrics().density;
        for (Question question: questions) {
            ScoreButton button = initButton(context, question, pixelDensity);
            activityRoot.addView(button);
        }
    }

    private ScoreButton initButton(final Context context, Question question, float pixelDensity) {
        String subject = question.QUESTION_SUBJECT;
        int tag = question.getID();

        ScoreButton button =  new ScoreButton(context);
        button.setText(subject);
        button.setTag(tag);
        button.setMargins(16, 16, 16, 0, pixelDensity);
        button.style(question.isAnswered());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int questionId = (int) v.getTag();

                Intent questionActivity = new Intent(context, QuizActivity.class);
                questionActivity.putExtra(MainActivity.INTENT_KEY_START_INDEX, questionId);
                context.startActivity(questionActivity);
            }
        });

        return button;
    }
}
