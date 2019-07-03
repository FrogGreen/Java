package com.company;

public class MathCalc {
    public int add(int x, int y) {
        int result;

        MathOper sum = (a, b) -> {
            return a + b;
        };

        return sum.sum(x, y);
    }
}
