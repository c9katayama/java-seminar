package seminar.sample.A2.step1;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

@SuppressWarnings("unused")
public class CashFlowChartBuilder {

  public String createCashFlowChart(int fromAge, int toAge, int genger) throws Exception {
    int term = toAge - fromAge;
    // 年収計算
    int[] jobIncome = new int[term];
    File incomeStatisticData = new File("c://incomeStatistic.csv");
    for (int i = 0; i < term; i++) {
      // 年収曲線から、将来給与曲線を計算
    }
    // チャートを描画
    BufferedImage image = new BufferedImage(100, 100, TYPE_INT_ARGB);
    for (int i = 0; i < term; i++) {
      // チャートに線を描画
    }
    // 画像生成
    File imageFile = new File("c://incomeChart.jpg");
    ImageIO.write(image, "jpeg", imageFile);
    return imageFile.getAbsolutePath();
  }
}
