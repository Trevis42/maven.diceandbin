package com.github.curriculeon.binstest;

import com.github.curriculeon.Bins;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest {
    private void test(Integer minFaceValue, Integer maxFaceValue) {
        Bins bins = new Bins(minFaceValue, maxFaceValue);
        Assert.assertNotNull(bins.getBins());
    }

    @Test(expected = NullPointerException.class)
    public void test1() {
        test(null, null);
    }


    @Test(expected = NullPointerException.class)
    public void test2() {
        test(null, 1);
    }


    @Test(expected = NullPointerException.class)
    public void test3() {
        test(1, null);
    }

    @Test
    public void test4() {
        test(2, 1);
    }

    @Test
    public void test5() {
        test(3, 2);
    }

    @Test
    public void test6() {
        // given
        test(1, 1);
    }


    @Test
    public void test7() {
        test(2, 2);
    }


    @Test
    public void test8() {
        test(1, 2);
    }


    @Test
    public void test9() {
        test(1, 3);
    }

    @Test
    public void test10() {
        test(2, 3);
    }

}
