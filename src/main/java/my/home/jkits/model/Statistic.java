package my.home.jkits.model;

import java.util.HashMap;
import java.util.Map;

public class Statistic {
    private final HashMap<String, Integer> data = new HashMap<>();

    public void putWord(String word) {
        Integer count = data.merge(word, 1, Integer::sum);
    }
}
