package seminar.sample.A1.proxy;

import java.lang.reflect.Proxy;
import seminar.sample.A1.reflection.Person;

public class CashflowProxySample1Main {

  public static void main(String[] args) throws Exception {
    Cashflow cashFlowImpl = new CashflowImpl();

    Cashflow cashflow = (Cashflow) Proxy.newProxyInstance(Cashflow.class.getClassLoader(),
        new Class[] {Cashflow.class}, new LoggingInvocationHandler(cashFlowImpl));

    Person person = new Person();
    person.name = "katayama";
    cashflow.getCashflow(person);
  }
}
