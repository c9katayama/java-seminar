package seminar.sample.C1.bug_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Update {

  public static void main(String[] args) {
    new Update().sample();
  }

  Map<String, String> cacheMap = Collections.synchronizedMap(new HashMap<>());

  public void sample() {
    // マルチスレッドで実行
    IntStream.range(0, 1000).parallel().forEach(i -> {

      String key = "hoge";
      String value = getValue(key);
      System.out.println(value);

    });
  }

  public String getValue(String key) {
    String value = cacheMap.get(key);
    if (value == null) {
      // 値がない場合は、値を生成
      value = String.valueOf(System.currentTimeMillis());
      System.out.println("put key:" + key + " value:" + value);
      // Mapにセット
      cacheMap.put(key, value);
    }
    return value;
  }
}
