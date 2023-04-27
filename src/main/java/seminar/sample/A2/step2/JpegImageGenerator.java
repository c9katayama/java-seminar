package seminar.sample.A2.step2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JpegImageGenerator {

  public String generate(BufferedImage image) throws IOException {
    // 画像生成
    File imageFile = new File("c://incomeChart.jpg");
    ImageIO.write(image, "jpeg", imageFile);
    return imageFile.getAbsolutePath();
  }
}
