package seminar.sample.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Logger {

  public static void info(String log, Object... value) {
    List<String> values = new ArrayList<>();
    if (value != null) {
      for (int i = 0; i < value.length; i++) {
        if (value[i] == null) {
          values.add("null");
        } else {
          values.add(Utils.toJson(value));
        }
      }
    }
    System.out.println(log + " " + values.stream().collect(Collectors.joining(",")));
  }
}
