package com.itservz.android.mayekplay;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.match.MatchActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by raju.athokpam on 05-09-2016.
 */
public class ViewBuilder {
    private View view2;
    private View view3;
    private View view4;
    private View view5;
    private View view6;
    private View view7;
    private View view8;
    private View view9;

    private List<MayekCard> cardList = Mayeks.getInstance().getCardList();
    private List<Integer> keys = Mayeks.getInstance().getKeys();
    private Map<Integer, MayekCard> cardMap = Mayeks.getInstance().getCardMap();
    private List<View> views = null;
    private List<Integer> askedQuestions = null;

    public ViewBuilder(){
        views = new ArrayList<>();
        askedQuestions = new ArrayList<>();
    }

    public void setViewsToFlipper(QuizPrepBaseActivity prepActivity, ViewFlipper viewFlipper) {
        view2 = LayoutInflater.from(prepActivity).inflate(R.layout.prep2, null);
        viewFlipper.addView(view2, 0);
        views.add(0, view2);
        view3 = LayoutInflater.from(prepActivity).inflate(R.layout.prep3, null);
        viewFlipper.addView(view3, 1);
        views.add(1, view3);
        view4 = LayoutInflater.from(prepActivity).inflate(R.layout.prep4, null);
        viewFlipper.addView(view4, 2);
        views.add(2, view4);
        view5 = LayoutInflater.from(prepActivity).inflate(R.layout.prep5, null);
        viewFlipper.addView(view5, 3);
        views.add(3, view5);
        view6 = LayoutInflater.from(prepActivity).inflate(R.layout.prep6, null);
        viewFlipper.addView(view6, 4);
        views.add(4, view6);
        view7 = LayoutInflater.from(prepActivity).inflate(R.layout.prep7, null);
        viewFlipper.addView(view7, 5);
        views.add(5, view7);
        view8 = LayoutInflater.from(prepActivity).inflate(R.layout.prep8, null);
        viewFlipper.addView(view8, 6);
        views.add(6, view8);
        view9 = LayoutInflater.from(prepActivity).inflate(R.layout.prep9, null);
        viewFlipper.addView(view9, 7);
        views.add(7, view9);
    }

    public void build(int viewIndex, int questionAsSound) {
        // get a sound to be played
        if (viewIndex == 0) {
            List<ImageView> views2 = QuestionViews.getViews2(view2);
            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(1);
            setImages(questionAsSound, views2, correctAnswerIndex);
        } else if (viewIndex == 1) {
            List<ImageView> views3 = QuestionViews.getViews3(view3);
            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(2);
            setImages(questionAsSound, views3, correctAnswerIndex);
        } else if (viewIndex == 2) {
            List<ImageView> views4 = QuestionViews.getViews4(view4);
            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(3);
            setImages(questionAsSound, views4, correctAnswerIndex);
        } else if (viewIndex == 3) {
            List<ImageView> views5 = QuestionViews.getViews5(view5);
            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(4);
            setImages(questionAsSound, views5, correctAnswerIndex);
        } else if (viewIndex == 4) {
            List<ImageView> views6 = QuestionViews.getViews6(view6);
            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(5);
            setImages(questionAsSound, views6, correctAnswerIndex);
        } else if (viewIndex == 5) {
            List<ImageView> views7 = QuestionViews.getViews7(view7);
            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(6);
            setImages(questionAsSound, views7, correctAnswerIndex);
        } else if (viewIndex == 6) {
            List<ImageView> views8 = QuestionViews.getViews8(view8);
            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(7);
            setImages(questionAsSound, views8, correctAnswerIndex);
        } else if (viewIndex == 7) {
            List<ImageView> views9 = QuestionViews.getViews9(view9);
            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(8);
            setImages(questionAsSound, views9, correctAnswerIndex);
        }
    }

    public void buildMatch(View view, int noOfCards) {
        List<ImageView> views = null;
        if (noOfCards == 4) {
            views = QuestionViews.getViews4(view);
        } else if(noOfCards == 8){
            views = QuestionViews.getViews8(view);
        }
        List<ImageView> addedViews = new ArrayList<>();
        //for each play the mayeks can be repeated
        askedQuestions = new ArrayList<>();
        for (int i = 0; i < noOfCards / 2; i++) {
            Integer question = getQuestionAsSound();
            int res = cardMap.get(question).getRes();

            ImageView match1 = randomViewFromRest(views, addedViews);
            match1.setBackgroundResource(res);
            match1.setTag(res);
            match1.setImageResource(R.drawable.opacity);
            addedViews.add(match1);

            ImageView match2 = randomViewFromRest(views, addedViews);
            match2.setBackgroundResource(res);
            match2.setTag(res);
            match2.setImageResource(R.drawable.opacity);
            addedViews.add(match2);
        }
    }

    private ImageView randomViewFromRest(List<ImageView> views, List<ImageView> addedViews) {
        Random randomizer = new Random();
        List<ImageView> temp = new ArrayList<>(views);
        temp.removeAll(addedViews);
        ImageView imageView = temp.get(randomizer.nextInt(temp.size()));
        int indexOf = views.indexOf(imageView);
        return views.get(indexOf);
    }

    private void setImages(Integer questionAsSound, List<ImageView> views, int correctAnswerIndex) {
        List<MayekCard> addedViews = new ArrayList<>();
        //correct answer
        MayekCard card = cardMap.get(questionAsSound);
        addedViews.add(card);
        for (int i = 0; i < views.size(); i++) {
            ImageView view = views.get(i);
            //the tags set below are cached
            view.setTag(null);
            if (i == correctAnswerIndex) {
                Log.d("setImages", card.toString());
                view.setImageResource(card.getRes());
                view.setTag(QuizPrepBaseActivity.CORRECT_ANSWER);
            } else {
                //random image buttons
                MayekCard uniqueRandomCard = randomImageFromRest(addedViews);
                view.setImageResource(uniqueRandomCard.getRes());
                addedViews.add(uniqueRandomCard);
            }
        }
    }

    public void resetBackgroundColor(int viewIndex) {
        List<ImageView> imageViews = null;
        if (viewIndex == 0) {
            imageViews = QuestionViews.getViews2(view2);
        } else if (viewIndex == 1) {
            imageViews = QuestionViews.getViews3(view3);
        } else if (viewIndex == 2) {
            imageViews = QuestionViews.getViews4(view4);
        } else if (viewIndex == 3) {
            imageViews = QuestionViews.getViews5(view5);
        } else if (viewIndex == 4) {
            imageViews = QuestionViews.getViews6(view6);
        } else if (viewIndex == 5) {
            imageViews = QuestionViews.getViews7(view7);
        } else if (viewIndex == 6) {
            imageViews = QuestionViews.getViews8(view8);
        } else if (viewIndex == 7) {
            imageViews = QuestionViews.getViews9(view9);
        }

        for (ImageView imageView : imageViews) {
            imageView.setBackgroundColor(Color.WHITE);
        }
    }


    @Deprecated
    private ImageView randomViewFromList(List<ImageView> views) {
        Random randomizer = new Random();
        return views.get(randomizer.nextInt(views.size()));
    }

    private MayekCard randomImageFromRest(List<MayekCard> addedCards) {
        Random randomizer = new Random();
        List<MayekCard> temp = new ArrayList<>(cardList);
        Log.d("randomImageFromRest", "" + temp.size());
        temp.removeAll(addedCards);
        Log.d("randomImageFromRest", "" + temp.size());
        return temp.get(randomizer.nextInt(temp.size()));
    }

    public Integer getQuestionAsSound() {
        Random randomizer = new Random();
        List<Integer> temp = new ArrayList<>(keys);
        temp.removeAll(askedQuestions);
        Integer question = temp.get(randomizer.nextInt(temp.size()));
        askedQuestions.add(question);
        return question;
    }

    /*private void randomCorrectAnswer(List<ImageView> views) {
        Random randomizer = new Random();
        ImageView random = views.get(randomizer.nextInt(views.size()));
    }*/

    public View getView(int index) {
        return views.get(index);
    }

    public int getTotalNoOfViews() {
        return views.size();
    }


}
