package org.teckhooi.orders.gkorders.service;

import java.util.HashMap;
import java.util.Map;

public class WordCountService {
    static public Map<String, Integer> countWordsIn(String s) {
        Map<String, Integer> result = new HashMap<>();
        for (String word: s.split(" ")) {
            result.put(word, result.getOrDefault(word, 0) + 1);
        }

        return  result;
    }
}
