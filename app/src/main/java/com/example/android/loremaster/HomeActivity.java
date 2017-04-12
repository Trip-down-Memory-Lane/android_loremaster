package com.example.android.loremaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.loremaster.constants.Questions;
import com.example.android.loremaster.entity.Question;
import com.example.android.loremaster.repository.QuestionsRepository;

public class HomeActivity extends AppCompatActivity {

    private QuestionsRepository repository;

//    public static final String INTENT_KEY_CONSTANTS = "EXTRA_CONSTANTS";
    public static final String INTENT_KEY_REPOSITORY = "EXTRA_QUESTIONS_DATA";
    public static final String INTENT_KEY_START_INDEX = "EXTRA_START_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Questions questionsData = new Questions(this);
        initRepository(questionsData);

    }

    public void startQuiz(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
//        intent.putExtra(INTENT_KEY_START_INDEX, this.questionsData);
//        intent.putExtra(INTENT_KEY_CONSTANTS, this.questionsData);
        intent.putExtra(INTENT_KEY_REPOSITORY, this.repository);
        startActivity(intent);
    }

    /**
     * Puts sample data in <QuestionRepository.java>
     */
    private void initRepository(Questions questionsData) {
        this.repository = new QuestionsRepository();
        this.repository.addQuestion(
                new Question(
                        questionsData.QUESTION_1_ID,
                        1,
                        questionsData.QUESTION_1_SUBJECT,
                        questionsData.QUESTION_1_QUESTION_BODY,
                        questionsData.QUESTION_1_ANSWER_01,
                        questionsData.QUESTION_1_ANSWER_02,
                        questionsData.QUESTION_1_ANSWER_03,
                        questionsData.QUESTION_1_ANSWER_04
                )
        );
        this.repository.addQuestion(
                new Question(
                        questionsData.QUESTION_2_ID,
                        1,
                        questionsData.QUESTION_2_SUBJECT,
                        questionsData.QUESTION_2_QUESTION_BODY,
                        questionsData.QUESTION_2_ANSWER_01,
                        questionsData.QUESTION_2_ANSWER_02,
                        questionsData.QUESTION_2_ANSWER_03,
                        questionsData.QUESTION_2_ANSWER_04
                )
        );
        this.repository.addQuestion(
                new Question(
                        questionsData.QUESTION_3_ID,
                        1,
                        questionsData.QUESTION_3_SUBJECT,
                        questionsData.QUESTION_3_QUESTION_BODY,
                        questionsData.QUESTION_3_ANSWER_01,
                        questionsData.QUESTION_3_ANSWER_02,
                        questionsData.QUESTION_3_ANSWER_03,
                        questionsData.QUESTION_3_ANSWER_04
                )
        );
    }
}

