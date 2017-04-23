package com.example.android.trial_of_knowledge.fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.trial_of_knowledge.QuizActivity;
import com.example.android.trial_of_knowledge.R;
import com.example.android.trial_of_knowledge.entity.Question;

/**
 * Question Fragment. Every question view is instance of this class. Controller by ViewPager
 *
 * Inflates <layout_question_template.xml>
 */
public class QuestionFragment extends Fragment {

    public static final String KEY_QUESTION_DATA = "QUESTION_DATA";
    public static final String KEY_QUIZ_MODE = "KEY_QUIZ_MODE";

    private View rootView;
    private Question question;

    private ImageView header_Iv;
    private TextView questionBody_Tv;
    private Button answer_0_Btn;
    private Button answer_1_Btn;
    private Button answer_2_Btn;
    private Button answer_3_Btn;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle questionData) {

        this.rootView = inflater.inflate(
                R.layout.layout_question_template,
                container,
                false);

        Bundle args = getArguments();
        this.question = (Question) args.getSerializable(QuestionFragment.KEY_QUESTION_DATA);
        boolean isQuizSubmitted = args.getBoolean(KEY_QUIZ_MODE, QuizActivity.QUIZ_NOT_SUBMITTED);
        this.initViews();
        this.populateInflatable(isQuizSubmitted);

        rootView.findViewById(R.id.layout_question_template_root).setTag(this.question.getID());
        return rootView;
    }

    /**
     * Populates the inflated template with question data. Colors the background
     * of selected Button, if any.
     */
    private void populateInflatable(boolean isQuizSubmitted) {
        this.header_Iv.setImageResource(selectImage(question.QUESTION_SUBJECT));
        this.questionBody_Tv.setText(question.QUESTION_BODY);
        this.answer_0_Btn.setText(question.ANSWER_0);
        this.answer_1_Btn.setText(question.ANSWER_1);
        this.answer_2_Btn.setText(question.ANSWER_2);
        this.answer_3_Btn.setText(question.ANSWER_3);

        showAnswers(isQuizSubmitted);
    }

    /**
     * Keeps the UI Views as private fields. This is required, because we need to change
     * the buttons according to user interaction.
     */
    private void initViews() {
        this.header_Iv = (ImageView) this.rootView.findViewById(R.id.quiz_header_imgv);
        this.questionBody_Tv = (TextView) this.rootView.findViewById(R.id.quiz_question_tv);
        this.answer_0_Btn = (Button) this.rootView.findViewById(R.id.quiz_answer_0_btn);
        this.answer_1_Btn = (Button) this.rootView.findViewById(R.id.quiz_answer_1_btn);
        this.answer_2_Btn = (Button) this.rootView.findViewById(R.id.quiz_answer_2_btn);
        this.answer_3_Btn = (Button) this.rootView.findViewById(R.id.quiz_answer_3_btn);
    }

    /**
     * Calls changeButtonColor for the corresponding buttons:
     * -- If user has selected answer - mark it in BLUE
     * -- If user has submitted the quiz - mark the correct answer as GREEN.
     * ---- If user has selected wrong answer - mark it as RED.
     */
    private void showAnswers(boolean isQuizSubmitted) {
        int selectedAnswerButtonId = this.question.getSelectedAnswerButtonId();
        boolean isAnswerSelected = selectedAnswerButtonId != Question.INVALID_ID;

        if (isQuizSubmitted) {
            int correctAnswerButtonId = this.question.getCorrectAnswerButtonId();
            if (isAnswerSelected) {
                changeButtonColor(selectedAnswerButtonId, Color.RED);
            }
            changeButtonColor(correctAnswerButtonId, Color.GREEN);
        } else {
            if (isAnswerSelected) {
                changeButtonColor(selectedAnswerButtonId, Color.BLUE);
            }
        }
    }

    /**
     * Changes button background color
     *
     * @param buttonId Id of button
     * @param colorId Id of color ( example: Color.RED )
     */
    private void changeButtonColor(int buttonId, int colorId) {
        this.rootView.findViewById(buttonId)
                .getBackground()
                .setColorFilter(
                        new PorterDuffColorFilter(colorId, PorterDuff.Mode.MULTIPLY));
    }

    private int selectImage(String questionSubject) {
        switch (questionSubject) {
            case "alliance": return R.drawable.question_01_header_img;
            case "arthas": return R.drawable.question_02_header_img;
            case "demon_soul": return R.drawable.question_03_header_img;
            default: return R.drawable.main_background_nongannon_img;
        }
    }

    /**
     * @return Question entity's ID
     */
    public int getQuestionId() {
        return this.question.getID();
    }

    // Getters
    public Button getAnswer_0_Btn() {
        return answer_0_Btn;
    }

    public Button getAnswer_1_Btn() {
        return answer_1_Btn;
    }

    public Button getAnswer_2_Btn() {
        return answer_2_Btn;
    }

    public Button getAnswer_3_Btn() {
        return answer_3_Btn;
    }
}

