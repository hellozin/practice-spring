package me.hellozin.spring;

import java.util.Arrays;

public class Calculator {

    public int calculate(int... val) {
        return Arrays.stream(val).sum();
    }

}
