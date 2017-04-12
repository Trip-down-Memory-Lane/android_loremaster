package com.example.android.loremaster.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.loremaster.R;

public class SubmitScoreFragment extends Fragment {

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
