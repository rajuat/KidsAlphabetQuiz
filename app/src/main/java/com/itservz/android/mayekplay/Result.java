package com.itservz.android.mayekplay;

/**
 * Created by raju.athokpam on 06-09-2016.
 */
public class Result {
    private int totalNoOfQuestions;
    private int noOfCorrectAnswers;
    private int accumulatedWrongAttempts;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public int getAccumulatedWrongAttempts() {
        return accumulatedWrongAttempts;
    }

    public void incrementAccumulatedWrongAttempts() {
        this.accumulatedWrongAttempts++;
    }

    public int getNoOfCorrectAnswers() {
        return noOfCorrectAnswers;
    }

    public void incrementNoOfCorrectAnswers() {
        this.noOfCorrectAnswers++;
    }

    public int getNoOfWrongAnswers() {
        return totalNoOfQuestions - noOfCorrectAnswers;
    }

    public int getTotalNoOfQuestions() {
        return totalNoOfQuestions;
    }

    public void setTotalNoOfQuestions(int totalNoOfQuestions) {
        this.totalNoOfQuestions = totalNoOfQuestions;
    }
}

