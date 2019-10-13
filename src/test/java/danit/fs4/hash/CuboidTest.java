package danit.fs4.hash;

import org.junit.Test;

import java.util.*;

public class CuboidTest {

    public class ScannerFromString {
        private Iterator<String> in;

        public ScannerFromString(String origin) {
            this.in = Arrays.asList(origin.split(" ")).iterator();
        }

        public int nextInt() {
            return Integer.valueOf(in.next());
        }
    }


    @Test
    public void main() {
        Map<Integer, Integer> sides = new HashMap<> ();
        //Scanner in = new Scanner(System.in);
        ScannerFromString in = new ScannerFromString("24 3 5 5 7 7 3 4 4 9 5 7 1 1 9 9 1 3 5 3 4 4 7 1 9");
        Queue<Integer> maxQueue = new PriorityQueue<>((n1,n2)->n2-n1);
        int N = in.nextInt();

        for (int i=0; i<N; i++){
            int side = in.nextInt();

            Integer count = sides.get(side);
            count = count == null ? 1 : count+1;
            sides.put(side, count);

            if(count == 4) {
                maxQueue.add(side);
                sides.remove(side);
            }
        }

        int result =   maxQueue.size()<3 ? -1 :  maxQueue.poll()*maxQueue.poll()*maxQueue.poll() ;

        System.out.println(result);
    }
}
