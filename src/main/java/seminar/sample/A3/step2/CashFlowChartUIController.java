package seminar.sample.A3.step2;

import java.lang.reflect.Method;
import seminar.sample.A2.step5.CashFlowChartBuilder;
import seminar.sample.A3.step1.Request;
import seminar.sample.util.Utils;

public class CashFlowChartUIController {

  private CashFlowChartBuilder cashFlowChartBuilder;
  private PerformanceMonitor performanceMonitor;

  public CashFlowChartUIController(CashFlowChartBuilder cashFlowChartBuilder,
      PerformanceMonitor performanceMonitor) {
    this.cashFlowChartBuilder = cashFlowChartBuilder;
    this.performanceMonitor = performanceMonitor;
  }

  public byte[] handleRequest(Request request) throws Exception {
    // 処理開始を記録
    long startTime = System.nanoTime();

    int fromAge = request.getParameterAsInt("fromAge");
    int toAge = request.getParameterAsInt("toAge");
    int gender = request.getParameterAsInt("gender");
    // キャッシュフロー計算とチャート作成
    String imageFilePath = cashFlowChartBuilder.createCashFlowChart(fromAge, toAge, gender);
    // 生成した画像データ読み込み
    byte[] imageData = Utils.readBytes(imageFilePath);

    // 処理時間を計算して記録
    long processTime = System.nanoTime() - startTime;
    Method method = getClass().getMethod("handleRequest", Request.class);
    performanceMonitor.recordProcessTime(method, processTime);

    return imageData;
  }
}
