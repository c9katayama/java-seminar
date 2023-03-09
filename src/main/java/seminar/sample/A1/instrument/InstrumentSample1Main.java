package seminar.sample.A1.instrument;

/**
 * VM argumentに -javaagent:build/libs/java-seminar.jar を設定してから実行
 */
public class InstrumentSample1Main {

  public static void main(String[] args) {
    InstrumentSample1Main sample = new InstrumentSample1Main();
    sample.hoge();
    sample.foo();
  }

  public void hoge() {
    System.out.println("!!!!!hogeメソッド処理!!!!!");
  }

  public void foo() {
    System.out.println("!!!!!fooメソッド処理!!!!!");
  }
}
