package seminar.sample.A1.instrument;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * premainで、全メソッドの前後にSystem.out.println()を追加するAgentサンプル
 * 
 * @author yaman
 *
 */
public class InstrumentAgent {
  // mainメソッドの前に呼び出される
  public static void premain(String agentArgs, Instrumentation instrumentation) {
    instrumentation.addTransformer(new SampleClassFileTransformer());
  }

  // classファイルから読み込まれたデータにコードを埋め込む
  public static class SampleClassFileTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
        ProtectionDomain protectionDomain, byte[] classFileData)
        throws IllegalClassFormatException {
      try {
        ByteArrayInputStream stream = new ByteArrayInputStream(classFileData);
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass(stream);
        CtMethod[] methods = ctClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
          CtMethod ctMethod = methods[i];
          if (ctMethod.isEmpty()) {
            continue;// abstract method
          }
          try {
            // すべてのメソッドの最初と最後の行に処理を追加
            String classNameAndMethodName = ctClass.getSimpleName() + "." + ctMethod.getName();
            ctMethod
                .insertBefore("System.out.println(\"" + classNameAndMethodName + " の呼び出し開始\");");
            ctMethod.insertAfter("System.out.println(\"" + classNameAndMethodName + " の呼び出し終了\");");
          } catch (Throwable e) {
          }
        }
        // 処理追加後のバイトコードを返す
        return ctClass.toBytecode();
      } catch (Throwable e) {
      }
      return classFileData;
    }
  }
}
