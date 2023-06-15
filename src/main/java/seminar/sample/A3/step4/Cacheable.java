package seminar.sample.A3.step4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * キャッシュ機能をつけたいメソッドに付与するアノテーション
 * 
 * @author yaman
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cacheable {

  String cacheName();
}

