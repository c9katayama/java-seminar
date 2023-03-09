package seminar.sample.A1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import seminar.sample.util.Logger;

/**
 * ログ出力を行うInvocationHandler
 * 
 * @author yaman
 *
 */
public class LoggingInvocationHandler implements InvocationHandler {

  private Object targetObject;

  public LoggingInvocationHandler(Object targetObject) {
    this.targetObject = targetObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // ログ出力(入力)
    Logger.info(method.getName() + " input", args);
    // 実際に処理を行うクラスのメソッドを呼び出す
    Object result = method.invoke(targetObject, args);
    // ログ出力(出力)
    Logger.info(method.getName() + " output", result);
    return result;
  }
}
