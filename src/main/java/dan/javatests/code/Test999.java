package dan.javatests.code;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test999 {
    public static void main(String[] args) {
        int[] numbers = {1,5,7,2,4};
        Queue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        while(index < numbers.length) {
            pq.add(numbers[index]);
            index++;
        }
        pq.forEach(System.out::println);

        while (pq.size()>0) {
            System.out.print(pq.poll()+" ");
        }


        System.out.println(pq);
    }
}