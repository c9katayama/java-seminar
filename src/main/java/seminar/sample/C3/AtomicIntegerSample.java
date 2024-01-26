package seminar.sample.C3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerSample {

  public static void main(String[] args) throws Exception {
    AtomicIntegerSample sample = new AtomicIntegerSample();
    sample.counter();
  }

  int counter = 0;

  public void counter() throws Exception {

    ExecutorService threadPool = Executors.newFixedThreadPool(4);
    AtomicInteger atomicCounter = new AtomicInteger();
    for (int i = 0; i < 10000; i++) {
      // カウンターに1を足す
      threadPool.execute(() -> {
        counter++;
        atomicCounter.incrementAndGet();
      });
    }
    threadPool.shutdown();
    threadPool.awaitTermination(Integer.MAX_VALUE, TimeUnit.MINUTES);

    System.out.println("counter:" + counter);
    System.out.println("atomicCounter:" + atomicCounter.get());
  }
}
