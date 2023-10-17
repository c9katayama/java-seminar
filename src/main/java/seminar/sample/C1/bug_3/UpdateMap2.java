package seminar.sample.C1.bug_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import seminar.sample.util.Utils;

public class UpdateMap2 {

  public static void main(String[] args) {
    new UpdateMap2().sample();
  }

  Map<String, String> cacheMap = new ConcurrentHashMap<>();

  public void sample() {
    // 値を更新するスレッド
    Thread updateThread = new Thread() {
      public void run() {
        while (true) {
          cacheMap.put(String.valueOf(System.currentTimeMillis()),"");
          Utils.sleep(10);
        }
      };
    };
    updateThread.start();
    Thread read = new Thread() {
      public void run() {
        while (true) {
          for(Entry<String, String> e:cacheMap.entrySet()) {
            System.out.println(e.getKey());
          }
          Utils.sleep(10);
        }
      };
    };
    read.start();
  }

}
