package seminar.sample.C2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsSample {

  public static void main(String[] args) throws Exception {
    newScheduledThreadPool();
  }

  public static void newScheduledThreadPool() throws InterruptedException {

    ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(1);

    // 10秒後に実行
    scheduledPool.schedule(() -> System.out.println("10秒後"), 10, TimeUnit.SECONDS);
    // 10秒ごとに実行
    scheduledPool.scheduleAtFixedRate(() -> System.out.println("10秒ごと"), 0, 10, TimeUnit.SECONDS);
    // 10秒おきに実行(前のタスクが終わってから10秒後に次のタスク)
    scheduledPool.scheduleWithFixedDelay(() -> System.out.println("10秒おき"), 0, 10,
        TimeUnit.SECONDS);
  }

}
