package hu.flowacademy;

import java.sql.Time;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {
  public static void main(String[] args) throws InterruptedException {
    final AtomicInteger counter = new AtomicInteger(0);

    Runnable myRunnable2 = () -> {
      Logging.logLine("I'm running");
      counter.incrementAndGet();
    };
    ScheduledExecutorService scheduledExec = Executors.newSingleThreadScheduledExecutor();
    scheduledExec.scheduleAtFixedRate(myRunnable2, 0L, 1L, TimeUnit.SECONDS);
    while (counter.get() < 10){
      System.out.println("A számláló " + counter.get() + " ismétlésnél jár");
      Thread.sleep(100);
    }
    scheduledExec.shutdown();
    System.out.println(counter.get());
    }
  }

/**
 * Exercise 2:
 * Implement a logic what:
 * - runs periodically - 1 every second
 * - prints out a message, then
 * - increments a counter (defined outside)
 *
 * The main thread checks the number of the executions in every 100ms, writes a message and stops after 10 repetitions.
 * Use scheduled executor without initial delay.
 * Use AtomicInteger for the counter.
 *
 * Hint: use scheduleAtFixedRate and final AtomicInteger external variable to store the number of runs.
 * Do not forget to shutdown the executor!
 */