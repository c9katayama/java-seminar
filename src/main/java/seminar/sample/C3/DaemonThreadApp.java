package seminar.sample.C3;

public class DaemonThreadApp {

  public static class MyThread extends Thread {
    @Override
    public void run() {
      while (true) {
        System.out.println(getName());
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Thread thread = new MyThread();
    thread.setDaemon(true);
    thread.start();

    // thread.join();
  }
}
