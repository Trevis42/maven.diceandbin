package com.github.curriculeon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringJoiner;

public class Simulation {

    private final Dice dice;
    private final Bins bins;
    private final Integer numberOfTosses;

    public Simulation(Integer numberOfDie, Integer numberOfTosses) {
        this.dice = new Dice(numberOfDie);
        this.bins = new Bins(dice.getRollMin(), dice.getRollMax());
        this.numberOfTosses = numberOfTosses;
    }

    public Simulation(Integer numberOfDie, Integer numberOfTosses, Integer numberOfFaces) {
        this.dice = new Dice(numberOfDie, numberOfFaces);
        this.bins = new Bins(dice.getRollMin(), dice.getRollMax());
        this.numberOfTosses = numberOfTosses;
    }

    public void run() {
        for (int i = 0; i < numberOfTosses; i++) {
            int faceValueToTrack = dice.rollAndSum();
            bins.getBin(faceValueToTrack).increment();
        }
    }

    public Double getPercentageOfOccurrences(Integer faceValueToCheck) {
        return bins.getBin(faceValueToCheck).getNumberOfOccurrences() / numberOfTosses.doubleValue();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        StringJoiner finalOutput = new StringJoiner("\n");
        // stars will be percent *100
        // bin facevalue
        // number of tosses/dice in the bin
        // percentage
        // stars
        StringBuilder stars = new StringBuilder();
        int starVal;

        String simInfo = String.format("***%nSimulationTest of %s dice tossed for %d times.%n***%n", dice.getRollMin(),numberOfTosses);

        for (int i = 0; i < bins.getBins().length; i++){
            stars.setLength(0);
            Bin bin = bins.getBins()[i];
            Double percentValue = getPercentageOfOccurrences(bin.getFaceValueToTrack());
            Integer dicePerBin = bin.getNumberOfOccurrences();

            NumberFormat nf = new DecimalFormat("#.##");
            nf.setMaximumFractionDigits(2);
            nf.format(percentValue);

            starVal = Double.valueOf(Double.parseDouble(nf.format(percentValue)) * 100).intValue();
            for (int j = 0; j < starVal; j++) {
                stars.append("*");
            }

            output.append(String.format("%2d :", bin.getFaceValueToTrack()))
                    .append(String.format("%11d: ",dicePerBin))
                    .append(String.format("%2.2f: ",Double.valueOf(nf.format(percentValue))))
                    .append(String.format(" %s\n", stars.toString()));


        }
        return finalOutput.add(simInfo).add(output).toString();
    }

    public Bins getBins() {
        return bins;
    }
}
