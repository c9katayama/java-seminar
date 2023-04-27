package seminar.sample.A1.reflection;

import java.time.LocalDate;

public class Person2 {

  public String name;
  // @IgnoreでCSV出力しなことを伝える
  @Ignore
  public int age;
  public LocalDate birthDay;

}
