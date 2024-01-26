package seminar.sample.C3;

public class InterruptSample {

  public static void main(String[] args) throws Exception {

    Thread thread = new Thread() {
      @Override
      public void run() {
        // interrupt()が呼ばれるまでループ
        while (!Thread.currentThread().isInterrupted()) {
          System.out.println(System.currentTimeMillis());
        }
      }
    };

    thread.start();

    // 1秒停止後にinterrupt()を呼ぶ
    Thread.sleep(1000);
    thread.interrupt();
  }
}
