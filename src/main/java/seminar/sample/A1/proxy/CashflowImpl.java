package seminar.sample.A1.proxy;

import java.io.File;
import seminar.sample.A1.reflection.Person;
import seminar.sample.util.Utils;

/**
 * Cashflowの実装クラス(ファイルベースで保存/取得する)
 * 
 * @author yaman
 *
 */
public class CashflowImpl implements Cashflow {
  @Override
  public int[] getCashflow(Person person) {
    return Utils.readIntArrayFromFile(new File(person.name));
  }

  @Override
  public void saveCashflow(Person person, int[] cashflow) {
    String csv = Utils.toCSV(cashflow);
    File file = new File(person.name);
    Utils.writeToFile(file, csv);
  }
}
