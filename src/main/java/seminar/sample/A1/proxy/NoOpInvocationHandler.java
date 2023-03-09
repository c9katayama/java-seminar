package seminar.sample.A1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 何も処理をしないInvocationHandler
 * 
 * @author yaman
 *
 */
public class NoOpInvocationHandler implements InvocationHandler {
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return null;
  }
}
