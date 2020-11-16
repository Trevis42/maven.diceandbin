package com.github.curriculeon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Dice implements Iterable<Die>{
    private final Die[] dieArray;
    /**
     * @param numberOfDie - number of die-objects to be contained
     */
    public Dice(Integer numberOfDie) {
        this(numberOfDie, 6);
    }

    /**
     * @param numberOfDie - number of die-objects to be contained
     * @param numberOfFaces - number of faces on a single die-object
     */
    public Dice(Integer numberOfDie, Integer numberOfFaces) {
        this.dieArray = new Die[numberOfDie];
        IntStream.range(0, dieArray.length).forEach(i -> dieArray[i] = new Die(numberOfFaces));
    }

    /**
     * Create a random number from 1 to 6 for each dice you roll
     * sum all of the random numbers up and that equals total for that roll
     */
    public Integer rollAndSum() {
        Integer sum = 0;
        for (Die die : dieArray) {
            die.roll();
            sum += die.getCurrentFaceValue();
        }
        return sum;
    }

    /**
     * @return the absolute minimum value that can be rolled by this set of die
     */
    public Integer getRollMin() {
        return dieArray.length;
    }

    /**
     * @return the absolute maximum value that can be rolled by this set of die
     */
    public Integer getRollMax() {
        return getRollMin() * dieArray[0].getNumberOfFaces();
    }

    @Override
    public Iterator<Die> iterator() {
        return Arrays.asList(dieArray).iterator();
    }
}
