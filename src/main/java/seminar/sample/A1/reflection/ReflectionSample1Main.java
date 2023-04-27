package seminar.sample.A1.reflection;

import java.lang.reflect.Field;

/**
 * リクレクション利用のサンプル(publicフィールドを取得）
 * 
 * @author yaman
 *
 */
public class ReflectionSample1Main {

  public static void main(String[] args) {
    // Class クラスを取得
    Class<Person> c = Person.class;
    // publicフィールドを全て取得
    Field[] fields = c.getFields();
    for (Field field : fields) {
      System.out.println(field.getName());
    }
  }
}
