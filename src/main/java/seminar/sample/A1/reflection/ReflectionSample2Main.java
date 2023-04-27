package seminar.sample.A1.reflection;

import java.lang.reflect.Field;

/**
 * リクレクション利用のサンプル(privateフィールド含めて取得）
 * 
 * @author yaman
 *
 */
public class ReflectionSample2Main {

  public static void main(String[] args) {
    // Class クラスを取得
    Class<Car> c = Car.class;
    // フィールドを取得
    Field[] fields = c.getDeclaredFields();
    for (Field field : fields) {
      System.out.println(field.getName());
    }
  }
}
