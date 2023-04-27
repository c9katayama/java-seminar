package seminar.sample.A2.step2;

import java.awt.image.BufferedImage;

public class CashFlowChartBuilder {

  public String createCashFlowChart(int fromAge, int toAge, int gender) throws Exception {
    // 年収計算
    CAPJobIncomeCalc calc = new CAPJobIncomeCalc();
    int[] jobIncome = calc.calcIndome(fromAge, toAge, gender);
    // チャートを描画
    LineChart chart = new LineChart();
    BufferedImage image = chart.drawChart(jobIncome);
    // 画像生成
    JpegImageGenerator imageGenerator = new JpegImageGenerator();
    String filePath = imageGenerator.generate(image);
    return filePath;
  }
}
