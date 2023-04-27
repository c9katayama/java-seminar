package seminar.sample.A2.step3;

import java.awt.image.BufferedImage;
import seminar.sample.A2.step3.impl.CAPJobIncomeCalc;
import seminar.sample.A2.step3.impl.JpegImageGenerator;
import seminar.sample.A2.step3.impl.LineChart;

public class CashFlowChartBuilder {

  public String createCashFlowChart(int fromAge, int toAge, int gender) throws Exception {
    // 年収計算
    IJobIncomeCalc calc = new CAPJobIncomeCalc();
    int[] jobIncome = calc.calcIndome(fromAge, toAge, gender);
    // チャートを描画
    IChart chart = new LineChart();
    BufferedImage image = chart.drawChart(jobIncome);
    // 画像生成
    IImageGenerator imageGenerator = new JpegImageGenerator();
    String filePath = imageGenerator.generate(image);
    return filePath;
  }
}
