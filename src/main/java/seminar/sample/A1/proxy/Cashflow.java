package seminar.sample.A1.proxy;

import seminar.sample.A1.reflection.Person;

/**
 * サンプルのインターフェース
 * 
 * @author yaman
 *
 */
public interface Cashflow {

  int[] getCashflow(Person person);

  void saveCashflow(Person person, int[] cashflow);

}
