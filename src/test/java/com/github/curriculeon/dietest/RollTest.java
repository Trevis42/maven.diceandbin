package com.github.curriculeon.dietest;

import com.github.curriculeon.Die;
import org.junit.Assert;
import org.junit.Test;

public class RollTest {
    @Test(expected = NullPointerException.class)
    public void test1() {
        // given
        Integer numberOfFaces = null;
        Die die = new Die(numberOfFaces);

        // when
        die.roll();
    }

    @Test
    public void test2() {
        // given
        Integer numberOfFaces = 1;
        Die die = new Die(numberOfFaces);

        // when
        die.roll();
    }


    @Test
    public void test3() {
        // given
        Integer numberOfFaces = 2;
        Integer unexpected = null;
        Die die = new Die(numberOfFaces);

        // when
        die.roll();
        Integer actual = die.getCurrentFaceValue();

        // then
        Assert.assertNotEquals(unexpected, actual);
    }


    @Test
    public void test4() {
        // given
        Integer numberOfFaces = 3;
        Integer unexpected = null;
        Die die = new Die(numberOfFaces);

        // when
        die.roll();
        Integer actual = die.getCurrentFaceValue();

        // then
        Assert.assertNotEquals(unexpected, actual);
    }
}
