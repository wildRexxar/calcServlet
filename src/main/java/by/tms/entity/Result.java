package by.tms.entity;

public class Result {
    private User user;
    private String example;
    private String result;

    public Result(User user, String example, String result) {
        this.user = user;
        this.example = example;
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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