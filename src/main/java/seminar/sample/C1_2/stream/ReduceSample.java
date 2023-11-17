package seminar.sample.C1_2.stream;

import java.math.BigDecimal;
import java.util.List;

public class ReduceSample {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    {
      List<BigDecimal> values =
          List.of(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"));

      // 全部足す
      BigDecimal total = values.parallelStream().reduce(BigDecimal.ZERO, (base, value) -> base.add(value));
      
      System.out.println(total);// 6
    }
    {
      List<BigDecimal> values =
          List.of(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"));

      BigDecimal base = BigDecimal.ZERO;
      for (BigDecimal value : values) {
        base = base.add(value);
      }
      BigDecimal total = base;

    }
  }
}
