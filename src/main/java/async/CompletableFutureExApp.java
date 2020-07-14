package async;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureExApp {

  static class Person {
    public final int age;
    public final String name;

    Person(int age, String name) {
      this.age = age;
      this.name = name;
    }

    @Override
    public String toString() {
      return String.format("Person[age=%d, name='%s']", age, name);
    }
  }

  static Supplier<Double> foreverDots(long millis) {
    return  () -> {
        System.out.printf("Dot printer... started in thread: %s\n", Thread.currentThread().getName());
        int i = 0;
        while (++i < 25) {
          if (Thread.interrupted()) {
            System.out.println("INTERRUPTED");
            break;
          }
          System.out.print(".");
          try {
            TimeUnit.MILLISECONDS.sleep(millis);
          } catch (InterruptedException e) {
            throw new IllegalStateException("Somebody Interrupted me", e);
          }
        }
        return Math.PI;
    };
  }

  static Supplier<String> nameFetcher(long millis) {
    return () -> {
      try {
        System.out.printf("Name Fetcher... started in thread: %s\n", Thread.currentThread().getName());
        Thread.sleep(millis);
        System.out.println("Name Fetcher... finished");
        return "Alex";
      } catch (InterruptedException e) {
        throw new IllegalStateException("name fetcher INTERRUPTED", e);
      }
    };
  }

  static Supplier<Integer> ageFetcher(long millis) {
    return () -> {
      try {
        System.out.printf("Age Fetcher... started in thread: %s\n", Thread.currentThread().getName());
        Thread.sleep(millis);
        System.out.println("Age Fetcher... finished");
        return 33;
      } catch (InterruptedException e) {
        throw new IllegalStateException("name fetcher INTERRUPTED", e);
      }
    };
  }

  static CompletableFuture<Person> personFetcher(ExecutorService ex) {
    CompletableFuture<String> cf_name = CompletableFuture.supplyAsync(nameFetcher(3000), ex);
    CompletableFuture<Integer> cf_age = CompletableFuture.supplyAsync(ageFetcher(2000), ex);
    return cf_age.thenCombine(cf_name, (age, name) -> new Person(age, name));
  }



  public static <T> CompletableFuture<T> supplyAsyncInterruptibly(Supplier<T> supplier, Executor executor) {
    return produceInterruptibleCompletableFuture((s) -> CompletableFuture.supplyAsync(s, executor), supplier);
  }

  // in case we want to do the same for similar methods later
  private static <T> CompletableFuture<T> produceInterruptibleCompletableFuture(
      Function<Supplier<T>, CompletableFuture<T>> completableFutureAsyncSupplier, Supplier<T> action) {

    FutureTask<T> task = new FutureTask<>(action::get);
    return addCancellationAction(completableFutureAsyncSupplier.apply(asSupplier(task)), () ->
        task.cancel(true));
  }

  /**
   * Ensures the specified action is executed if the given {@link CompletableFuture} is cancelled.
   */
  public static <T> CompletableFuture<T> addCancellationAction(CompletableFuture<T> completableFuture, Runnable onCancellationAction) {
    completableFuture.whenComplete((result, throwable) -> {
      if (completableFuture.isCancelled()) {
        onCancellationAction.run();
      }
    });
    return completableFuture;  // return original CompletableFuture
  }

  public static <T> Supplier<T> asSupplier(RunnableFuture<T> futureTask) throws CompletionException {
    return () -> {
      try {
        futureTask.run();
        try {
          return futureTask.get();
        } catch (ExecutionException e) {  // unwrap ExecutionExceptions
          final Throwable cause = e.getCause();
          throw (cause != null) ? cause : e;
        }
      } catch (CompletionException e) {
        throw e;
      } catch (Throwable t) {
        throw new CompletionException(t);
      }
    };
  }

  public static void main(String[] args) {
    ExecutorService ex = Executors.newFixedThreadPool(10);
    CompletableFuture<Double> cf_foreverDots = supplyAsyncInterruptibly(foreverDots(200), ex);
    personFetcher(ex).thenAccept(System.out::println).join();

    cf_foreverDots.cancel(true);
//    cf_foreverDots.completeExceptionally(new InterruptedException());

    String cause =
        cf_foreverDots.isCancelled()              ? "cancelled" :
        cf_foreverDots.isCompletedExceptionally() ? "exception" :
                                                    "success";

    System.out.println(cause);
    ex.shutdown();
  }
}
