package threadstest;

import org.cactoos.Func;
import org.cactoos.matchers.RunsInThreads;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

/*
    http://www.yegor256.com/2018/03/27/how-to-test-thread-safety.html
 */
public class BooksTest {
    @Test
    public void addsAndRetrieves() {
        Books books = new Books();
        String title = "Elegant Objects";
        int id = books.add(title);
        assert books.title(id).equals(title);
    }

    @Test
    public void addsAndRetrievesThreads() throws ExecutionException, InterruptedException {
        Books books = new Books();
        int threads = 10;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        Collection<Future<Integer>> futures = new ArrayList<>(threads);
        for (int t = 0; t < threads; ++t) {
            final String title = String.format("Book #%d", t);
            futures.add(service.submit(() -> books.add(title)));
        }
        Set<Integer> ids = new HashSet<>();
        for (Future<Integer> f : futures) {
            ids.add(f.get());
        }
        assertThat(ids.size(), equalTo(threads));
    }

    @Test
    public void addsAndRetrievesThreadsStrict() throws ExecutionException, InterruptedException {
        Books books = new Books();
        int threads = 10;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        AtomicBoolean running = new AtomicBoolean();
        AtomicInteger overlaps = new AtomicInteger();
        Collection<Future<Integer>> futures = new ArrayList<>(threads);

        for (int t = 0; t < threads; ++t) {
            final String title = String.format("Book #%d", t);

            futures.add(
                    service.submit(
                            () -> {
                                if (running.get()) {
                                    overlaps.incrementAndGet();
                                }
                                running.set(true);
                                int id = books.add(title);
                                running.set(false);
                                return id;
                            }
                    )
            );

        }
        assertThat(overlaps.get(), greaterThan(0));
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        Books books = new Books();
        int threads = 10;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        CountDownLatch latch = new CountDownLatch(1);
        AtomicBoolean running = new AtomicBoolean();
        AtomicInteger overlaps = new AtomicInteger();
        Collection<Future<Integer>> futures =
                new ArrayList<>(threads);
        for (int t = 0; t < threads; ++t) {
            final String title = String.format("Book #%d", t);
            futures.add(
                    service.submit(
                            () -> {
                                latch.await();
                                if (running.get()) {
                                    overlaps.incrementAndGet();
                                }
                                running.set(true);
                                int id = books.add(title);
                                running.set(false);
                                return id;
                            }
                    )
            );
        }
        latch.countDown();
        Set<Integer> ids = new HashSet<>();
        for (Future<Integer> f : futures) {
            ids.add(f.get());
        }
        assertThat(overlaps.get(), greaterThan(0));
    }


    @Test
    public void addsAndRetrieves4() {
        Books books = new Books();
        MatcherAssert.assertThat(
                new Func<AtomicInteger, Boolean>() {
                    @Override
                    public Boolean apply(AtomicInteger t) throws Exception {
                        String title = String.format(
                                "Book #%d", t.getAndIncrement()
                        );
                        int id = books.add(title);
                        return books.title(id).equals(title);
                    }
                },
                new RunsInThreads<>(new AtomicInteger(), 10)
        );
    }
}