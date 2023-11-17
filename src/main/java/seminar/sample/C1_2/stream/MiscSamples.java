package seminar.sample.C1_2.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MiscSamples {

  public static class Person {
    String name;
    Integer age;
    BigDecimal asset;

    public Person(String name, Integer age, BigDecimal asset) {
      this.name = name;
      this.age = age;
      this.asset = asset;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  //@formatter:off
  public static void main(String[] args) {
    List<Person> personList = 
        Arrays.asList(
            new Person("yamada", 10, new BigDecimal("1000")),
            new Person("sato", 20, new BigDecimal("2000")),
            new Person("suzuki", 15, new BigDecimal("3000")));
    {
      // 金融資産合計
      BigDecimal result =
          personList.stream().map(p -> p.asset).reduce(BigDecimal.ZERO, BigDecimal::add);
      System.out.println(result);
    }
    {
      // 15才以上の人の金融資産合計
      BigDecimal result = personList.stream().filter(p -> p.age >= 15).map(p -> p.asset)
          .reduce(BigDecimal.ZERO, BigDecimal::add);
      System.out.println(result);
    }
    {
      // 金融資産1500万円以上の名前のリスト(年齢若い順)
      final BigDecimal thresholdAmount = new BigDecimal("1500");
      String result = personList.stream().filter(p -> p.asset.compareTo(thresholdAmount) >= 0)
          .map(p -> p.name).collect(Collectors.joining("\n"));
      System.out.println(result);
    }
    {
      // 全員の名前リスト(カンマ区切り)
      String result = personList.stream().map(p -> p.name).collect(Collectors.joining(","));
      System.out.println(result);
    }
  }
}
