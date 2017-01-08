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


    QuizActivity QuestionList = new QuizActivity();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
    }

}
