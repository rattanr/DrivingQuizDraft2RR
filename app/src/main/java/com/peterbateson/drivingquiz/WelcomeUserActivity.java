package com.peterbateson.drivingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WelcomeUserActivity extends AppCompatActivity {

    private Button mStartButton;
    EditText enterHighscore1;
    EditText enterHighscore2;
    EditText enterHighscore3;

    DatabaseHelperLogIn databaseHelperLogIn;

    DatabaseHandler db = new DatabaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        databaseHelperLogIn = new DatabaseHelperLogIn(this);
        databaseHelperLogIn = databaseHelperLogIn.open();
        DatabaseHandler db = new DatabaseHandler(this);
        


        String username = getIntent().getStringExtra("Username");
        TextView welcomeUsername = (TextView)findViewById(R.id.welcomeUsername);
        welcomeUsername.setText(username);

        String highscore1 = getIntent().getStringExtra("HIGHSCORE1");
        TextView hs1 = (TextView)findViewById(R.id.highScore1);
        hs1.setText(highscore1);







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
