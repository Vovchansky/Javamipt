package com.company;

import java.util.Random;

final public class RandomUtils {
    private RandomUtils() {
    }

    public static int generateNumber() {
        Random random = new Random();
        int size = random.nextInt(100);
        return size;
    }
    public static int[] generateArrayOf(int size){
        int[] a = new int[size];
        for(int i = 0; i < size; i++)
            a[i] = generateNumber();
        return a;
    }
}
