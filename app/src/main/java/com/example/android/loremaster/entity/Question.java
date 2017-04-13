package com.example.android.loremaster.entity;

import java.io.Serializable;

/**
 * Question entity. Holds information on:
 *  Image header,
 *  Question body,
 *  Answers
 */
public class Question implements Serializable {

    public final int ID;
    public final String QUESTION_SUBJECT;
    public final String QUESTION_BODY;
    public final String ANSWER_0;
    public final String ANSWER_1;
    public final String ANSWER_2;
    public final String ANSWER_3;

    private boolean answered;
    private int correctAnswerIndex;
    private int correctAnswerButtonId;
    private int selectedAnswerButtonId;

    /**
     *
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
        this.selectedAnswerButtonId = 404;
        this.answered = false;
    }

    public int getID() {
        return ID;
    }

    public void selectAnswer(int answerIndex) {
        this.selectedAnswerButtonId = answerIndex;
        this.answered = true;
    }

    public void unSelectAnswer() {
        this.selectedAnswerButtonId = 404;
        this.answered = false;
    }

    public int getCorrectAnswerIndex() {
        return this.correctAnswerIndex;
    }

    public void setCorrectAnswerButtonId(int index) {
        this.correctAnswerButtonId = index;
    }

    public int correctAnswerButtonId(int index) {
        return this.correctAnswerButtonId;
    }

    public boolean isAnswered() {
        return answered;
    }

    public String getQUESTION_BODY() {
        return QUESTION_BODY;
    }

    public String getANSWER_0() {
        return ANSWER_0;
    }

    public String getANSWER_1() {
        return ANSWER_1;
    }

    public String getANSWER_2() {
        return ANSWER_2;
    }

    public String getANSWER_3() {
        return ANSWER_3;
    }
}
