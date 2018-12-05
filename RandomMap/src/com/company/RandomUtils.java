package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final public class RandomUtils {
    private RandomUtils() {
    }

    private static Random random = new Random(System.currentTimeMillis());

    public static int generateNumber() {
        return random.nextInt(100);
    }

    public static int[] generateIntArray() {
        int[] a = new int[generateNumber()];
        for (int i = 0; i < a.length; i++)
            a[i] = generateNumber();
        return a;
    }

    public static List<String> generateStringArrayFrom(List<String> lines) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            words.add(lines.get(random.nextInt(lines.size())));
        }
        return words;
    }
}
