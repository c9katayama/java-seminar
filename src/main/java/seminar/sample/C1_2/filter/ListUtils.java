package seminar.sample.C1_2.filter;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
  /**
   * 引数のリストにFilterを適用して、新しいリストを返す
   */
  public static List<String> applyFilter(List<String> baseList, Filter filter) {
    List<String> newList = new ArrayList<>();
    for (String value : baseList) {
      // filterを通過したものだけ新しいListに追加
      if (filter.isPass(value) == true) {
        newList.add(value);
      }
    }
    return newList;
  }
}
