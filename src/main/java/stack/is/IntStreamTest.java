package stack.is;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        byte[] response = new byte[]{11,12,13,14,15,16,17,18,19,20,21,22};


        int[] ints = IntStream.rangeClosed(3, 10)
            .map(i -> response[i])
            .toArray();

        Arrays.stream(ints)
            .forEach(new IntConsumer() {
                @Override
                public void accept(int value) {
                    System.out.println(value+" ");
                }
            });
    }

}
