package com.example.android.trial_of_knowledge.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.ViewGroup;

import com.example.android.trial_of_knowledge.R;
import com.example.android.trial_of_knowledge.entity.Question;
import com.example.android.trial_of_knowledge.fragment.QuestionFragment;
import com.example.android.trial_of_knowledge.fragment.SubmitScoreFragment;
import com.example.android.trial_of_knowledge.utilities.Repository;

import java.util.Map;

/**
 * Controls QuestionFragment entity behaviour
 */
public class QuizController extends FragmentStatePagerAdapter {

    public static final String KEY_QUIZ_SETTINGS = "QUIZ_SETTINGS";

    private Map<Integer, QuestionFragment> fragmentsByPosition;
    private boolean isQuizSubmitted;

    /**
     * @param fm FragmentManager passed by the ViewPager
     */
    public QuizController(FragmentManager fm, boolean isQuizSubmitted) {
        super(fm);
        fragmentsByPosition = new ArrayMap<>();
        this.isQuizSubmitted = isQuizSubmitted;
    }

    /**
     * Prepares the next Fragment item at given position.
     * Creates a new instance of QuestionFragment and attaches Bundle with Question Entity ID
     * and then keeps the fragment mapped by its position in a private field.
     *
     * @param position The position in the ViewPager
     * @return Fragment object
     */
    @Override
    public Fragment getItem(int position) {
        // Feed the <layout_submit_score.xml> middle view if user is at last question fragment
        boolean isLastView = position == Repository.getQuestions().size();
        if (isLastView && !this.isQuizSubmitted) {
            return new SubmitScoreFragment();
        }

        Question question = Repository.getQuestions().get(position);
        int correctAnswerButtonId = getCorrectAnswerButtonId(question.getCorrectAnswerIndex());
        question.setCorrectAnswerButtonId(correctAnswerButtonId);

        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable(QuestionFragment.KEY_QUESTION_DATA, question);
        args.putBoolean(QuestionFragment.KEY_QUIZ_MODE, this.isQuizSubmitted);
        fragment.setArguments(args);
        this.fragmentsByPosition.put(position, fragment);

        return fragment;
    }

    /**
     * Removes inactive Fragments from the Map.
     *
     * @param container In this case - the ViewPager instance, at activity_quiz.xml
     * @param position The item position in the ViewPager
     * @param object The Fragment object to be destroyed
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        this.fragmentsByPosition.remove(object);
        super.destroyItem(container, position, object);
    }

    /**
     * Calculates the required length of the ViewPager
     *
     * @return ViewPager's length
     */
    @Override
    public int getCount() {
        int questionsCount = Repository.getQuestions().size(); // Number of questions
        int submitScore = 1; // Submit score middle view
        if (this.isQuizSubmitted) { // Don't show SubmitScoreFragment view, if quiz is submitted.
            return questionsCount;
        }

        return questionsCount + submitScore;
    }

    /**
     * Decides, which buttonId should be passed to the Question Entity as the correct answer button.
     *
     * @param correctAnswerIndex index of the button, can be 0, 1, 2, 3;
     * @return id of the current answer button, or 404
     */
    private int getCorrectAnswerButtonId(int correctAnswerIndex) {
        switch (correctAnswerIndex) {
            case 0: return R.id.quiz_answer_0_btn;
            case 1: return R.id.quiz_answer_1_btn;
            case 2: return R.id.quiz_answer_2_btn;
            case 3: return R.id.quiz_answer_3_btn;
            default:
                Log.d("SAMPLE_DATA_ERROR", "Wrong question data - Question.correctAnswerIndex");
                return Question.INVALID_ID;
        }
    }

    public QuestionFragment getFragmentAtPosition(int position) {
        return fragmentsByPosition.get(position);
    }
}
