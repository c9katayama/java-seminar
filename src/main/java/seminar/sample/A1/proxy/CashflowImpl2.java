package seminar.sample.A1.proxy;

import java.io.File;
import seminar.sample.A1.reflection.Person;
import seminar.sample.util.Logger;
import seminar.sample.util.Utils;

/**
 * CashflowImplにログ出力を追加したもの
 * 
 * @author yaman
 *
 */
public class CashflowImpl2 implements Cashflow {
  @Override
  public int[] getCashflow(Person person) {
    Logger.info("getCashflow input", person);
    int[] value = Utils.readIntArrayFromFile(new File(person.name));
    Logger.info("getCashflow output", value);
    return value;
  }

  @Override
  public void saveCashflow(Person person, int[] cashflow) {
    Logger.info("saveCashflow input", person, cashflow);
    String csv = Utils.toCSV(cashflow);
    File file = new File(person.name);
    Utils.writeToFile(file, csv);
    Logger.info("saveCashflow output");
  }
}
