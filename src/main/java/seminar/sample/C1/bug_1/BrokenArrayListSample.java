package seminar.sample.C1.bug_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BrokenArrayListSample {

  public static void main(String[] args) {
    List<Integer> intList = new ArrayList<>();
    // 0から999までの数をマルチスレッドでaddする
    IntStream.range(0, 1000).parallel().forEach(i -> {
      intList.add(i);
    });
    System.out.println(intList.size());
  }
}
