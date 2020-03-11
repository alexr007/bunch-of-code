package concurrency;

import lombok.SneakyThrows;

public class TheProblemApp {

  static class Box {
    int value;
  }

  @SneakyThrows
  public static void main(String[] args)  {

    Box box = new Box();
    box.value = 1;

    {
      new Thread(new Runnable() {
        @SneakyThrows
        @Override
        public void run() {
          Thread.sleep(500);
          box.value = 42;
        }
      }).start();
      new Thread(new Runnable() {
        @SneakyThrows
        @Override
        public void run() {
          Thread.sleep(1500);
          box.value = 13;
        }
      }).start();
    }

    System.out.println(box.value);
    Thread.sleep(1000);
    System.out.println(box.value);
    Thread.sleep(1000);
    System.out.println(box.value);
  }
}
