package com.github.curriculeon;

import java.util.concurrent.ThreadLocalRandom;

public class Die {

    private final Integer numberOfFaces;
    private Integer currentFaceValue;

    public Die() {
        this(6);
    }

    public Die(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public void roll() {
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        this.currentFaceValue = rng.nextInt(1, numberOfFaces +1);
    }

    public Integer getCurrentFaceValue() {
        return this.currentFaceValue;    }

    public Integer getNumberOfFaces() {
        return this.numberOfFaces;    }
}
