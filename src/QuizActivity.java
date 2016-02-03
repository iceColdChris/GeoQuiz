package com.android.chris.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The main driver for the Quiz Game.
 * @author Chris
 * @version 1.0
 */
public class QuizActivity extends Activity {

    /*The buttons for the answers*/
    private Button mTrueButton;
    private Button mFalseButton;

    /*The buttons to navigate between questions*/
    private ImageButton mNextButton;
    private ImageButton mPrevButton;

    /*The TextView for the current question*/
    private TextView mQuestionTextView;

    /*Loading all the questions into the TextView*/
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
      new TrueFalse(R.string.question_oceans, true),
      new TrueFalse(R.string.question_mideast, false),
      new TrueFalse(R.string.question_africa, false),
      new TrueFalse(R.string.question_americas, true),
      new TrueFalse(R.string.question_asia, true)
    };

    /*The index of the current question*/
    private int mCurrentIndex = 0;

    /**
     * Sets up the current instance
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        /*Sets up the current text view*/
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);


        /*Sets up the True button and adds a listener*/
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        /*Sets up the False button and adds a listener*/
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        /*Sets up the Next button and adds a listener*/
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        /*Allows the user to click on the TextView to switch questions*/
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        /*Sets up the Previous button and adds a listener*/
        mPrevButton = (ImageButton) findViewById(R.id.previous_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1);
                if(mCurrentIndex < 0) mCurrentIndex = mCurrentIndex * (-1);
                updateQuestion();
            }
        });
        updateQuestion();
    }


    /**
     * Some menu setup.
     * This was auto generated
     * @param menu some menu item?
     * @return True if successful, false otherwise
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    /*
     * Updates the TextView to display the current question
     */
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    /*
     * Checks the answer of the current question
     * and compares it to the user input, then displays
     * whether the user got it correct or not.
     */
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();

        int messageResId = 0;

        if(userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}
