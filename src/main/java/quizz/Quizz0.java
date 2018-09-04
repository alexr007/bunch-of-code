package quizz;

import java.util.*;

public class Quizz0 {
    public static void main(String[] args) {
        List<String> a0 = new ArrayList<String>();
            a0.add("hello");
            a0.add("word");

        List<String> a1 = new ArrayList<String>() {{
            add("hello");
            add("word");
        }};
        List<String> a2 = new ArrayList<String>() {{
            add("hello");
            add("word");
        }};
        List<String> a3 = new LinkedList<String>() {{
            add("hello");
            add("word");
        }};
        List<String> a4 = new LinkedList<String>() {{
            add("hello");
            add("word");
        }};
        Set<String> a5 = new HashSet<String>() {{
            add("hello");
            add("word");
        }};
        Map<String,String> a6 = new HashMap<String,String>() {{
            put("k1","hello");
            put("k2","word");
        }};
        System.out.println(a0.getClass().getName());
        System.out.println(a1.getClass().getName());
    }
}
