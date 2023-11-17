package seminar.sample.C1_2.filter;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<String> testList = new ArrayList<>();
    testList.add("Apple");
    testList.add("Beer");
    testList.add("Cookie");

    // "A"から始まる値だけにする
    List<String> resultList 
      = ListUtils.applyFilter(testList, (value) -> value.startsWith("A"));

    for (String value : resultList) {
      System.out.println(value);
    }

    resultList.forEach((value) -> System.out.println(value));

    resultList.forEach(System.out::println);
    
    

  }
}
