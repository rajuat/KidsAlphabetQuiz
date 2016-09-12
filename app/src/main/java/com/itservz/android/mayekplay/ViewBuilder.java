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
    private View view5;
    private View view6;
    private View view7;
    private View view8;
    private View view9;
    private List<ImageView> views0;
    private List<ImageView> views1;
    private List<ImageView> views2;
    private List<ImageView> views3;
    private List<ImageView> views4;
    private List<ImageView> views5;
    private List<ImageView> views6;
    private List<ImageView> views7;

    private List<View> views = new ArrayList<>();
    private List<MayekCard> cardList = Mayeks.getInstance().getCardList();
    private List<Integer> keys = Mayeks.getInstance().getKeys();
    private Map<Integer, MayekCard> cardMap = Mayeks.getInstance().getCardMap();
    private List<Integer> askedQuestions = new ArrayList<>();


    public void setViewsToFlipper(QuizPrepBaseActivity prepActivity, ViewFlipper viewFlipper){
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
        } else if(viewIndex == 3){
            ImageView view51 = (ImageView) view5.findViewById(R.id.prep51);
            ImageView view52 = (ImageView) view5.findViewById(R.id.prep52);
            ImageView view53 = (ImageView) view5.findViewById(R.id.prep53);
            ImageView view54 = (ImageView) view5.findViewById(R.id.prep54);
            ImageView view55 = (ImageView) view5.findViewById(R.id.prep55);

            views3 = new ArrayList<>();
            views3.add(0, view51);
            views3.add(1, view52);
            views3.add(2, view53);
            views3.add(3, view54);
            views3.add(4, view55);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(4);
            setImages(questionAsSound, views3, correctAnswerIndex);
        } else if(viewIndex == 4){
            ImageView view61 = (ImageView) view6.findViewById(R.id.prep61);
            ImageView view62 = (ImageView) view6.findViewById(R.id.prep62);
            ImageView view63 = (ImageView) view6.findViewById(R.id.prep63);
            ImageView view64 = (ImageView) view6.findViewById(R.id.prep64);
            ImageView view65 = (ImageView) view6.findViewById(R.id.prep65);
            ImageView view66 = (ImageView) view6.findViewById(R.id.prep66);

            views4 = new ArrayList<>();
            views4.add(0, view61);
            views4.add(1, view62);
            views4.add(2, view63);
            views4.add(3, view64);
            views4.add(4, view65);
            views4.add(5, view66);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(5);
            setImages(questionAsSound, views4, correctAnswerIndex);
        }  else if(viewIndex == 5){
            ImageView view71 = (ImageView) view7.findViewById(R.id.prep71);
            ImageView view72 = (ImageView) view7.findViewById(R.id.prep72);
            ImageView view73 = (ImageView) view7.findViewById(R.id.prep73);
            ImageView view74 = (ImageView) view7.findViewById(R.id.prep74);
            ImageView view75 = (ImageView) view7.findViewById(R.id.prep75);
            ImageView view76 = (ImageView) view7.findViewById(R.id.prep76);
            ImageView view77 = (ImageView) view7.findViewById(R.id.prep77);

            views5 = new ArrayList<>();
            views5.add(0, view71);
            views5.add(1, view72);
            views5.add(2, view73);
            views5.add(3, view74);
            views5.add(4, view75);
            views5.add(5, view76);
            views5.add(6, view77);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(6);
            setImages(questionAsSound, views5, correctAnswerIndex);
        }  else if(viewIndex == 6){
            ImageView view81 = (ImageView) view8.findViewById(R.id.prep81);
            ImageView view82 = (ImageView) view8.findViewById(R.id.prep82);
            ImageView view83 = (ImageView) view8.findViewById(R.id.prep83);
            ImageView view84 = (ImageView) view8.findViewById(R.id.prep84);
            ImageView view85 = (ImageView) view8.findViewById(R.id.prep85);
            ImageView view86 = (ImageView) view8.findViewById(R.id.prep86);
            ImageView view87 = (ImageView) view8.findViewById(R.id.prep87);
            ImageView view88 = (ImageView) view8.findViewById(R.id.prep88);

            views6 = new ArrayList<>();
            views6.add(0, view81);
            views6.add(1, view82);
            views6.add(2, view83);
            views6.add(3, view84);
            views6.add(4, view85);
            views6.add(5, view86);
            views6.add(6, view87);
            views6.add(7, view88);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(7);
            setImages(questionAsSound, views6, correctAnswerIndex);
        }  else if(viewIndex == 7){
            ImageView view91 = (ImageView) view9.findViewById(R.id.prep91);
            ImageView view92 = (ImageView) view9.findViewById(R.id.prep92);
            ImageView view93 = (ImageView) view9.findViewById(R.id.prep93);
            ImageView view94 = (ImageView) view9.findViewById(R.id.prep94);
            ImageView view95 = (ImageView) view9.findViewById(R.id.prep95);
            ImageView view96 = (ImageView) view9.findViewById(R.id.prep96);
            ImageView view97 = (ImageView) view9.findViewById(R.id.prep97);
            ImageView view98 = (ImageView) view9.findViewById(R.id.prep98);
            ImageView view99 = (ImageView) view9.findViewById(R.id.prep99);

            views7 = new ArrayList<>();
            views7.add(0, view91);
            views7.add(1, view92);
            views7.add(2, view93);
            views7.add(3, view94);
            views7.add(4, view95);
            views7.add(5, view96);
            views7.add(6, view97);
            views7.add(7, view98);
            views7.add(8, view99);

            //decide a correct answer
            int correctAnswerIndex = new Random().nextInt(8);
            setImages(questionAsSound, views7, correctAnswerIndex);
        }
    }

    private void setImages(Integer questionAsSound, List<ImageView> views, int correctAnswerIndex) {
        List<MayekCard> addedViews = new ArrayList<>();
        //correct answer
        MayekCard card = cardMap.get(questionAsSound);
        addedViews.add(card);
        for(int i = 0; i < views.size(); i++){
            ImageView view = views.get(i);
            //the tags set below are cached
            view.setTag(null);
            if(i == correctAnswerIndex){
                Log.d("setImages", card.toString());
                view.setImageResource(card.getRes());
                view.setTag(PrepActivity.CORRECT_ANSWER);
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
        if(viewIndex == 0){
            imageViews = views0;
        } else if(viewIndex == 1){
            imageViews = views1;
        } else if(viewIndex == 2){
            imageViews = views2;
        } else if(viewIndex == 3){
            imageViews = views3;
        }  else if(viewIndex == 4){
            imageViews = views4;
        }  else if(viewIndex == 5){
            imageViews = views5;
        }  else if(viewIndex == 6){
            imageViews = views6;
        }  else if(viewIndex == 7){
            imageViews = views7;
        }

        for(ImageView imageView : imageViews){
            imageView.setBackgroundColor(Color.WHITE);
        }
    }

    private MayekCard randomImageFromRest(List<MayekCard> addedCards){
        Random randomizer = new Random();
        List<MayekCard> temp = new ArrayList<>(cardList);
        Log.d("randomImageFromRest", ""+temp.size());
        temp.removeAll(addedCards);
        Log.d("randomImageFromRest", ""+temp.size());
        return temp.get(randomizer.nextInt(temp.size()));
    }

    @Deprecated
    private Integer randomImageFromRests(MayekCard card){
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
        List<Integer> temp = new ArrayList<>(keys);
        temp.removeAll(askedQuestions);
        Integer question = temp.get(randomizer.nextInt(temp.size()));
        askedQuestions.add(question);
        return question;
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
