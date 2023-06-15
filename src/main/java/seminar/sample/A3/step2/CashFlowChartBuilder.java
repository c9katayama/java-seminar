package seminar.sample.A3.step2;

import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import seminar.sample.A2.step5.IChart;
import seminar.sample.A2.step5.IImageGenerator;
import seminar.sample.A2.step5.IJobIncomeCalc;

public class CashFlowChartBuilder {

  private IJobIncomeCalc calc;
  private IChart chart;
  private IImageGenerator imageGenerator;
  private PerformanceMonitor performanceMonitor;

  public CashFlowChartBuilder(IJobIncomeCalc calc, IChart chart, IImageGenerator imageGenerator,
      PerformanceMonitor performanceMonitor) {
    this.calc = calc;
    this.chart = chart;
    this.imageGenerator = imageGenerator;
    this.performanceMonitor = performanceMonitor;
  }

  public String createCashFlowChart(int fromAge, int toAge, int gender) throws Exception {
    // 処理開始を記録
    long startTime = System.nanoTime();

    // 年収計算
    int[] jobIncome = calc.calcIndome(fromAge, toAge, gender);
    // チャートを描画
    BufferedImage image = chart.drawChart(jobIncome);
    // 画像生成
    String filePath = imageGenerator.generate(image);

    // 処理時間を計算して記録
    long processTime = System.nanoTime() - startTime;
    Method method =
        getClass().getMethod("createCashFlowChart", Integer.TYPE, Integer.TYPE, Integer.TYPE);
    performanceMonitor.recordProcessTime(method, processTime);

    return filePath;
  }
}

