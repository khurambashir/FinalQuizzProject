package com.example.android.finalquizzproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * This method determines if question one is correct and returns one score
     * if the correct RadioButton is checked
     */
    public int QuestionOne() {
        RadioButton threeFifty = (RadioButton) findViewById(R.id.ans1_3);
        boolean isChecked = threeFifty.isChecked();
        if (isChecked) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * This method checks to see that the correct CheckBox and returns one point
     * if so.
     */
    public int QuestionTwo() {
        CheckBox donaldTrump = (CheckBox) findViewById(R.id.Donald);
        boolean donaldTrumpIsChecked = donaldTrump.isChecked();

        CheckBox clinton = (CheckBox) findViewById(R.id.clinton);
        boolean clintonIsChecked = clinton.isChecked();


        if (donaldTrumpIsChecked &&  clintonIsChecked) {
            return 1;
        } else {
            return 0;
        }
    }


    /**
     * This method checks to see if the user has input "Donald Trump"
     * This method uses .toLowerCase() and .Trim() to ignore trailing spaces and cap letters
     * returns one point if the user enters the correct donald trump
     */
    public int QuestionThree() {
        EditText donaldTrump = (EditText) findViewById(R.id.donald_trump);
        String inputTrump = donaldTrump.getText().toString();
        inputTrump = inputTrump.toLowerCase();
        inputTrump = inputTrump.trim();

        if (inputTrump.equals("donald trump")) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * This method determines if question one is correct and returns one point
     * if the correct RadioButton is checked
     */
    public int QuestionFour() {
        RadioButton apple = (RadioButton) findViewById(R.id.ans4_4);
        boolean appleIsChecked = apple.isChecked();
        if (appleIsChecked) {
            return 1;
        } else {
            return 0;
        }
    }


    /**
     * This method calculate scores */
    public int CalculateScore(int point1, int point2, int point3, int point4) {
        return point1 + point2 + point3 + point4;
    }

    /**
     *
     * this is submit method which displace scorse
     */
    public void SubmitQuiz(View view) {

        int questionOnePoint = QuestionOne();
        int questionTwoPoint = QuestionTwo();
        int questionThreePoint = QuestionThree();
        int questionFourPoint = QuestionFour();
        int totalScore = CalculateScore(questionOnePoint, questionTwoPoint, questionThreePoint,
                questionFourPoint);


        // this method store name in the varible

        EditText inputText = (EditText) findViewById(R.id.name);
        String userName = inputText.getText().toString();

        TextView scoreTextView = (TextView) findViewById(R.id.results);
        scoreTextView.setText("Hi " + userName + " !"
                + "\n your total Scores are " + totalScore + "/4");

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = getString(R.string.toast_one) + ", You correctly answered  " + totalScore + " questions." +getString(R.string.toast_two);
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}