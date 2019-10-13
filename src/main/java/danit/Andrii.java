package danit;

import java.util.HashMap;
import java.util.Map;

public class Andrii {
    public static void main(String[] args) {
        Map<String, Integer> dictionary = new HashMap<>();
        String[] words = "A B C".split(" ");
        for (String word : words) {
            Integer count = dictionary.getOrDefault(word,0);
            dictionary.put(word, ++count);
        }
    }
}
