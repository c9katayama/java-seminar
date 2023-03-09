package seminar.sample.A1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import seminar.sample.A1.reflection.Person;

/**
 * Proxyによってログ出力を追加するサンプル
 * 
 * @author yaman
 *
 */
public class LoggingProxySample1Main {

  public static void main(String[] args) {
    // 実装されているクラス
    Cashflow cashflowImpl = new CashflowImpl();

    ClassLoader cl = Cashflow.class.getClassLoader();
    Class[] ifs = new Class[] {Cashflow.class};// インターフェース
    // ログを出力し、CashflowImplを呼び出すためのInvocationHandler
    InvocationHandler handler = new LoggingInvocationHandler(cashflowImpl);
    // ProxyによってCashflowを実装したインスタンスを生成
    Cashflow cashflow = (Cashflow) Proxy.newProxyInstance(cl, ifs, handler);

    Person person = new Person();
    person.name = "katayama";
    int[] result = cashflow.getCashflow(person);
    cashflow.saveCashflow(person, result);
  }

}
