package seminar.sample.C1.bug_3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class SafetyUpdate2_1 {

  public static void main(String[] args) {
    new SafetyUpdate2_1().sample();
  }

  Map<String, String> cacheMap = new ConcurrentHashMap<>();

  public void sample() {
    // マルチスレッドで実行
    IntStream.range(0, 1000).parallel().forEach(i -> {
      String key = "hoge";
      String value = getValue(key);
      System.out.println(value);
    });
  }

  public String getValue(String key) {
    String value = cacheMap.compute(key, (k, v) -> {
      if (v == null) {
        // 値がない場合は、値を生成
        v = String.valueOf(System.currentTimeMillis());
      }
      return v;
    });
    return value;
  }
}
