package com.example.mob.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double count = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void totalScore() {
        /**
         * Quesetion 1 - Correct answer is: Ulysses S. Grant
         */

        RadioButton questOneSecondChoice = (RadioButton) findViewById(R.id.firstQuestionChoiceA);
        boolean firstAnswer = questOneSecondChoice.isChecked();
        if (firstAnswer) {
            count++;
        }

        /**
         * Question 2 - Correct answer is: Theodore Roosevelt
         */

        RadioButton questTwoSecondChoice = (RadioButton) findViewById(R.id.secondQuestionChoiceB);
        boolean secondAnswer = questTwoSecondChoice.isChecked();
        if (secondAnswer) {
            count++;
        }

        /**
         * Question 3 - Correct answer is: Franklin D. Roosevelt
         */

        RadioButton questThreeFirstChoice = (RadioButton) findViewById(R.id.thirdQuestionChoiceC);
        boolean thirdAnswer = questThreeFirstChoice.isChecked();
        if (thirdAnswer) {
            count++;
        }

        /**
         * Question 4 - Correct answer is: George Washington
         */

        RadioButton questFourSecondChoice = (RadioButton) findViewById(R.id.fourthQuestionChoiceA);
        boolean fourthAnswer = questFourSecondChoice.isChecked();
        if (fourthAnswer) {
            count++;
        }

    }

    private String message (double percentage) {
        EditText name = (EditText) findViewById(R.id.nameID);

        return "Name: " + name.getText().toString() + "       Total: " + (int) count + "/4      " + percentage + "%";
    }

    public void submitQuiz(View view) {
        totalScore();

        double total = 4.0;
        double percentage = (count / total) * 100;

        CheckBox yesBox = (CheckBox) findViewById(R.id.yesID);
        CheckBox noBox = (CheckBox) findViewById(R.id.noID);

        boolean isYes = yesBox.isChecked();
        boolean isNo = noBox.isChecked();

        TextView deSummary = (TextView) findViewById(R.id.summary);

        if (isYes && isNo) {
            Toast.makeText(this, "Please choose either Yes or No.", Toast.LENGTH_SHORT).show();
        }
        else if (isYes) {
            if (count == 4) {
                deSummary.setText(message(percentage) + "\nWowwzza");
            } else if (count == 3) {
                deSummary.setText(message(percentage) + "\nGood job!");
            } else if (count == 2) {
                deSummary.setText(message(percentage) + "\nOh no!");
            } else if(count == 1) {
                deSummary.setText(message(percentage) + "\nT.T");
            }
            else {
                deSummary.setText(message(percentage) + "\ngg RIP");
            }
        }
        else {
            Toast.makeText(this, "You got this!!!", Toast.LENGTH_SHORT).show();
        }
        count = 0;
    }

}
