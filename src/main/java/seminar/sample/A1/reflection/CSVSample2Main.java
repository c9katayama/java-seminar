package seminar.sample.A1.reflection;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVSample2Main {

  public static void main(String[] args) throws Exception {
    Person person = new Person();
    person.name = "Yamada";
    person.age = 20;
    person.birthDay = LocalDate.of(2002, 1, 1);

    String csv = new CSVSample2Main().toCSV(person);
    System.out.println(csv);
  }

  public String toCSV(Object target) throws Exception {
    StringBuilder csv = new StringBuilder();
    // フィールドを取得
    Field[] fields = getFieldsForCSV(target);
    // CSVヘッダーを追加
    for (int i = 0; i < fields.length; i++) {
      if (i != 0) {
        csv.append(",");
      }
      Field field = fields[i];
      csv.append(field.getName());// フィールド名=ヘッダーの値
    }
    csv.append("\n");
    // CSVデータを追加
    for (int i = 0; i < fields.length; i++) {
      if (i != 0) {
        csv.append(",");
      }
      Field field = fields[i];
      Object value = field.get(target);
      csv.append(value.toString());// フィールドのデータ
    }
    return csv.toString();
  }

  private Field[] getFieldsForCSV(Object target) {
    Field[] fields = target.getClass().getFields();
    List<Field> targetFieldList = new ArrayList<>();
    for (Field field : fields) {
      // Ignoreアノテーションがついていたら無視する
      Ignore annotation = field.getAnnotation(Ignore.class);
      if (annotation == null) {
        targetFieldList.add(field);
      }
    }
    return targetFieldList.toArray(new Field[] {});
  }
}
