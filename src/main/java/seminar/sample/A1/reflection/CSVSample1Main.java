package seminar.sample.A1.reflection;

import java.time.LocalDate;

/**
 * CSVを作成するサンプル(Personクラスにしか使えない実装)
 * 
 * @author yaman
 *
 */
public class CSVSample1Main {

  public static void main(String[] args) {
    Person person = new Person();
    person.name = "Yamada";
    person.age = 20;
    person.birthDay = LocalDate.of(2002, 1, 1);

    String csv = new CSVSample1Main().toCSV(person);
    System.out.println(csv);
  }

  public String toCSV(Person person) {
    StringBuilder csv = new StringBuilder();
    csv.append("name,age,birthDay" + "\n");
    csv.append(person.name + "," + person.age + "," + person.birthDay);
    return csv.toString();
  }
}
