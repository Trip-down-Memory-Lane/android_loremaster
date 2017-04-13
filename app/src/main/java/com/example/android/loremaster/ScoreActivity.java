package com.example.android.loremaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.loremaster.controllers.ScoreController;
import com.example.android.loremaster.utilities.Repository;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ScoreController scoreController = new ScoreController(this);

    }
}
