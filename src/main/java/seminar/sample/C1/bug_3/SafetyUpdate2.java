package seminar.sample.C1.bug_3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class SafetyUpdate2 {

  public static void main(String[] args) {
    new SafetyUpdate2().sample();
  }

  Map<String, String> cacheMap = new ConcurrentHashMap<>();

  // 値を生成する関数
  public class CreateValueFunc implements BiFunction<String, String, String> {
    @Override
    public String apply(String key, String value) {
      if (value == null) {
        // 値がない場合は、値を生成
        value = String.valueOf(System.currentTimeMillis());
      }
      return value;
    }
  }

  public void sample() {
    // マルチスレッドで実行
    IntStream.range(0, 1000).parallel().forEach(i -> {
      String key = "hoge";
      String value = getValue(key);
      System.out.println(value);
    });
  }

  public String getValue(String key) {
    CreateValueFunc func = new CreateValueFunc();
    String value = cacheMap.compute(key, func);
    return value;
  }
}
