package seminar.sample.A1.reflection;

import java.lang.reflect.Field;
import java.time.LocalDate;

/**
 * リクレクションを使って、インスタンスから値を取得するサンプル
 * 
 * @author yaman
 *
 */
public class ReflectionSample3Main {
  public static void main(String[] args) throws Exception {
    // Personをインスタンス化
    Person person = new Person();
    person.name = "katayama";
    person.age = 46;
    person.birthDay = LocalDate.of(1977, 2, 20);

    // Classクラスを取得(Person.classと同じ)
    Class personClass = person.getClass();
    // "age"のFieldクラスを取得
    Field ageFiels = personClass.getField("age");
    // Fielsクラスを使って、personインスタンスからageの値を取得
    int ageValue = (int) ageFiels.get(person);
    System.out.println(ageValue);
  }
}
