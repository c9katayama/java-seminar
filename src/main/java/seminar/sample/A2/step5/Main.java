package seminar.sample.A2.step5;

import java.io.File;
import seminar.sample.A2.step5.impl.CAPJobIncomeCalc;
import seminar.sample.A2.step5.impl.JpegImageGenerator;
import seminar.sample.A2.step5.impl.LineChart;

public class Main {

  public static void main(String[] args) throws Exception {
    File incomeStatisticData = new File("c://incomeStatistic.csv");
    File imageFile = new File("c://incomeChart.jpg");
    int imageWidth = 100;
    int imageHeight = 100;

    IJobIncomeCalc calc = new CAPJobIncomeCalc(incomeStatisticData);
    IChart chart = new LineChart(imageWidth, imageHeight);
    IImageGenerator imageGenerator = new JpegImageGenerator(imageFile);

    // 依存性を注入
    CashFlowChartBuilder builder = new CashFlowChartBuilder(calc, chart, imageGenerator);

    int fromAge = 20;
    int toAge = 40;
    int gender = 1;

    String chartFile = builder.createCashFlowChart(fromAge, toAge, gender);
  }
}

