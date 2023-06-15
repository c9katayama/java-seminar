package seminar.sample.A3.step2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;

public class PerformanceMonitor {

  public void recordProcessTime(Method method, long time) {
    String className = method.getDeclaringClass().getName();
    String methodName = method.getName();
    String fileName = className + "#" + methodName + "#" + System.nanoTime();
    File file = new File(fileName);
    try {
      Files.write(file.toPath(), String.valueOf(time).getBytes());
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }
}
