package hu.flowacademy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Runnable myRunnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("Execution started");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Execution finished");
      }
    };
    ExecutorService exec = Executors.newFixedThreadPool(1);
    Future futureValue = exec.submit(myRunnable);
    while (!futureValue.isDone()) {
      System.out.println("We're waiting");
      Thread.sleep(100);
    }
    System.out.println("We are done");
    exec.shutdown();
  }
}
/**
        * Exercise 1:
        * Implement a Runnable what does the following:
        *  - logs a line that the execution is started
        *  - Waits for 1 sec
        *  - logs a line that the execution is finished
        *
        *  1) Use ExecutorService and lambda in Runnable definition,
        *  After starting the runnable, wait for the result using isDone of the appropriate Future object,
        *  2) do this waiting in loop where:
        *      - log a line that you are waiting, then
        *      - sleep 100 ms
        *  3) Finally log a line that the execution is done.
        *  4) Do not forget to shutdown the executor service!
        */