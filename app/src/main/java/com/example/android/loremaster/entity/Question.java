package com.example.android.loremaster.entity;

import java.io.Serializable;

/**
 * Question Model entity. Holds static information on:
 *  Question subject
 *  Question body,
 *  Possible answers (4),
 *  Correct answer index (0, 1, 2 or 3)
 *
 *  And dynamic on:
 *  Correct answer ButtonID - supplied by the controller when template inflation happens.
 *  User-selected ButtonID
 */
public class Question implements Serializable {

    public static final int INVALID_ID = 404;

    public final int ID;
    public final String QUESTION_SUBJECT;
    public final String QUESTION_BODY;
    public final String ANSWER_0;
    public final String ANSWER_1;
    public final String ANSWER_2;
    public final String ANSWER_3;
    private final int correctAnswerIndex;

    private int correctAnswerButtonId;
    private int selectedAnswerButtonId;

    /**
     * @param id Id of the question, min id is 0
     * @param correctAnswerIndex Index for the correct answer
     * @param questionSubject Subject
     * @param questionBody Body
     * @param answerFirst Answer 1
     * @param answerSecond Answer 2
     * @param answerThird Answer 3
     * @param answerFourth Answer 4
     */
    public Question(
            int id,
            int correctAnswerIndex,
            String questionSubject,
            String questionBody,
            String answerFirst,
            String answerSecond,
            String answerThird,
            String answerFourth) {

        this.ID = id;
        this.QUESTION_SUBJECT = questionSubject;
        this.QUESTION_BODY = questionBody;
        this.ANSWER_0 = answerFirst;
        this.ANSWER_1 = answerSecond;
        this.ANSWER_2 = answerThird;
        this.ANSWER_3 = answerFourth;

        this.correctAnswerIndex = correctAnswerIndex;
        this.selectedAnswerButtonId = INVALID_ID;
    }

    public int getSelectedAnswerButtonId() {
        return selectedAnswerButtonId;
    }

    public int getID() {
        return ID;
    }

    public void selectAnswer(int buttonId) {
        this.selectedAnswerButtonId = buttonId;
    }

    public int getCorrectAnswerIndex() {
        return this.correctAnswerIndex;
    }

    public void setCorrectAnswerButtonId(int buttonId) {
        this.correctAnswerButtonId = buttonId;
    }

    public int getCorrectAnswerButtonId() {
        return this.correctAnswerButtonId;
    }

    public boolean isAnsweredCorrectly() {
        return this.correctAnswerButtonId == this.selectedAnswerButtonId;
    }

    public void reset() {
        this.selectedAnswerButtonId = INVALID_ID;
        this.correctAnswerButtonId = INVALID_ID;
    }
}
