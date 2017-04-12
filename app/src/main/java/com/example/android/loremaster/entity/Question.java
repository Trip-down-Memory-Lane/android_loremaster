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
    public final String ANSWER_01;
    public final String ANSWER_02;
    public final String ANSWER_03;
    public final String ANSWER_04;

    private boolean answered;
    private int correctAnswerIndex;
    private int selectedAnswerIndex;

    /**
     *
     * @param id Id of the question, min id is 0
     * @param correctAnswer Index for the correct answer
     * @param questionSubject Subject
     * @param questionBody Body
     * @param answerFirst Answer 1
     * @param answerSecond Answer 2
     * @param answerThird Answer 3
     * @param answerFourth Answer 4
     */
    public Question(
            int id,
            int correctAnswer,
            String questionSubject,
            String questionBody,
            String answerFirst,
            String answerSecond,
            String answerThird,
            String answerFourth) {

        this.ID = id;
        this.QUESTION_SUBJECT = questionSubject;
        this.QUESTION_BODY = questionBody;
        this.ANSWER_01 = answerFirst;
        this.ANSWER_02 = answerSecond;
        this.ANSWER_03 = answerThird;
        this.ANSWER_04 = answerFourth;

        this.correctAnswerIndex = correctAnswer;
        this.selectedAnswerIndex = 404;
        this.answered = false;
    }

    public int getID() {
        return ID;
    }

    public void selectAnswer(int answerIndex) {
        this.selectedAnswerIndex = answerIndex;
    }

    public boolean isAnswered() {
        return answered;
    }

    public String getQUESTION_BODY() {
        return QUESTION_BODY;
    }

    public String getANSWER_01() {
        return ANSWER_01;
    }

    public String getANSWER_02() {
        return ANSWER_02;
    }

    public String getANSWER_03() {
        return ANSWER_03;
    }

    public String getANSWER_04() {
        return ANSWER_04;
    }
}
