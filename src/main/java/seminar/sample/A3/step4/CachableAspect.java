package seminar.sample.A3.step4;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class CachableAspect {

  private Map<String, Map<String, Object>> cacheMap = new ConcurrentHashMap<>();

  @Around("@annotation(seminar.sample.A3.step4.Cacheable)")
  public Object processCache(ProceedingJoinPoint joinPoint) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    // メソッドにつけられたアノテーションから、キャッシュ名を取得
    Cacheable annotation = methodSignature.getMethod().getAnnotation(Cacheable.class);
    String cacheName = annotation.cacheName();
    // キャッシュ名を元にキャッシュ用のMapを取得。なければ作成
    Map<String, Object> cache = cacheMap.computeIfAbsent(cacheName, (key) -> {
      return new ConcurrentHashMap<>();
    });
    // メソッド引数から、キャッシュ用のキーを取得
    String keyFromParams = Arrays.asList(methodSignature.getMethod().getParameters()).stream()
        .map(o -> o.toString()).collect(Collectors.joining("_"));
    // キャッシュ用のキーから、キャッシュを取得。なければメソッドを呼び出してキャッシュ用の値を生成
    Object cacheValue = cache.computeIfAbsent(keyFromParams, (key) -> {
      try {
        return joinPoint.proceed();
      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    });
    return cacheValue;
  }
}


