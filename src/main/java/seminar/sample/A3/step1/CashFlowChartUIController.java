package seminar.sample.A3.step1;

import seminar.sample.A2.step5.CashFlowChartBuilder;
import seminar.sample.util.Utils;

public class CashFlowChartUIController {

  private CashFlowChartBuilder cashFlowChartBuilder;

  public CashFlowChartUIController(CashFlowChartBuilder cashFlowChartBuilder) {
    this.cashFlowChartBuilder = cashFlowChartBuilder;
  }

  public byte[] handleRequest(Request request) throws Exception {
    int fromAge = request.getParameterAsInt("fromAge");
    int toAge = request.getParameterAsInt("toAge");
    int gender = request.getParameterAsInt("gender");
    // キャッシュフロー計算とチャート作成
    String imageFilePath = cashFlowChartBuilder.createCashFlowChart(fromAge, toAge, gender);
    // 生成した画像データ読み込み
    byte[] imageData = Utils.readBytes(imageFilePath);

    return imageData;
  }
}
