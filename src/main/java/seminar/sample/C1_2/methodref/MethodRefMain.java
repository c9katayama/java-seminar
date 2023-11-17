package seminar.sample.C1_2.methodref;

import java.util.Arrays;
import java.util.List;

public class MethodRefMain {

  public static void main(String[] args) {
    new MethodRefMain().execute();
  }

  public void execute() {

    List<String> strings = Arrays.asList("hello", "world");

    // 大文字にしてからフィルターして標準出力する
    strings.stream().map(s -> s.toUpperCase()).filter(s -> this.applyFilter(s))
        .forEach(s -> System.out.println(s));

    // メソッド参照演算子を利用
    strings.stream().map(String::toUpperCase).filter(this::applyFilter)
        .forEach(System.out::println);
  }

  public boolean applyFilter(String value) {
    return value.startsWith("H");
  }
}
