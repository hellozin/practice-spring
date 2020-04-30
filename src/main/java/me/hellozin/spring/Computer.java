package me.hellozin.spring;

public class Computer {

    private int id;

    private Calculator calculator;

    public Computer(int id, Calculator calculator) {
        this.id = id;
        this.calculator = calculator;
    }

    public int getId() {
        return id;
    }

    public int calculate(int... val) {
        return calculator.calculate(val);
    }
}
