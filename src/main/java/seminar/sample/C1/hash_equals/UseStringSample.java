package seminar.sample.C1.hash_equals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import seminar.sample.C1.hash_equals.HashAndEqualsTest.A;

public class UseStringSample {

  public static void main(String[] args) {
    {
      Set<Object> set = new HashSet<>();
      set.add(new A("hoge"));
      set.add(new A("hoge"));
      System.out.println("size:" + set.size());
    }
    {
      Map<String, Object> set = new HashMap<>();

      A a = new A("hoge");
      set.put(a.value, a);

      A aa = new A("hoge");
      set.put(aa.value, aa);

      System.out.println("size:" + set.size());
    }
  }
}
