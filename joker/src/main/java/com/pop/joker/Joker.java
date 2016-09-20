package com.pop.joker;

import java.util.Random;

public class Joker {

    static String[] jokes = {
            "Joke 1",
            "Joke 2",
            "Joke 3",
            "Joke 4",
            "Joke 5",
            "Joke 6",
            "Joke 7",
            "Joke 8",
            "Joke 9",
            "Joke 10"};

    public static String getJoke() {

        int population = jokes.length;

        Random random = new Random();

        int index = random.nextInt(population);

        return jokes[index];

    }

    public static String getJoke(int index) {

        return jokes[index];

    }
}
