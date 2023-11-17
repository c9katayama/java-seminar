package seminar.sample.C1_2.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lambda {
  
  @SuppressWarnings("unused")
  //@formatter:offs
  public static void main(String[] args) {
    {
      List<String> names = List.of("Alice", "Bob", "Charlie", "David");

      // Listにする
      List<String> list = names.stream().collect(Collectors.toList());
      // Setにする
      Set<String> set = names.stream().collect(Collectors.toSet());
      // Mapにする(キーは文字、値は文字の長さ）
      Map<String, Integer> map = names.stream()
          .collect(
              Collectors.toMap(
                  (name) -> name, // キー値を決めるラムダ式
                   (name) -> name.length()// 値を決めるラムダ式
      ));
      // 文字を繋げる
      String text = names.stream().collect(Collectors.joining());
      // カンマ区切りにする
      String csv = names.stream().collect(Collectors.joining(","));
      // []で囲ったカンマ区切りにする
      String csv2 = names.stream().collect(Collectors.joining(",", "[", "]"));

      System.out.println("list: " + list);
      System.out.println("set: " + set);
      System.out.println("map: " + map);
      System.out.println("csv: " + csv);
      System.out.println("csv2: " + csv2);
    }
  }
}
