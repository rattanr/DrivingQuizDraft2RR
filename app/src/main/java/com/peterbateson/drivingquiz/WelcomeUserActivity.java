package com.peterbateson.drivingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class WelcomeUserActivity extends AppCompatActivity {

    private Button mStartButton;

    TextView highScore1;
    TextView highScore2;
    TextView highScore3;

    DatabaseHelperLogIn databaseHelperLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        databaseHelperLogIn = new DatabaseHelperLogIn(this);
        databaseHelperLogIn = databaseHelperLogIn.open();

        highScore1 = (TextView)findViewById(R.id.highScore1);
        highScore2 = (TextView)findViewById(R.id.highScore2);
        highScore3 = (TextView)findViewById(R.id.highScore3);

        String hs1 = highScore1.getText().toString();
        String hs2 = highScore2.getText().toString();
        String hs3 = highScore3.getText().toString();


        String username = getIntent().getStringExtra("Username");
        TextView welcomeUsername = (TextView)findViewById(R.id.welcomeUsername);
        welcomeUsername.setText(username);

        String highscore1 = getIntent().getStringExtra("hs1");
        TextView textView35 = (TextView)findViewById(R.id.highScore1);
        textView35.setText(highscore1);

        String highscore2 = getIntent().getStringExtra("hs2");
        TextView textView33 = (TextView)findViewById(R.id.highScore2);
        textView33.setText(highscore2);

        String highscore3 = getIntent().getStringExtra("hs3");
        TextView textView36 = (TextView)findViewById(R.id.highScore3);
        textView36.setText(highscore3);

        mStartButton =(Button)findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Start = new Intent(WelcomeUserActivity.this, QuizActivity.class);
                startActivity(Start);
            }
        });

    }

}
