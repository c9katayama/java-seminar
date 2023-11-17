package seminar.sample.C1_2.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapSample {

  //@formatter:off
  public static void main(String[] args) {
    // 2次元のリスト
    List<List<String>> listOfLists = 
        Arrays.asList(Arrays.asList("apple", "banana"),
        Arrays.asList("cherry", "date"), 
        Arrays.asList("elderberry", "fig"));

    // flatMapを使用して1つのリストに変換
    List<String> flatList = 
        listOfLists.stream().flatMap(list->list.stream()).collect(Collectors.toList());

    System.out.println(flatList); // [apple, banana, cherry, date, elderberry, fig]
  }
}
