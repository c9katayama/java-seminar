package seminar.sample.C3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsSample {

  public static void main(String[] args) throws Exception {
    // newFixedThreadPoolSample();
    newFixedThreadPoolSample2();
  }

  public static void newFixedThreadPoolSample() throws InterruptedException {

    List<String> keys = List.of("1", "2", "3", "4");
    // 2スレッドのプールを作成
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    for (String key : keys) {
      Runnable runnable = new Runnable() {
        public void run() {
          System.out.println(key);
        };
      };
      // Runnableを登録
      threadPool.execute(runnable);
    }

    // 処理をこれ以上受け付けなくする
    threadPool.shutdown();
    // 全ての処理処理完了まで待つ
    threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);

  }

  public static void newFixedThreadPoolSample2() throws InterruptedException, ExecutionException {

    List<String> keys = List.of("1", "2", "3", "4");
    // 2スレッドのプールを作成
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    List<Future<Integer>> resultList = new ArrayList<>();
    for (String key : keys) {
      Callable<Integer> callable = new Callable<>() {
        @Override
        public Integer call() throws Exception {
          return Integer.valueOf(key);
        }
      };
      // Callableを登録
      Future<Integer> result = threadPool.submit(callable);
      resultList.add(result);
    }
    // 結果を取得
    for (Future<Integer> result : resultList) {
      Integer n = result.get();
      System.out.println(n);
    }
    threadPool.shutdown();
  }
}
