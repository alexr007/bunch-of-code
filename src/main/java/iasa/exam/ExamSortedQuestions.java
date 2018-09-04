package iasa.exam;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ExamSortedQuestions {
    private final static String PATH="./src/main/java/iasa/exam";
    private final static String FILE_IN="questions.txt";
    private final static String TEMPLATE="template.txt";
    private final static String FILE_OUT="questions_to_print.txt";
    private final static String PAGE_FEED= "\u000C";

    static class Questions implements Iterable<String>{
        private final List<String> questions;
        private final int count;
        private final String template;
        private final Random rand = new Random();
        private final Set<Integer> used = new HashSet<>();

        Questions(List<String> questions, String template) {
            this.questions = questions;
            this.template = template;
            this.count=questions.size();
            used.add(-1);
        }

        private int getNextUnique() {
            int next=-1;
            while (used.contains(next)) {
                next = rand.nextInt(count);
            }
            used.add(next);
            return next;
        }

        @Override
        public Iterator<String> iterator() {
            final int[] number = {0};
            return new Iterator<String>() {
                @Override
                public boolean hasNext() {
                    System.out.println(number[0]);
                    return (number[0]+1)*3<count;
                }

                @Override
                public String next() {
                    return String.format(template, getAndIncTicketId(), questions.get(getNextUnique()), questions.get(getNextUnique()),questions.get(getNextUnique()));
                }

                private int getAndIncTicketId() {
                    return ++number[0];
                }
            };
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> one = new BufferedReader(new FileReader(new File(PATH, FILE_IN))).lines().collect(Collectors.toList());
        ArrayList<String> all = new ArrayList<>();
        all.addAll(one);
        all.addAll(one);
        all.addAll(one);

        Questions q = new Questions(all, new String(Files.readAllBytes(Paths.get(PATH, TEMPLATE)), StandardCharsets.UTF_8));
        BufferedWriter w = new BufferedWriter(new FileWriter(new File(PATH, FILE_OUT)));
        for (String s : q) {
            w.write(s);
            w.write(PAGE_FEED);
        }
        w.close();
    }
}
