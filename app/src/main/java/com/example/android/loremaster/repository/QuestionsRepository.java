package com.example.android.loremaster.repository;

import com.example.android.loremaster.entity.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Serves as a temporary database to test app.
 */
public class QuestionsRepository implements Serializable {

    private List<Question> questions;
    private Question errorView = new Question(404, "error", "Error", "Error", "Error", "Error", "Error");

    public QuestionsRepository() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question findById(int id) {
        if (this.questions.size() > 0) {
            for (Question question : this.questions) {
                if (question.getID() == id) {
                    return question;
                }
            }
        }

        return errorView;
    }
}