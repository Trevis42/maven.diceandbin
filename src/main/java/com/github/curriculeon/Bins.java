package com.github.curriculeon;

import java.util.Arrays;
import java.util.StringJoiner;

public class Bins {
    private final Bin[] binArray;

    public Bins() {
        this(2,12);
    }

    public Bins(Integer minFaceValue, Integer maxFaceValue) {
        int numberOfBins = (maxFaceValue - minFaceValue) + 1;
        this.binArray = new Bin[numberOfBins];
        for (int i = 0; i < binArray.length; i++) {
            Integer faceValueToTrack = minFaceValue + i;
            binArray[i] = new Bin(faceValueToTrack);
        }
    }

    public void incrementBin(Integer faceValueToIncrement) {
        getBin(faceValueToIncrement).increment();
    }

    public Bin getBin(Integer faceValueToIncrement) {
        for (Bin bin : binArray) {
            int faceValueSumToTrack = bin.getFaceValueToTrack();
            if (faceValueSumToTrack == faceValueToIncrement)
                return bin;
        }
        String errorMessage = new StringJoiner("\n")
                .add("Unable to find bin with face-value [ %s ]")
                .add("Here are the list of bins we have available:")
                .add(this.toString())
                .toString();
        throw new RuntimeException(String.format(errorMessage, faceValueToIncrement));
    }

    public Bin[] getBins() {
        return binArray;
    }

    @Override
    public String toString() {
        return "Bins{" +
                "binArray=" + Arrays.toString(binArray) +
                '}';
    }
}
