package com.github.curriculeon.binstest;

import com.github.curriculeon.Bin;
import com.github.curriculeon.Bins;
import org.junit.Assert;
import org.junit.Test;

public class IncrementBinTest {
    @Test
    public void test0() {
        Integer numberOfIncrements = 0;
        Integer faceValueToIncrement = 5;
        test(numberOfIncrements, faceValueToIncrement);
    }

    @Test
    public void test1() {
        Integer numberOfIncrements = 1;
        Integer faceValueToIncrement = 4;
        test(numberOfIncrements, faceValueToIncrement);
    }

    @Test
    public void test2() {
        Integer numberOfIncrements = 2;
        Integer faceValueToIncrement = 3;
        test(numberOfIncrements, faceValueToIncrement);
    }

    @Test
    public void test3() {
        Integer numberOfIncrements = 3;
        Integer faceValueToIncrement = 2;
        test(numberOfIncrements, faceValueToIncrement);
    }


    private void test(Integer numberOfIncrements, Integer faceValueToIncrement) {
        // given
        Bins bins = new Bins();
        Bin selectedBin = bins.getBin(faceValueToIncrement);
        Integer preIncrementValue = selectedBin.getNumberOfOccurrences();
        Integer postIncrementValue = preIncrementValue + numberOfIncrements;
        Integer expected = postIncrementValue - preIncrementValue;

        // when
        for (int currentIteration = 0; currentIteration < numberOfIncrements; currentIteration++) {
            bins.incrementBin(faceValueToIncrement);
        }

        // then
        Integer actual = selectedBin.getNumberOfOccurrences();
        Assert.assertEquals(expected, actual);
    }
}
