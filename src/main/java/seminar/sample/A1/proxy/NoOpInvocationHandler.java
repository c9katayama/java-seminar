package seminar.sample.A1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NoOpInvocationHandler implements InvocationHandler {
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return null;
  }
}
