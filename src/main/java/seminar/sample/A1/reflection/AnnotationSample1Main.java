package seminar.sample.A1.reflection;

public class AnnotationSample1Main {

  public class TestCar extends Car {
    // @Overrideのアノテーションで、コンパイラにオーバーライドしていることを伝えられる
    @Override
    public String getName() {
      return "TEST " + super.getName();
    }
  }
}
