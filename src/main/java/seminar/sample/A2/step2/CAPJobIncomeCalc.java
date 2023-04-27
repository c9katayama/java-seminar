package seminar.sample.A2.step2;

import java.io.File;

@SuppressWarnings("unused")
public class CAPJobIncomeCalc {

  private File incomeStatisticData = new File("c://incomeStatistic.csv");

  public int[] calcIndome(int fromAge, int toAge, int gender) {
    int term = toAge - fromAge;
    // 年収計算
    int[] jobIncome = new int[term];
    for (int i = 0; i < term; i++) {
      // 年収曲線から、将来給与曲線を計算
    }
    return jobIncome;
  }
}
