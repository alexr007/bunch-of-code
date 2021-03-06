package async.completablefuture.j8.exception;

import util.QuoteUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenApplyException {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuoteUtil quoteUtil = new QuoteUtil();

        try {
            CompletableFuture
                    .supplyAsync(quoteUtil::emptyQuote, executor)
                    .thenApply(String::length)
                    .thenAccept(System.out::println)
                    .get();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
