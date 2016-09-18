package com.itservz.android.mayekplay;

/**
 * Created by raju.athokpam on 06-09-2016.
 */
public class Result {
    private int totalNoOfQuestions;
    private int noOfCorrectAnswers;
    private int accumulatedWrongAttempts;
    private int score;

    public Result(){ }

    public Result(int accumulatedWrongAttempts, int noOfCorrectAnswers, int score) {
        this.accumulatedWrongAttempts = accumulatedWrongAttempts;
        this.noOfCorrectAnswers = noOfCorrectAnswers;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

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

