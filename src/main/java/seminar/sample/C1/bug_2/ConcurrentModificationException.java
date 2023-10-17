package seminar.sample.C1.bug_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import seminar.sample.util.Utils;

public class ConcurrentModificationException {

  public static void main(String[] args) {
    new ConcurrentModificationException().test();
  }

  // 対象のList
  List<Integer> intList = Collections.synchronizedList(new ArrayList<>());

  public void test() {
    // 値を更新するスレッド
    Thread updateThread = new Thread() {
      public void run() {
        while (true) {
          for (int i = 0; i < 100; i++) {
            intList.add(i, i);
          }
          Utils.sleep(10);
        }
      };
    };
    updateThread.start();

    // リストから値を読むスレッド
    Thread listThread = new Thread() {
      @Override
      public void run() {
        while (true) {
          for (Integer i : intList) {// listからIteratorを取得
            System.out.println(i);
          }
          Utils.sleep(10);
        }
      }
    };
    listThread.start();
  }
}
