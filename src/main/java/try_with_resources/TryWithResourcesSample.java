package try_with_resources;

import java.io.Closeable;
import java.io.IOException;

public class TryWithResourcesSample {

    static class One implements Closeable {
        public void print() {
            System.out.println("I'm working");
        }
        @Override
        public void close() throws IOException {
            System.out.println("I'm closing automatically");
        }
    }

    public static void main(String[] args) throws IOException {
        try (One a = new One()) {
            a.print();
        }
    }
}
