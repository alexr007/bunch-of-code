package danit.fs4.hash;

import org.junit.Test;
import java.util.*;

public class DictionaryTest {

    @Test
    public void main1() {
        Map<String, Integer> dictionary = new TreeMap<>();

        String in1 = "cc a b c aa bb cc b cc bb bb";
        String[] split = in1.split(" ");
        List<String> strings = Arrays.asList(split);
        Iterator<String> in = strings.iterator();

        //Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String word = in.next();
            Integer count = dictionary.get(word);
            count = count == null ? 0 : count;
            dictionary.put(word, count + 1);
        }

        for (String word: dictionary.keySet()) {
            System.out.printf("%s: %d\n", word, dictionary.get(word));
        }
/*

        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
*/
    }

}
