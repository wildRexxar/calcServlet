package by.tms.storage;

import by.tms.entity.Result;
import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryResultStorage {

    private final static List<Result> resultList = new ArrayList<>();
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    public void addResult(String example, String result, User user){
            resultList.add(new Result(user, example, result));

    }

    public List<Result> showResults (User user) {
        List<Result> userResult = new ArrayList<>();
        for(Result result :resultList){
            if(result.getUser().equals(user)) {
                userResult.add(result);
            }
        }
        return userResult;
    }
}
