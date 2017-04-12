package com.example.android.loremaster.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.loremaster.R;
import com.example.android.loremaster.entity.Question;

/**
 * The only app Fragment. Controlled by ViewPager
 *
 * Inflates <layout_question_template.xml>
 */
public class QuestionFragment extends Fragment {

    private ImageView header;
    private TextView questionBody;
    private Button answerFirst;
    private Button answerSecond;
    private Button answerThird;
    private Button answerFourth;

    public static final String ARG_ID = "question_id";
    public static final String QUESTION = "question";

    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle questionData) {

        View rootView = inflater.inflate(
                R.layout.layout_question_template,
                container,
                false);

        initChildViews(rootView);

        Bundle args = getArguments();
        Question questionEntity = (Question) args.getSerializable(
                QuestionFragment.QUESTION);
        populateInflatableLayout(questionEntity);

        return rootView;
    }

    private void populateInflatableLayout(Question question) {
        this.header.setImageResource(selectImage(question.QUESTION_SUBJECT));
        this.questionBody.setText(question.QUESTION_BODY);
        this.answerFirst.setText(question.ANSWER_01);
        this.answerSecond.setText(question.ANSWER_02);
        this.answerThird.setText(question.ANSWER_03);
        this.answerFourth.setText(question.ANSWER_04);
    }

    private void initChildViews(View rootView) {
        this.header = (ImageView) rootView.findViewById(R.id.quiz_header_imgv);
        this.questionBody = (TextView) rootView.findViewById(R.id.quiz_question_tv);
        this.answerFirst = (Button) rootView.findViewById(R.id.quiz_answer_1_btn);
        this.answerSecond = (Button) rootView.findViewById(R.id.quiz_answer_2_btn);
        this.answerThird = (Button) rootView.findViewById(R.id.quiz_answer_3_btn);
        this.answerFourth = (Button) rootView.findViewById(R.id.quiz_answer_4_btn);
    }

    private int selectImage(String questionSubject) {
        switch (questionSubject) {
            case "horde": return R.drawable.horde_30_img;
            case "alliance": return R.drawable.alliance2_30jpg_img;
            default: return R.drawable.alliance_img;
        }
    }
}

