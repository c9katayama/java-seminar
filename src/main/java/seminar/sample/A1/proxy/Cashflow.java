package seminar.sample.A1.proxy;

import seminar.sample.A1.reflection.Person;

public interface Cashflow {

  int[] getCashflow(Person person);

  void saveCashflow(Person person, int[] cashflow);

}
