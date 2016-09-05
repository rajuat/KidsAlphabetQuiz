package com.itservz.android.mayekplay;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void can(){
        List<MayekCard> list = Mayeks.getInstance().getCardList();
        Random randomizer = new Random();
        for(int i =0; i < 40; i++) {
            MayekCard random = list.get(randomizer.nextInt(list.size()));
            System.out.println(random.toString());
        }
    }
}