package hu.flowacademy;

import java.util.concurrent.atomic.AtomicLong;

public class Main3 {
  public static void main(String[] args) throws InterruptedException {
    AtomicLong counter = new AtomicLong(0);
    while (!counter.compareAndSet(15, 30)){
      Logging.logInfo("Az érték: " + counter.get());
      counter.incrementAndGet();
      Logging.logInfo("Eggyel megnöveltem az értéket");
      Thread.sleep(300);
    }
    Logging.logInfo("A végső érték: " + counter.get());
  }
}
