package my.home.jkits.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class Statistic {
    private HashMap<String, Integer> data = new HashMap<>();

    public void putWord(String word) {
        Integer count = data.merge(word, 1, Integer::sum);
    }

    public int getTagCount(String tag) {
        return data.get(tag);
    }
}
