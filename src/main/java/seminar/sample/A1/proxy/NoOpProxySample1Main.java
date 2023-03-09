package seminar.sample.A1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import seminar.sample.A1.reflection.Person;

public class NoOpProxySample1Main {

  public static void main(String[] args) {

    ClassLoader cl = Cashflow.class.getClassLoader();
    Class[] ifs = new Class[] {Cashflow.class};// インターフェース
    InvocationHandler handler = new NoOpInvocationHandler();
    // ProxyによってCashflowを実装したインスタンスを生成
    // インスタンスはできるが、実装は何もない
    Cashflow cashflow = (Cashflow) Proxy.newProxyInstance(cl, ifs, handler);

    Person person = new Person();
    person.name = "katayama";
    int[] result = cashflow.getCashflow(person);
    cashflow.saveCashflow(person, result);

  }
}
