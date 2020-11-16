package com.github.curriculeon.dicetest;

import com.github.curriculeon.Dice;
import org.junit.Assert;
import org.junit.Test;

public class RollAndSumTest {
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test0() {
        // given
        Integer min = 0;
        Integer max = 0;
        Dice dice = new Dice(min, max);

        // when
        Integer sum = dice.rollAndSum();

        // then
        Assert.assertTrue(sum >= dice.getRollMin());
        Assert.assertTrue(sum <= dice.getRollMax());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        // given
        Integer min = 1;
        Integer max = 0;
        Dice dice = new Dice(min, max);

        // when
        Integer sum = dice.rollAndSum();

        // then
        Assert.assertTrue(sum >= dice.getRollMin());
        Assert.assertTrue(sum <= dice.getRollMax());
    }

    @Test
    public void test2() {
        // given
        Integer min = 1;
        Integer max = 1;
        Dice dice = new Dice(min, max);

        // when
        Integer sum = dice.rollAndSum();

        // then
        Assert.assertTrue(sum >= dice.getRollMin());
        Assert.assertTrue(sum <= dice.getRollMax());
    }

    @Test
    public void test3() {
        // given
        Integer min = 1;
        Integer max = 2;
        Dice dice = new Dice(min, max);

        // when
        Integer sum = dice.rollAndSum();

        // then
        Assert.assertTrue(sum >= dice.getRollMin());
        Assert.assertTrue(sum <= dice.getRollMax());
    }

    @Test
    public void test4() {
        // given
        Integer min = 2;
        Integer max = 3;
        Dice dice = new Dice(min, max);

        // when
        Integer sum = dice.rollAndSum();

        // then
        Assert.assertTrue(sum >= dice.getRollMin());
        Assert.assertTrue(sum <= dice.getRollMax());
    }

    @Test(expected = NegativeArraySizeException.class)
    public void test5() {
        // given
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        Dice dice = new Dice(min, max);

        // when
        Integer sum = dice.rollAndSum();

        // then
        Assert.assertTrue(sum >= dice.getRollMin());
        Assert.assertTrue(sum <= dice.getRollMax());
    }
}
