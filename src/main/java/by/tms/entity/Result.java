package by.tms.entity;

public class Result {
    private double num1;
    private String operation;
    private double num2;
    private double result;

    public Result(double num1, String operation, double num2, double result) {
        this.num1 = num1;
        this.operation = operation;
        this.num2 = num2;
        this.result = result;
    }
    @Override
    public String toString() {
        return num1 + " " + operation + " " + num2 + " = " + result;
    }
}
