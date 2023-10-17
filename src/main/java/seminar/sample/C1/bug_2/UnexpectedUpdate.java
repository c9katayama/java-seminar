package seminar.sample.C1.bug_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import seminar.sample.util.Utils;

public class UnexpectedUpdate {

  public static void main(String[] args) {
    new UnexpectedUpdate().sample();
  }

  public static class ValueListUpdator {
    private List<Integer> intList = new ArrayList<>();
    Thread updateThread;

    public ValueListUpdator() {
      // 値を更新するスレッド
      updateThread = new Thread() {
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
    }

    public List<Integer> getIntList() {
      return Collections.unmodifiableList(intList);
    }
  }

  public void sample() {
    ValueListUpdator valueListUpdator = new ValueListUpdator();
    // リストから値を読むスレッド
    Thread listThread = new Thread() {
      @Override
      public void run() {
        while (true) {
          List<Integer> list = valueListUpdator.getIntList();
          for (Integer i : list) {// listからIteratorを取得
            System.out.println(i);
          }
          Utils.sleep(10);
        }
      }
    };
    listThread.start();
  }
}
