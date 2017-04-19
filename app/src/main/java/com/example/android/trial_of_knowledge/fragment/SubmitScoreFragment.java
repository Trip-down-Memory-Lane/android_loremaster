package com.example.android.trial_of_knowledge.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.trial_of_knowledge.R;

/**
 * Used as a transition View to submit the score and redirect to ScoreActivity
 */
public class SubmitScoreFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup activityRoot,
            Bundle questionData) {

        View inflatedActivityRoot = inflater.inflate(
                R.layout.layout_submit_score,
                activityRoot,
                false);

        return inflatedActivityRoot;
    }
}
