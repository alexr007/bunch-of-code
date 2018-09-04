package join;

//import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
//import static org.junit.Assert.*;

public class JoinedTest {
    //@Test
    public void joinApproarch1() {
        System.out.println(
            new Joined().joinApproarch1(
                new HashSet(Arrays.asList("A","BB","CCC"))));
    }

    //@Test
    public void joinApproarch2() throws IOException {
        System.out.println(
            new Joined().joinApproarch2(
                new HashSet(Arrays.asList("A","BB","CCC"))));
    }


    public static void main(String[] args) throws IOException {
        JoinedTest j = new JoinedTest();
        j.joinApproarch1();
        j.joinApproarch2();
    }
}