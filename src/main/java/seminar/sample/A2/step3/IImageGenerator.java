package seminar.sample.A2.step3;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface IImageGenerator {

  String generate(BufferedImage image) throws IOException;
}
