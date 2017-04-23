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
    private static final int QUESTION_1_CORRECT_ANSWER = 1;
    private static final String QUESTION_1_SUBJECT = "alliance";
    private static final String QUESTION_1_QUESTION_BODY = "Which of the following kingdoms has not pledged allegiance to the Alliance";
    private static final String QUESTION_1_ANSWER_0 = "Kingdom of Quel'Thalas";
    private static final String QUESTION_1_ANSWER_1 = "Darnassus";
    private static final String QUESTION_1_ANSWER_2 = "Kingdom of Gilneas";
    private static final String QUESTION_1_ANSWER_3 = "Gnomeregan";

    private static final int QUESTION_2_ID = 1;
    private static final int QUESTION_2_CORRECT_ANSWER = 2;
    private static final String QUESTION_2_SUBJECT = "arthas";
    private static final String QUESTION_2_QUESTION_BODY = "Who said “Give my regards to the endless dark” to Arthas?";
    private static final String QUESTION_2_ANSWER_01 = "Jaina Proudmoore";
    private static final String QUESTION_2_ANSWER_02 = "Valeera Sanguinar";
    private static final String QUESTION_2_ANSWER_03 = "Sylvanas Windrunner";
    private static final String QUESTION_2_ANSWER_04 = "Uther the Lightbringer";

    private static final int QUESTION_3_ID = 2;
    private static final int QUESTION_3_CORRECT_ANSWER = 2;
    private static final String QUESTION_3_SUBJECT = "demon_soul";
    private static final String QUESTION_3_QUESTION_BODY = "Who was the character depicted on the picture, before he became known as Deathwing, The Destroyer";
    private static final String QUESTION_3_ANSWER_01 = "Galakrond";
    private static final String QUESTION_3_ANSWER_02 = "Deathwing";
    private static final String QUESTION_3_ANSWER_03 = "Neferian";
    private static final String QUESTION_3_ANSWER_04 = "Neltharion the Earthwarden";

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