package try_with_resources;

import java.io.Closeable;
import java.io.IOException;

public class CloseableTest {
    static class T1 implements Closeable {
        public void run() {
            System.out.println("I'm running");
        }

        @Override
        public void close() throws IOException {
            System.out.println("I'm closed automatically");
        }
    }

    public static void main(String[] args) throws IOException {
        try ( T1 t = new T1() ) {
            t.run();
        }

    }
}
