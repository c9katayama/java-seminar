package seminar.sample.C2;

public class JoinSample {

  public static void main(String[] args) throws Exception {

    Thread thread = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 10000000; i++) {
        }
        System.out.println("スレッド終了");
      }
    };
    thread.start();

    thread.join();

    System.out.println("main終了");
  }
}
