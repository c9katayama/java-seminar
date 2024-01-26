package seminar.sample.C3;

import java.util.ArrayList;
import java.util.List;


public class ThreadSaveSample {

  public static void main(String[] args) throws Exception {

    List<String> resultList = new ArrayList<>();
    List<Thread> threadList = new ArrayList<>();
    // スレッドを10000個つくる
    for (int i = 0; i < 10000; i++) {
      Thread thread = new Thread() {
        @Override
        public void run() {
          resultList.add(this.getName());
        }
      };
      threadList.add(thread);
    }

    for (Thread t : threadList) {
      t.start();// 全てのスレッドを開始
    }
    for (Thread t : threadList) {
      t.join();// 全てのスレッドの終了を待つ
    }
    System.out.println(resultList.size());
  }
}
