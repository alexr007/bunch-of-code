package streams;

import java.util.AbstractMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamGenerate {
    public static void main(String[] args) {
        String line="This is test string";

        Stream<AbstractMap.SimpleEntry<Character, Integer>> st = Stream.generate(new Supplier<AbstractMap.SimpleEntry<Character, Integer>>() {
            int index = 0;

            @Override
            public AbstractMap.SimpleEntry<Character, Integer> get() {
                return new AbstractMap.SimpleEntry<>(line.charAt(index), index++);
            }
        }).limit(line.length());

        String collect = st
                .filter(e -> Character.isLetter(e.getKey()))
                .collect(Collectors.groupingBy(ent -> ent.getKey(), Collectors.mapping(ent -> ent.getValue(), Collectors.toList())))
                .entrySet().stream()
                .sorted((o1, o2) -> o1.getKey() - o2.getKey())
                .map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
                .collect(Collectors.joining(", "));

        System.out.println(collect);

    }
}
