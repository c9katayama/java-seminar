package seminar.sample.A2.step4;

import seminar.sample.A2.step3.IChart;
import seminar.sample.A2.step3.IImageGenerator;
import seminar.sample.A2.step3.IJobIncomeCalc;
import seminar.sample.A2.step3.impl.CAPJobIncomeCalc;
import seminar.sample.A2.step3.impl.JpegImageGenerator;
import seminar.sample.A2.step3.impl.LineChart;

public class Main {

  public static void main(String[] args) throws Exception {

    IJobIncomeCalc calc = new CAPJobIncomeCalc();
    IChart chart = new LineChart();
    IImageGenerator imageGenerator = new JpegImageGenerator();

    // 依存性を注入
    CashFlowChartBuilder builder = new CashFlowChartBuilder(calc, chart, imageGenerator);

    int fromAge = 20;
    int toAge = 40;
    int gender = 1;

    String chartFile = builder.createCashFlowChart(fromAge, toAge, gender);
  }
}

