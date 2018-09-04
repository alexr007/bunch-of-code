package stack.exec;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecTest {
    public static void main(String[] args)  {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable writer = new Runnable() {
            public void run() {
                for (int i=1; i<20; i++) {
                    System.out.print(" "+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }
        };
        long timeout = 2500;
        executor.scheduleWithFixedDelay(writer,0, timeout, TimeUnit.MILLISECONDS);
        //executor.scheduleAtFixedRate(writer,0, timeout, TimeUnit.MILLISECONDS);
        //executor.schedule(writer, timeout, TimeUnit.MILLISECONDS);
/*
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("wait fow input");
            if (scanner.hasNext()) {
                String next = scanner.nextLine();
                if (next.equals("S")) {
                    executor.awaitTermination(2L, TimeUnit.SECONDS);
                    break;
                }
                if (next.equals("Q")) {
                    System.exit(0);
                }
            }
        }
*/
    }
}
