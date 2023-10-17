package seminar.sample.C1.bug_3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class SafetyUpdate3_1 {

  public static void main(String[] args) {
    new SafetyUpdate3_1().sample();
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
    // computeIfAbsentは、keyに対する値がない時だけfuncを呼び出す
    String value = cacheMap.computeIfAbsent(key, (v) -> {
      return String.valueOf(System.currentTimeMillis());
    });
    return value;
  }
}
