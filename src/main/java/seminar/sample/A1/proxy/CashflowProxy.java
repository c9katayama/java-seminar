package seminar.sample.A1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import seminar.sample.A1.reflection.Person;

/**
 * Proxyによって作られる、Cashflowを実装してInvocationHandlerに処理を渡すクラスのイメージ実装
 * 
 * @author yaman
 *
 */
public class CashflowProxy implements Cashflow {

  private InvocationHandler invocationHandler;

  public CashflowProxy(InvocationHandler invocationHandler) {
    this.invocationHandler = invocationHandler;
  }

  @Override
  public int[] getCashflow(Person person) {
    try {
      Method method = Cashflow.class.getMethod("getCashflow", new Class[] {Person.class});
      Object result = invocationHandler.invoke(this, method, new Object[] {person});
      return (int[]) result;
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void saveCashflow(Person person, int[] cashflow) {
    try {
      Method method =
          Cashflow.class.getMethod("saveCashflow", new Class[] {Person.class, int[].class});
      invocationHandler.invoke(this, method, new Object[] {person, cashflow});
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
