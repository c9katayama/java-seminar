package seminar.sample.C3;

public class MyThreadApp {

  public static void main(String[] args) throws Exception {
    useThread();
    useRunnable();
    useLambda();
  }

  public static void useThread() {
    Thread thread = new Thread() {
      @Override
      public void run() {
        System.out.println("thread");
      }
    };
    thread.start();
  }

  public static void useRunnable() {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("runnable");
      }
    };
    Thread thread = new Thread(runnable);
    thread.start();
  }

  public static void useLambda() {
    Thread thread = new Thread(() -> System.out.println("lambda"));
    thread.start();
  }

}
