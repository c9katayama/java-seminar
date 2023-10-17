package seminar.sample.C1.hash_equals;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashAndEqualsTest {
  // hashcode/equals実装無し
  public static class A {
    public String value;

    public A(String value) {
      this.value = value;
    }
  }
  // hashcode/equals実装あり(Stringに処理を移譲)
  public static class B {
    public String value;

    public B(String value) {
      this.value = value;
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof B) {
        return ((B) obj).value.equals(this.value);
      } else {
        return false;
      }
    }
  }

  public static void main2(String[] args) {
    Set<Object> set = new LinkedHashSet<>();
    set.add(new A("hoge"));
    set.add(new A("hoge"));
    set.add(new B("hoge"));
    set.add(new B("hoge"));
    System.out.println("size:" + set.size());
    for (Object o : set) {
      System.out.println(o.getClass().getSimpleName());
    }
  }

  public static void main(String[] args) {
    Map<Object, String> map = new LinkedHashMap<>();
    map.put(new A("hoge"), "foo1");
    map.put(new A("hoge"), "foo2");
    map.put(new B("hoge"), "foo3");
    map.put(new B("hoge"), "foo4");
    System.out.println("size:" + map.size());
    for (Entry<Object, String> o : map.entrySet()) {
      System.out.println(o.getValue());
    }
  }
}
