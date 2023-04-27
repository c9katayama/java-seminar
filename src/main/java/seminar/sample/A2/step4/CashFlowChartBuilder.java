package seminar.sample.A2.step4;

import java.awt.image.BufferedImage;
import seminar.sample.A2.step3.IChart;
import seminar.sample.A2.step3.IImageGenerator;
import seminar.sample.A2.step3.IJobIncomeCalc;

public class CashFlowChartBuilder {

  private IJobIncomeCalc calc;
  private IChart chart;
  private IImageGenerator imageGenerator;

  public CashFlowChartBuilder(IJobIncomeCalc calc, IChart chart, IImageGenerator imageGenerator) {
    this.calc = calc;
    this.chart = chart;
    this.imageGenerator = imageGenerator;
  }

  public String createCashFlowChart(int fromAge, int toAge, int gender) throws Exception {
    // 年収計算
    int[] jobIncome = calc.calcIndome(fromAge, toAge, gender);
    // チャートを描画
    BufferedImage image = chart.drawChart(jobIncome);
    // 画像生成
    String filePath = imageGenerator.generate(image);
    return filePath;
  }
}

