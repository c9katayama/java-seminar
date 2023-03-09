package seminar.sample.A1.reflection;

import java.lang.reflect.Field;

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
