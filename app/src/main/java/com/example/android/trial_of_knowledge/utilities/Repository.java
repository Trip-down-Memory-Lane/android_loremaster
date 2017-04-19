package com.example.android.trial_of_knowledge.utilities;

import com.example.android.trial_of_knowledge.entity.Question;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Serves as a temporary database to test app.
 */
public class Repository implements Serializable {

    private static final int QUESTION_1_ID = 0;
    private static final int QUESTION_1_CORRECT_ANSWER = 0;
    private static final String QUESTION_1_SUBJECT = "alliance";
    private static final String QUESTION_1_QUESTION_BODY = "First question";
    private static final String QUESTION_1_ANSWER_0 = "answer 1";
    private static final String QUESTION_1_ANSWER_1 = "answer 2";
    private static final String QUESTION_1_ANSWER_2 = "answer 3";
    private static final String QUESTION_1_ANSWER_3 = "answer 4";

    private static final int QUESTION_2_ID = 1;
    private static final int QUESTION_2_CORRECT_ANSWER = 0;
    private static final String QUESTION_2_SUBJECT = "horde";
    private static final String QUESTION_2_QUESTION_BODY = "Second Question";
    private static final String QUESTION_2_ANSWER_01 = "penka 1";
    private static final String QUESTION_2_ANSWER_02 = "penka 2";
    private static final String QUESTION_2_ANSWER_03 = "penka 3";
    private static final String QUESTION_2_ANSWER_04 = "penka 4";

    private static final int QUESTION_3_ID = 2;
    private static final int QUESTION_3_CORRECT_ANSWER = 0;
    private static final String QUESTION_3_SUBJECT = "horde";
    private static final String QUESTION_3_QUESTION_BODY = "Third Question?";
    private static final String QUESTION_3_ANSWER_01 = "answer 1";
    private static final String QUESTION_3_ANSWER_02 = "ogi 2";
    private static final String QUESTION_3_ANSWER_03 = "naswer 3";
    private static final String QUESTION_3_ANSWER_04 = "coco 4";

    private static List<Question> questions =
            Arrays.asList(
                    new Question(
                            Repository.QUESTION_1_ID,
                            Repository.QUESTION_1_CORRECT_ANSWER,
                            Repository.QUESTION_1_SUBJECT,
                            Repository.QUESTION_1_QUESTION_BODY,
                            Repository.QUESTION_1_ANSWER_0,
                            Repository.QUESTION_1_ANSWER_1,
                            Repository.QUESTION_1_ANSWER_2,
                            Repository.QUESTION_1_ANSWER_3
                    ),
                    new Question(
                            Repository.QUESTION_2_ID,
                            Repository.QUESTION_2_CORRECT_ANSWER,
                            Repository.QUESTION_2_SUBJECT,
                            Repository.QUESTION_2_QUESTION_BODY,
                            Repository.QUESTION_2_ANSWER_01,
                            Repository.QUESTION_2_ANSWER_02,
                            Repository.QUESTION_2_ANSWER_03,
                            Repository.QUESTION_2_ANSWER_04
                    ),
                    new Question(
                            Repository.QUESTION_3_ID,
                            Repository.QUESTION_3_CORRECT_ANSWER,
                            Repository.QUESTION_3_SUBJECT,
                            Repository.QUESTION_3_QUESTION_BODY,
                            Repository.QUESTION_3_ANSWER_01,
                            Repository.QUESTION_3_ANSWER_02,
                            Repository.QUESTION_3_ANSWER_03,
                            Repository.QUESTION_3_ANSWER_04
                    ));

    private static Question errorView =
            new Question(
                    404,
                    0,
                    "error",
                    "Error",
                    "Error",
                    "Error",
                    "Error",
                    "Error");

    public static List<Question> getQuestions() {
        return questions;
    }

    public static Question findById(int id) {
        if (Repository.questions.size() > 0) {
            for (Question question : Repository.questions) {
                if (question.getID() == id) {
                    return question;
                }
            }
        }

        return errorView;
    }
}