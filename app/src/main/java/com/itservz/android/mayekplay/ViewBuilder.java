package com.itservz.android.mayekplay;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
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
    private List<ImageView> views0;
    private List<ImageView> views1;
    private List<ImageView> views2;
    private List<View> views = new ArrayList<>();
    private List<MayekCard> cardList = Mayeks.getInstance().getCardList();
    private List<Integer> keys = Mayeks.getInstance().getKeys();
    private Map<Integer, MayekCard> cardMap = Mayeks.getInstance().getCardMap();


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


    public void build(int viewIndex, int questionAsSound){
        // get a sound to be played
        if(viewIndex == 0) {
            ImageView view21 = (ImageView) view2.findViewById(R.id.prep21);
            ImageView view22 = (ImageView) view2.findViewById(R.id.prep22);

            views0 = new ArrayList<>();
            views0.add(0, view21);
            views0.add(1, view22);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(1);
            setImages(questionAsSound, views0, correctAnswerIndex);
        } else if(viewIndex == 1){
            ImageView view31 = (ImageView) view3.findViewById(R.id.prep31);
            ImageView view32 = (ImageView) view3.findViewById(R.id.prep32);
            ImageView view33 = (ImageView) view3.findViewById(R.id.prep33);

            views1 = new ArrayList<>();
            views1.add(0, view31);
            views1.add(1, view32);
            views1.add(2, view33);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(2);
            setImages(questionAsSound, views1, correctAnswerIndex);
        } else if(viewIndex == 2){
            ImageView view41 = (ImageView) view4.findViewById(R.id.prep41);
            ImageView view42 = (ImageView) view4.findViewById(R.id.prep42);
            ImageView view43 = (ImageView) view4.findViewById(R.id.prep43);
            ImageView view44 = (ImageView) view4.findViewById(R.id.prep44);

            views2 = new ArrayList<>();
            views2.add(0, view41);
            views2.add(1, view42);
            views2.add(2, view43);
            views2.add(3, view44);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(3);
            setImages(questionAsSound, views2, correctAnswerIndex);
        }
    }

    private void setImages(Integer questionAsSound, List<ImageView> views, int correctAnswerIndex) {
        for(int i = 0; i < views.size(); i++){
            ImageView view = views.get(i);
            //the tags set below are cached
            view.setTag(null);
            //correct answer
            MayekCard card = cardMap.get(questionAsSound);
            if(i == correctAnswerIndex){
                Log.d("setImages", card.toString());
                view.setImageResource(card.getRes());
                view.setTag(PrepActivity.CORRECT_ANSWER);
            } else {
                //random image buttons
                view.setImageResource(randomImageFromRest(card));
            }
        }
    }

    public void resetBackgroundColor(int viewIndex) {
        List<ImageView> imageViews = null;
        if(viewIndex == 0){
            imageViews = views0;
        } else if(viewIndex == 1){
            imageViews = views1;
        } else if(viewIndex == 2){
            imageViews = views2;
        }

        for(ImageView imageView : imageViews){
            imageView.setBackgroundColor(Color.WHITE);
        }
    }

    private Integer randomImageFromRest(MayekCard card){
        Random randomizer = new Random();
        List<MayekCard> temp = new ArrayList<>(cardList);
        Log.d("randomImageFromRest", ""+temp.size());
        temp.remove(card);
        Log.d("randomImageFromRest", ""+temp.size());
        MayekCard random = temp.get(randomizer.nextInt(temp.size()));
        return random.getRes();
    }

    public Integer getQuestionAsSound(){
        Random randomizer = new Random();
        return keys.get(randomizer.nextInt(keys.size()));
    }

    private void randomCorrectAnswer(List<ImageView> views){
        Random randomizer = new Random();
        ImageView random = views.get(randomizer.nextInt(views.size()));
    }

    public View getView(int index) {
        return views.get(index);
    }

    public int getTotalNoOfViews(){
        return views.size();
    }



}
