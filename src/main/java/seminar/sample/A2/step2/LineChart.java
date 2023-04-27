package seminar.sample.A2.step2;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.awt.image.BufferedImage;

public class LineChart {

  public BufferedImage drawChart(int[] data) {
    // チャートを描画
    BufferedImage image = new BufferedImage(100, 100, TYPE_INT_ARGB);
    for (int i = 0; i < data.length; i++) {
      // チャートに線を描画
    }
    return image;
  }
}
