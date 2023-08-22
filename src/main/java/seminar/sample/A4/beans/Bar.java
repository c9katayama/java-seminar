package seminar.sample.A4.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bar {

  @Autowired
  private Foo foo;

  public Foo getFoo() {
    return foo;
  }

  public void setFoo(Foo foo) {
    this.foo = foo;
  }
}
