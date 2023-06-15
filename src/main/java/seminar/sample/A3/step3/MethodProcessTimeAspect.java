package seminar.sample.A3.step3;

import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import seminar.sample.A3.step2.PerformanceMonitor;

@Aspect
public class MethodProcessTimeAspect {

  private PerformanceMonitor performanceMonitor;

  public MethodProcessTimeAspect(PerformanceMonitor performanceMonitor) {
    this.performanceMonitor = performanceMonitor;
  }

  @Around("execution(* seminar.sample.A3..*(..))") // seminar.sample.A3パッケージ内が対象
  public Object logProcessTime(ProceedingJoinPoint joinPoint) throws Throwable {
    // 処理開始を記録
    long startTime = System.nanoTime();

    // 対象のメソッド呼び出しを実行
    Object result = joinPoint.proceed();

    // 処理時間を計算して記録
    long processTime = System.nanoTime() - startTime;
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Method method = methodSignature.getMethod();
    performanceMonitor.recordProcessTime(method, processTime);
    return result;
  }
}


