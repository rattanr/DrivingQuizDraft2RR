package com.peterbateson.drivingquiz;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

public class QuestionListActivity extends AppCompatActivity {

    public int currentScore = 0;
    private int Index = 0;
    private TextView currentQuestion;
    private boolean AnswerIsTrue;

    public String currentScoreString = String.valueOf(currentScore);

    private Button mquestionOne;
    private Button mquestionTwo;
    private Button mquestionThree;
    private Button mquestionFour;
    private Button mquestionFive;
    private Button mquestionSix;
    private Button mquestionSeven;
    private Button mquestionEight;
    private Button mquestionNine;
    private Button mquestionTen;
    private Button mquestionEleven;
    private Button mquestionTwelve;
    private Button mquestionThirteen;
    private Button mquestionFourteen;
    private Button mquestionFifteen;
    private Button mquestionSixteen;


    private QuestionAnswers[] QuestionBank = new QuestionAnswers[] {
            new QuestionAnswers(R.string.question_1, false),
            new QuestionAnswers(R.string.question_2, true),
            new QuestionAnswers(R.string.question_3, false),
            new QuestionAnswers(R.string.question_4, false),
            new QuestionAnswers(R.string.question_5, true),
            new QuestionAnswers(R.string.question_6, false),
            new QuestionAnswers(R.string.question_7, true),
            new QuestionAnswers(R.string.question_8, true),
            new QuestionAnswers(R.string.question_9, false),
            new QuestionAnswers(R.string.question_10, true),
            new QuestionAnswers(R.string.question_11, false),
            new QuestionAnswers(R.string.question_12, false),
            new QuestionAnswers(R.string.question_13, false),
            new QuestionAnswers(R.string.question_14, true),
            new QuestionAnswers(R.string.question_15, true),
            new QuestionAnswers(R.string.question_16, true),
    };

    public void updateQuestionNumber()
    {
        int question = QuestionBank[Index].getmQuestion();
        currentQuestion.setText(question);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);


        mquestionOne = (Button)findViewById(R.id.questionOne);
        mquestionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Start = new Intent(QuestionListActivity.this, QuizActivity.class);
                startActivity(Start);
            }
        });

        mquestionTwo = (Button)findViewById(R.id.questionTwo);
        mquestionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent Start = new Intent(QuestionListActivity.this, QuizActivity.class);
                startActivity(Start);
            }

        });

    }

}
