package com.itservz.android.mayekplay;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.prep.PrepActivity;

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
    private List<View> views = new ArrayList<>();
    private List<MayekCard> cardList = Mayeks.getInstance().getCardList();
    private List<Integer> keys = Mayeks.getInstance().getKeys();
    private Map<Integer, MayekCard> cardMap = Mayeks.getInstance().getCardMap();
    private Integer sound;

    public void setViewsToFlipper(PrepActivity prepActivity, ViewFlipper viewFlipper){
        view2 = LayoutInflater.from(prepActivity).inflate(R.layout.prep2, null);
        viewFlipper.addView(view2, 0);
        views.add(0, view2);
        view3 = LayoutInflater.from(prepActivity).inflate(R.layout.prep3, null);
        viewFlipper.addView(view3, 1);
        views.add(1, view3);
        view4 = LayoutInflater.from(prepActivity).inflate(R.layout.prep4, null);
        viewFlipper.addView(view4, 2);
        views.add(2, view4);
    }



    public void build(int viewIndex){
        // get a sound to be played
        sound = randomSound();

        if(viewIndex == 0) {
            View view21 = view2.findViewById(R.id.prep21);
            View view22 = view2.findViewById(R.id.prep22);

            List<View> views = new ArrayList<>();
            views.add(0, view21);
            views.add(1, view22);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(1);
            setImages(sound, views, correctAnswerIndex);
        } else if(viewIndex == 1){
            View view31 = view2.findViewById(R.id.prep31);
            View view32 = view2.findViewById(R.id.prep32);
            View view33 = view2.findViewById(R.id.prep33);

            List<View> views = new ArrayList<>();
            views.add(0, view31);
            views.add(1, view32);
            views.add(2, view33);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(2);
            setImages(sound, views, correctAnswerIndex);
        } else if(viewIndex == 2){
            View view41 = view2.findViewById(R.id.prep41);
            View view42 = view2.findViewById(R.id.prep42);
            View view43 = view2.findViewById(R.id.prep43);
            View view44 = view2.findViewById(R.id.prep44);

            List<View> views = new ArrayList<>();
            views.add(0, view41);
            views.add(1, view42);
            views.add(2, view43);
            views.add(3, view44);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(3);
            setImages(sound, views, correctAnswerIndex);
        }
    }

    private void setImages(Integer sound, List<View> views, int correctAnswerIndex) {
        for(int i = 0; i < views.size(); i++){
            View view = views.get(i);
            //correct answer
            if(i == correctAnswerIndex){
                MayekCard card = cardMap.get(sound);
                view.setBackgroundResource(card.getRes());
                view.setTag(PrepActivity.CORRECT_ANSWER);
            } else {
                //random image buttons
                view.setBackgroundResource(randomImage());
            }
        }
    }

    private Integer randomImage(){
        Random randomizer = new Random();
        MayekCard random = cardList.get(randomizer.nextInt(cardList.size()));
        return random.getRes();
    }

    private Integer randomSound(){
        Random randomizer = new Random();
        return keys.get(randomizer.nextInt(cardList.size()));
    }

    private void randomCorrectAnswer(List<View> views){
        Random randomizer = new Random();
        View random = views.get(randomizer.nextInt(views.size()));
    }

    public View getView(int index) {
        return views.get(index);
    }

    public Integer getSound(){
        return sound;
    }
}
