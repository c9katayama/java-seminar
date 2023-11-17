package seminar.sample.C1_2.filter;

@FunctionalInterface
public interface Filter {

  /**
   * フィルターを通過させる場合はtrue、させない場合はfalseを返します
   */
  boolean isPass(String value);
}
