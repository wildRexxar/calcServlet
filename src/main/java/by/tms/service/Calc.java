package by.tms.service;

public enum Calc {
    PLUS, MINUS, MULTIPLE, DIVIDED;

    public double compute(double num1, double num2) {
        switch (this) {
            case PLUS:
                return num1 + num2;
            case MINUS:
                return num1 - num2;
            case MULTIPLE:
                return num1 * num2;
            case DIVIDED:
                return num1 / num2;
            default:
                return 0;
        }
    }
}
