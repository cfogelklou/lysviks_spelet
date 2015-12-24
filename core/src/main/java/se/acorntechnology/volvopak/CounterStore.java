package se.acorntechnology.volvopak;

import java.util.Random;

public class CounterStore {

    private Random mRand = new Random();

    private final String[] STRINGS = {
            "Göra en regel",
            "Tumme mäster",
            "Charader!",
            "Sjung",
            "Rimma",
            "Regel",
            "Saga",
            "Ämne",
    };

    public CounterStore() {
        mRand.setSeed(System.nanoTime());
    }

    public String get() {

        int  n = mRand.nextInt(STRINGS.length);
        return STRINGS[n];
    }

    private final String[] CHARADES = {
            "Spela fotboll",
            "Basket",
            "Hockey",
            "giraff",
                    "lejon",
                    "katt",
                    "elefant",
                    "ko",
                    "mus",
                    "gorilla",
                    "häst",
                    "kanin",
                    "apa",
                    "hund",
                    "fisk",
            "ambulance"
    };

    public String getCharade() {
        int  n = mRand.nextInt(CHARADES.length);
        return CHARADES[n];
    }
}
