package com.itservz.android.mayekplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.itservz.android.mayekplay.color.CardColor;
import com.itservz.android.mayekplay.color.ColorsFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by raju.athokpam on 05-09-2016.
 */
public class ViewBuilder {
    private Context context;
    private View view2;
    private View view3;
    private View view4;
    private View view5;
    private View view6;
    private View view7;
    private View view8;
    private View view9;
    private View view10;
    private View view11;
    private View view12;
    private View view13;
    private View view14;
    private View view15;
    private View view16;

    private List<MayekCard> cardList = Mayeks.getInstance().getCardList();
    private List<Integer> keys = Mayeks.getInstance().getKeys();
    private Map<Integer, MayekCard> cardMap = Mayeks.getInstance().getCardMap();

    private List<MayekCard> cardListABC = Alphabets.getInstance().getCardList();
    private List<Integer> keysABC = Alphabets.getInstance().getKeys();
    private Map<Integer, MayekCard> cardMapABC = Alphabets.getInstance().getCardMap();

    private List<View> views = null;
    private List<Integer> askedQuestions = null;

    private ColorsFactory colorsFactory = null;
    private boolean isABC;
    private float imageCorner;
    private int imageSize;

    public ViewBuilder(boolean abc, Context context) {
        views = new ArrayList<>();
        askedQuestions = new ArrayList<>();
        isABC = abc;
        this.context = context;
        this.colorsFactory = ColorsFactory.getInstance(context);
        imageCorner = context.getResources().getDisplayMetrics().density * 10;
        imageSize = (int) (context.getResources().getDisplayMetrics().density * 64);
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

        view10 = LayoutInflater.from(prepActivity).inflate(R.layout.prep16, null);
        viewFlipper.addView(view10, 8);
        views.add(8, view10);

        view11 = LayoutInflater.from(prepActivity).inflate(R.layout.prep16, null);
        viewFlipper.addView(view11, 9);
        views.add(9, view11);

        view12 = LayoutInflater.from(prepActivity).inflate(R.layout.prep16, null);
        viewFlipper.addView(view12, 10);
        views.add(10, view12);

        view13 = LayoutInflater.from(prepActivity).inflate(R.layout.prep16, null);
        viewFlipper.addView(view13, 11);
        views.add(11, view13);

        view14 = LayoutInflater.from(prepActivity).inflate(R.layout.prep16, null);
        viewFlipper.addView(view14, 12);
        views.add(12, view14);

        view15 = LayoutInflater.from(prepActivity).inflate(R.layout.prep16, null);
        viewFlipper.addView(view15, 13);
        views.add(13, view15);

        view16 = LayoutInflater.from(prepActivity).inflate(R.layout.prep16, null);
        viewFlipper.addView(view16, 14);
        views.add(14, view16);
    }

    public void build(int viewIndex, int questionAsSound) {
        // get a sound to be played
        if (viewIndex == 0) {
            List<ImageView> views2 = QuestionViews.getViews2(view2);
            int correctAnswerIndex = new Random().nextInt(1);
            setImages(questionAsSound, views2, correctAnswerIndex);
        } else if (viewIndex == 1) {
            List<ImageView> views3 = QuestionViews.getViews3(view3);
            int correctAnswerIndex = new Random().nextInt(2);
            setImages(questionAsSound, views3, correctAnswerIndex);
        } else if (viewIndex == 2) {
            List<ImageView> views4 = QuestionViews.getViews4(view4);
            int correctAnswerIndex = new Random().nextInt(3);
            setImages(questionAsSound, views4, correctAnswerIndex);
        } else if (viewIndex == 3) {
            List<ImageView> views5 = QuestionViews.getViews5(view5);
            int correctAnswerIndex = new Random().nextInt(4);
            setImages(questionAsSound, views5, correctAnswerIndex);
        } else if (viewIndex == 4) {
            List<ImageView> views6 = QuestionViews.getViews6(view6);
            int correctAnswerIndex = new Random().nextInt(5);
            setImages(questionAsSound, views6, correctAnswerIndex);
        } else if (viewIndex == 5) {
            List<ImageView> views7 = QuestionViews.getViews7(view7);
            int correctAnswerIndex = new Random().nextInt(6);
            setImages(questionAsSound, views7, correctAnswerIndex);
        } else if (viewIndex == 6) {
            List<ImageView> views8 = QuestionViews.getViews8(view8);
            int correctAnswerIndex = new Random().nextInt(7);
            setImages(questionAsSound, views8, correctAnswerIndex);
        } else if (viewIndex == 7) {
            List<ImageView> views9 = QuestionViews.getViews9(view9);
            int correctAnswerIndex = new Random().nextInt(8);
            setImages(questionAsSound, views9, correctAnswerIndex);
        } else if (viewIndex == 8) {
            List<ImageView> views10 = QuestionViews.getViews10(view10);
            int correctAnswerIndex = new Random().nextInt(9);
            setImages(questionAsSound, views10, correctAnswerIndex);
        } else if (viewIndex == 9) {
            int correctAnswerIndex = new Random().nextInt(viewIndex + 1);
            setImages(questionAsSound, QuestionViews.getViews11(view11), correctAnswerIndex);
        } else if (viewIndex == 10) {
            int correctAnswerIndex = new Random().nextInt(viewIndex + 1);
            setImages(questionAsSound, QuestionViews.getViews12(view12), correctAnswerIndex);
        } else if (viewIndex == 11) {
            int correctAnswerIndex = new Random().nextInt(viewIndex + 1);
            setImages(questionAsSound, QuestionViews.getViews13(view13), correctAnswerIndex);
        } else if (viewIndex == 12) {
            int correctAnswerIndex = new Random().nextInt(viewIndex + 1);
            setImages(questionAsSound, QuestionViews.getViews14(view14), correctAnswerIndex);
        } else if (viewIndex == 13) {
            int correctAnswerIndex = new Random().nextInt(viewIndex + 1);
            setImages(questionAsSound, QuestionViews.getViews15(view15), correctAnswerIndex);
        } else if (viewIndex == 14) {
            int correctAnswerIndex = new Random().nextInt(viewIndex + 1);
            setImages(questionAsSound, QuestionViews.getViews16(view16), correctAnswerIndex);
        }
    }

    public void buildMatch(View view, int noOfCards) {
        Log.d("ViewBuilder buildmatch", "" + noOfCards);
        List<ImageView> views = null;
        if (noOfCards == 4) {
            views = QuestionViews.getViews4(view);
        } else if (noOfCards == 6) {
            views = QuestionViews.getViews6(view);
        } else if (noOfCards == 8) {
            views = QuestionViews.getViews8(view);
        } else if (noOfCards == 10) {
            views = QuestionViews.getViews10(view);
        } else if (noOfCards == 12) {
            views = QuestionViews.getViews12(view);
        } else if (noOfCards == 14) {
            views = QuestionViews.getViews14(view);
        } else if (noOfCards == 16) {
            views = QuestionViews.getViews16(view);
        }
        //checking to enable user restart
        for (View v : views) {
            v.setClickable(true);
        }
        List<ImageView> addedViews = new ArrayList<>();
        //for each play the mayeks can be repeated
        askedQuestions = new ArrayList<>();
        for (int i = 0; i < noOfCards / 2; i++) {
            Integer question = getQuestionAsSound();
            int res;
            if (isABC) {
                res = cardMapABC.get(question).getRes();
            } else {
                res = cardMap.get(question).getRes();
            }

            ImageView match1 = randomViewFromRest(views, addedViews);
            if (!isABC && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                match1.setBackground( new BitmapDrawable(context.getResources(), getRoundedBitmap(res)));
            } else {
                match1.setBackgroundResource(res);
            }
            match1.setTag(res);
            match1.setImageResource(R.drawable.questionmark);
            addedViews.add(match1);

            ImageView match2 = randomViewFromRest(views, addedViews);
            if (!isABC && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                match2.setBackground( new BitmapDrawable(context.getResources(), getRoundedBitmap(res)));
            } else {
                match2.setBackgroundResource(res);
            }
            match2.setTag(res);
            match2.setImageResource(R.drawable.questionmark);
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
        MayekCard card = null;
        if (isABC) {
            card = cardMapABC.get(questionAsSound);
        } else {
            card = cardMap.get(questionAsSound);
        }
        addedViews.add(card);
        for (int i = 0; i < views.size(); i++) {
            ImageView view = views.get(i);
            //the tags set below are cached
            view.setTag(null);
            if (i == correctAnswerIndex) {
                if(isABC)
                    view.setImageResource(card.getRes());
                else
                    view.setImageBitmap(getRoundedBitmap(card.getRes()));
                view.setTag(QuizPrepBaseActivity.CORRECT_ANSWER);
            } else {
                //random image buttons
                MayekCard uniqueRandomCard = randomImageFromRest(addedViews);
                if(isABC)
                    view.setImageResource(uniqueRandomCard.getRes());
                else
                    view.setImageBitmap(getRoundedBitmap(uniqueRandomCard.getRes()));
                addedViews.add(uniqueRandomCard);
            }
        }
    }

    private Bitmap getRoundedBitmap(int res) {
        CardColor cardColor = colorsFactory.getRandomPokerColors();
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inMutable = true;
        Bitmap myBitmap = BitmapFactory.decodeResource(context.getResources(), res, o);
        int[] allpixels = new int[myBitmap.getHeight() * myBitmap.getWidth()];

        myBitmap.getPixels(allpixels, 0, myBitmap.getWidth(), 0, 0, myBitmap.getWidth(), myBitmap.getHeight());
        for (int i = 0; i < allpixels.length; i++) {
            if (allpixels[i] < Color.DKGRAY) {
                allpixels[i] = cardColor.getDark();
            } else {
                allpixels[i] = cardColor.getLight();
            }
        }
        myBitmap.setPixels(allpixels, 0, myBitmap.getWidth(), 0, 0, myBitmap.getWidth(), myBitmap.getHeight());

        Bitmap imageRounded = Bitmap.createBitmap(imageSize, imageSize , myBitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);

        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(myBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, imageSize, imageSize)), imageCorner, imageCorner, mpaint);
        return imageRounded;

    }

    public void resetBackgroundColor(int viewIndex) {
        List<ImageView> imageViews = null;;
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
        } else if (viewIndex == 8) {
            imageViews = QuestionViews.getViews16(view10);
        } else if (viewIndex == 9) {
            imageViews = QuestionViews.getViews16(view11);
        } else if (viewIndex == 10) {
            imageViews = QuestionViews.getViews16(view12);
        } else if (viewIndex == 11) {
            imageViews = QuestionViews.getViews16(view13);
        } else if (viewIndex == 12) {
            imageViews = QuestionViews.getViews16(view14);
        } else if (viewIndex == 13) {
            imageViews = QuestionViews.getViews16(view15);
        } else if (viewIndex == 14) {
            imageViews = QuestionViews.getViews16(view16);
        }

        for (ImageView imageView : imageViews) {
            imageView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private MayekCard randomImageFromRest(List<MayekCard> addedCards) {
        Random randomizer = new Random();
        List<MayekCard> temp = null;
        if (isABC) {
            temp = new ArrayList<>(cardListABC);
        } else {
            temp = new ArrayList<>(cardList);
        }
        temp.removeAll(addedCards);
        return temp.get(randomizer.nextInt(temp.size()));
    }

    public Integer getQuestionAsSound() {
        Random randomizer = new Random();
        List<Integer> temp = null;
        if (isABC) {
            temp = new ArrayList<>(keysABC);
        } else {
            temp = new ArrayList<>(keys);
        }
        temp.removeAll(askedQuestions);
        Integer question = temp.get(randomizer.nextInt(temp.size()));
        askedQuestions.add(question);
        return question;
    }

    public View getView(int index) {
        return views.get(index);
    }

    public int getTotalNoOfViews() {
        return views.size();
    }


}
