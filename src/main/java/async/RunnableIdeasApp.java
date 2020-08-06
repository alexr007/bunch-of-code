package async;

import java.util.Arrays;

public class RunnableIdeasApp {

  public static void runAll(Runnable... body) {
    Arrays.stream(body).forEach(Runnable::run);
  }

  public static void main(String[] args) {
    var r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("1");
      }
    };

    var r2 = new Runnable() {
      @Override
      public void run() {
        System.out.println("1");
      }
    };

    runAll(r1, r2);
  }



}
