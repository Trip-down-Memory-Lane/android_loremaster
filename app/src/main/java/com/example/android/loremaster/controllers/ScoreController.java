package com.example.android.loremaster.controllers;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.loremaster.R;
import com.example.android.loremaster.entity.Question;
import com.example.android.loremaster.repository.QuestionsRepository;

import java.util.List;
import java.util.Locale;

public class ScoreController {

    public ScoreController(Context context, QuestionsRepository repository) {
        double score = calculateScore(repository);
        printScore(score);
        inflateButtons(context, repository);
    }

    private double calculateScore(QuestionsRepository repository) {
        double correctAnswers = 0;
        double amountOfQuestions = 0;
        List<Question> questions = repository.getQuestions();
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

    private void inflateButtons(Context context, QuestionsRepository repository) {
        LinearLayout activityRoot = (LinearLayout) ((Activity) context).findViewById(R.id.activity_score_root);

        List<Question> questions = repository.getQuestions();
        for (Question question: questions) {
            boolean isAnswered = question.isAnswered();
            String subject = question.QUESTION_SUBJECT;

            Button button = new Button(context);
            button.setText(subject);
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//            params.width = LayoutParams.MATCH_PARENT;
//            params.height = LayoutParams.WRAP_CONTENT;
            button.setLayoutParams(params);

            setMargins(button, 16, 16, 16, 0);

            if (isAnswered) {
                button.setBackgroundColor(Color.GREEN);
            } else {
                button.setBackgroundColor(Color.RED);
            }

            activityRoot.addView(button);
        }
    }

    private void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
