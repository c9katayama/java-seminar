package seminar.sample.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;
import com.google.gson.Gson;

public class Utils {

  public static String toJson(Object o) {
    if (o == null) {
      return "null";
    } else {
      return new Gson().toJson(o);
    }
  }

  public static String toCSV(int[] values) {
    return Arrays.asList(values).stream().map(i -> String.valueOf(i))
        .collect(Collectors.joining(","));
  }

  public static void writeToFile(File file, String value) {
    try {
      Files.write(file.toPath(), value.getBytes());
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public static int[] readIntArrayFromFile(File file) {
    String line;
    try {
      line = String.valueOf(Files.readAllBytes(file.toPath()));
    } catch (IOException e) {
      return null;
    }
    return Arrays.asList(line.split(",")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
  }

  public static byte[] readBytes(String path) {
    try {
      return Files.readAllBytes(new File(path).toPath());
    } catch (IOException e) {
      throw new RuntimeException(path);
    }
  }
}
