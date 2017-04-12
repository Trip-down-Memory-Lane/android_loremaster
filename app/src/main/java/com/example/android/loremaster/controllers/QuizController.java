package com.example.android.loremaster.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.android.loremaster.constants.Questions;
import com.example.android.loremaster.entity.Question;
import com.example.android.loremaster.fragment.QuestionFragment;
import com.example.android.loremaster.fragment.SubmitScoreFragment;
import com.example.android.loremaster.repository.QuestionsRepository;

import static android.R.attr.fragment;

/**
 * Controls QuestionFragment entity behaviour
 */
public class QuizController extends FragmentStatePagerAdapter {

    private final QuestionsRepository repository;

    public QuizController(FragmentManager fm, QuestionsRepository repository) {
        super(fm);
        this.repository = repository;
    }

    @Override
    public Fragment getItem(int position) {
        // Feed the <layout_submit_score.xml> middle view if user is at last question fragment
        boolean isLastView = position == repository.getQuestions().size();
        if (isLastView) {
            return new SubmitScoreFragment();
        }

        Question question = this.repository.findById(position);

        Fragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable(QuestionFragment.QUESTION, question);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return this.repository.getQuestions().size() + 1;
    }
}
