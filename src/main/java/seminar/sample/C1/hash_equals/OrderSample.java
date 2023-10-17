package seminar.sample.C1.hash_equals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import seminar.sample.C1.hash_equals.HashAndEqualsTest.A;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class OrderSample {

  public void unstableOrder(Set set) {
    // 順序が不確定なので、順序が必要な場合は自分でソートする
    List list = new ArrayList(set);
    Collections.sort(list);// ソート
    for (Object o : list) {
      // 処理
    }
  }

  public void stableOrder(LinkedHashSet set) {
    // 順序が確定しているので意図通りの処理ができる
    for (Object o : set) {
      // 処理
    }
  }

  public void useStringAsKey() {
    {
      Set<Object> set = new HashSet<>();
      set.add(new A("hoge"));
      set.add(new A("hoge"));
      System.out.println("size:" + set.size());
      for (Object o : set) {
        System.out.println(o.getClass().getSimpleName());
      }
    }
    {
      Map<String, Object> set = new HashMap<>();
      {
        A a = new A("hoge");
        set.put(a.value, a);
      }
      {
        A a = new A("hoge");
        set.put(a.value, a);
      }
      System.out.println("size:" + set.size());
      for (Object o : set.values()) {
        System.out.println(o.getClass().getSimpleName());
      }
    }
  }
}
