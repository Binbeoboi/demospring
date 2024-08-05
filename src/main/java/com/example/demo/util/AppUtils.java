package com.example.demo.util;

import java.util.Random;

public class AppUtils {
    private final static Random random = new Random();

    public static int random(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
