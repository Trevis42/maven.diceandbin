package com.github.curriculeon.binstest;

import com.github.curriculeon.Bin;
import com.github.curriculeon.Bins;
import org.junit.Assert;
import org.junit.Test;

public class GetBinTest {
    @Test(expected = NullPointerException.class)
    public void test1() {
        // given
        Bins bins = new Bins();
        Integer expected = null;

        // when
        Bin bin = bins.getBin(expected);
        Integer actual = bin.getFaceValueToTrack();

        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test2() {
        // given
        Bins bins = new Bins();
        Integer expected = 4;

        // when
        Bin bin = bins.getBin(expected);
        Integer actual = bin.getFaceValueToTrack();

        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test3() {
        // given
        Bins bins = new Bins();
        Integer expected = 2;

        // when
        Bin bin = bins.getBin(expected);
        Integer actual = bin.getFaceValueToTrack();

        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test4() {
        // given
        Bins bins = new Bins();
        Integer expected = 3;

        // when
        Bin bin = bins.getBin(expected);
        Integer actual = bin.getFaceValueToTrack();

        // then
        Assert.assertEquals(expected, actual);
    }

}
