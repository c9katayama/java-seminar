package seminar.sample.C1_2.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapSample {

  //@formatter:off
  public static void main(String[] args) {
    {
      // 文字列リスト
      List<String> list = Arrays.asList("apple", "banana", "cherry");

      // 大文字に変換
      List<String> flatList = list.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());

      System.out.println(flatList); // [APPLE, BANANA, CHERRY]
    }
    {
      // 文字列リスト
      List<String> list = Arrays.asList("1", "2", "3");

      // BigDecimalに変換
      List<BigDecimal> flatList =
          list.stream().map(s -> new BigDecimal(s)).collect(Collectors.toList());

      System.out.println(flatList); // [APPLE, BANANA, CHERRY]
    }
    {
      // 文字列リスト
      List<String> list = Arrays.asList("1", "2", "3");

      // BigDecimalに変換
      List<BigDecimal> flatList = 
          list.stream().map(BigDecimal::new).collect(Collectors.toList());

      System.out.println(flatList); // [APPLE, BANANA, CHERRY]
    }

  }
  
  public List<String> map() {
    List<String> list = Arrays.asList("apple", "banana", "cherry");
    List<String> newList = new ArrayList<>();
    for(String s : list) {
      newList.add(s.toLowerCase());      
    }
    return newList;
  }
} 
