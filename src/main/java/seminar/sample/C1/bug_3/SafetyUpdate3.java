package seminar.sample.C1.bug_3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SafetyUpdate3 {

  public static void main(String[] args) {
    new SafetyUpdate3().sample();
  }

  Map<String, String> cacheMap = new ConcurrentHashMap<>();

  // 値を生成する関数
  public class CreateValueFunc implements Function<String, String> {
    @Override
    public String apply(String key) {
      // 値を生成
      String value = String.valueOf(System.currentTimeMillis());
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
    // computeIfAbsentは、keyに対する値がない時だけfuncを呼び出す
    String value = cacheMap.computeIfAbsent(key, func);
    return value;
  }
}
