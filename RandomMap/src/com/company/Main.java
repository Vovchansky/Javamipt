package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] Words = new String[RandomUtils.generateNumber()];
        System.out.println();
        try (FileIterator File = new FileIterator("src/com/company/words")) {
            int counter = 0;
            String Line = File.next();
            String[] Lines = Line.split(";");
            while (counter < Words.length) {
                Words[counter] = Lines[counter];
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] a = RandomUtils.generateArrayOf(RandomUtils.generateNumber());
        Map RandomMap;
        if (a.length > Words.length) {
            RandomMap = new HashMap<int[], String>();
            for (int i = 0; i < a.length; i++) {
                if (i >= Words.length) {
                    RandomMap.put(a[i], null);
                } else {
                    RandomMap.put(a[i], Words[i]);
                }
            }
        } else {
            RandomMap = new HashMap<String, int[]>();
            for (int i = 0; i < Words.length; i++) {
                if (i >= a.length) {
                    RandomMap.put(Words[i], null);
                } else {
                    RandomMap.put(Words[i], a[i]);
                }
            }
        }
        RandomMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
