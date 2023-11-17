package seminar.sample.C1_2.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctSample {

  //@formatter:off
  public static void main(String[] args) {
    {
      List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

      List<Integer> distinctNumbers = numbers.stream()
                                             .distinct()
                                             .collect(Collectors.toList());

      System.out.println(distinctNumbers); // [1, 2, 3, 4, 5]
    }

  }
}
