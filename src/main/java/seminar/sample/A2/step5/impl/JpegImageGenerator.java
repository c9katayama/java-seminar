package seminar.sample.A2.step5.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import seminar.sample.A2.step5.IImageGenerator;;

public class JpegImageGenerator implements IImageGenerator {

  private File imageFile;

  public JpegImageGenerator(File imageFile) {
    this.imageFile = imageFile;
  }

  @Override
  public String generate(BufferedImage image) throws IOException {
    // 画像生成
    ImageIO.write(image, "jpeg", imageFile);
    return imageFile.getAbsolutePath();
  }
}
