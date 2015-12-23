package se.acorntechnology.volvopak;

import java.util.Random;

public class CounterStore {

    private Random mRand = new Random();

    private final String[] STRINGS = {
            "Gora en regel",
            "Tumme master",
            "Charader!",
            "Sjung",
            "Rimma",
            "Regel",
            "Saga",
            "Amne",
    };

    public CounterStore() {
        mRand.setSeed(System.nanoTime());
    }

    public String get() {

        int  n = mRand.nextInt(STRINGS.length);
        return STRINGS[n];
    }
}
