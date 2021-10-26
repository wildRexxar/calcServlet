package by.tms.entity;

public class Result {
    private int index;
    private String example;
    private String result;

    public Result(int index, String example, String result) {
        this.index = index;
        this.example = example;
        this.result = result;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return example + " = " + result;
    }
}