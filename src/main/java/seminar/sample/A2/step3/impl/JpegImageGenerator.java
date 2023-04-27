package seminar.sample.A2.step3.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import seminar.sample.A2.step3.IImageGenerator;

public class JpegImageGenerator implements IImageGenerator {

  @Override
  public String generate(BufferedImage image) throws IOException {
    // 画像生成
    File imageFile = new File("c://incomeChart.jpg");
    ImageIO.write(image, "jpeg", imageFile);
    return imageFile.getAbsolutePath();
  }
}
