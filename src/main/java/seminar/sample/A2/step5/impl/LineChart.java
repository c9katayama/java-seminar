package seminar.sample.A2.step5.impl;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.awt.image.BufferedImage;
import seminar.sample.A2.step5.IChart;

public class LineChart implements IChart {
  private int width;
  private int height;

  public LineChart(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public BufferedImage drawChart(int[] data) {
    // チャートを描画
    BufferedImage image = new BufferedImage(width, height, TYPE_INT_ARGB);
    for (int i = 0; i < data.length; i++) {
      // チャートに線を描画
    }
    return image;
  }
}
