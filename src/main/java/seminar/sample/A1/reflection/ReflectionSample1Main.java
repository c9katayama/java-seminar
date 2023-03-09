package seminar.sample.A1.reflection;

import java.lang.reflect.Field;

public class ReflectionSample1Main {

  public static void main(String[] args) {
    //Class クラスを取得
    Class<Person> c = Person.class;
    //publicフィールドを取得
    Field[] fields = c.getFields();
    for (Field field : fields) {
      System.out.println(field.getName());
    }
  }
}
