package com.example.android.loremaster.controllers;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.loremaster.R;
import com.example.android.loremaster.entity.Question;
import com.example.android.loremaster.fragment.QuestionFragment;
import com.example.android.loremaster.fragment.SubmitScoreFragment;
import com.example.android.loremaster.utilities.Repository;

/**
 * Controls QuestionFragment entity behaviour
 */
public class QuizController extends FragmentStatePagerAdapter {

    private final ViewPager ACTIVITY_ROOT;

    public QuizController(ViewPager activityRoot, FragmentManager fm) {
        super(fm);
        this.ACTIVITY_ROOT = activityRoot;
    }

    @Override
    public Fragment getItem(int position) {
        // Feed the <layout_submit_score.xml> middle view if user is at last question fragment
        boolean isLastView = position == Repository.getQuestions().size();
        if (isLastView) {
            return new SubmitScoreFragment();
        }

        Question question = Repository.findById(position);
        selectCorrectAnswerButtonId(question);

        this.ACTIVITY_ROOT.setTag(question.getID()); //

        Fragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable(QuestionFragment.QUESTION, question);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        int questionsCount = Repository.getQuestions().size(); // Number of questions
        int submitScore = 1; // Submit score middle view
        return questionsCount + submitScore;
    }

    private void selectCorrectAnswerButtonId(Question question) {
        int correctAnswerBtnId;
        switch (question.getCorrectAnswerIndex()) {
            case 0: correctAnswerBtnId = R.id.quiz_answer_0_btn; break;
            case 1: correctAnswerBtnId = R.id.quiz_answer_1_btn; break;
            case 2: correctAnswerBtnId = R.id.quiz_answer_2_btn; break;
            case 3: correctAnswerBtnId = R.id.quiz_answer_3_btn; break;
            default:
                Log.d("SAMPLE_DATA_ERROR", "Wrong question data - Question.correctAnswerIndex");
                return;
        }

        question.setCorrectAnswerButtonId(correctAnswerBtnId);
    }
}
