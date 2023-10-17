package seminar.sample.C1.bug_2;

import java.util.ArrayList;
import java.util.List;
import seminar.sample.util.Utils;

public class SafetyUpdate1 {

  public static void main(String[] args) {
    new SafetyUpdate1().test();
  }

  // 対象のList
  List<Integer> intList = new ArrayList<>();

  public void test() {
    // 値を更新するスレッド
    Thread updateThread = new Thread() {
      public void run() {
        while (true) {
          // 新しいリストを準備
          List<Integer> newList = new ArrayList<>();
          for (int i = 0; i < 100; i++) {
            newList.add(i);
          }
          intList = newList; // 差し替え
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
