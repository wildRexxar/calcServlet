package by.tms.storage;

import by.tms.entity.Result;
import java.util.ArrayList;
import java.util.List;

public class InMemoryResultStorage {

    private final static List<Result> resultList = new ArrayList<>();
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    public int addResult(String example, String result){
        int index = inMemoryUserStorage.getUserIndex();
        if(index > -1) {
            resultList.add(new Result(index, example, result));
            return index;
        } else {
            return -1;
        }
    }

    public List<Result> showResults () {
        int index = inMemoryUserStorage.getUserIndex();
        List<Result> userResult = new ArrayList<>();
        for(Result result :resultList){
            if(result.getIndex() == index) {
                userResult.add(result);
            }
        }
        return userResult;
    }
}
