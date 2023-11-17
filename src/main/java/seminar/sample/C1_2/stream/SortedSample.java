package seminar.sample.C1_2.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedSample {

  //@formatter:off
  public static void main(String[] args) {
    {
      // 文字列リスト
      List<String> list = Arrays.asList("A", "C", "B");

      List<String> flatList = list.stream().sorted().collect(Collectors.toList());

      System.out.println(flatList); // [A, B, C]
    }
    {
      List<String> list = Arrays.asList("A", "C", "B");

      List<String> flatList =
          list.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

      System.out.println(flatList); // [C, B, A]
    }
    {
      List<String> list = Arrays.asList("A", "C", "B");

      List<String> flatList =
          list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

      System.out.println(flatList); // [C, B, A]
    }
    {
      List<Person> list =
          Arrays.asList(
              new Person("yamada", 10), 
              new Person("sato", 20), 
              new Person("suzuki", 15));

      List<Person> flatList =
          list.stream().sorted(Comparator.comparingInt(p -> p.age)).
          collect(Collectors.toList());

      System.out.println(flatList); // [yamada, suzuki, sato]
    }
  }

  public static class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return name;
    }
  }
}
