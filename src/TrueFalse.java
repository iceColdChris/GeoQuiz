package com.android.chris.geoquiz;

/**
 * Holds the answer for each question.
 * @author Chris
 * @version 1.0
 */
public class TrueFalse {

    /*The current question*/
    private int mQuestion;

    /*The answer for the current question*/
    private boolean mTrueQuestion;

    /**
     * Creates a question object with an
     * answer.
     * @param question the number of the current question.
     * @param trueQuestion the answer to the current question.
     */
    public TrueFalse(int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    /**
     * Gets the answer to the question
     * @return the answer to the question.
     */
    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    /**
     * Sets the answer to the current question
     * @param mTrueQuestion boolean representing the answer.
     */
    public void setTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }

    /**
     * Gets the number of the current question.
     * @return the number of the current question.
     */
    public int getQuestion() {
        return mQuestion;
    }

    /**
     * Sets the current question
     * @param mQuestion the number of the current question.
     */
    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

}
