package seminar.sample.C3.guava;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import lombok.SneakyThrows;

@SuppressWarnings("unused")
public class CacheSample {

	public static void main(String[] args) {
		CacheSample samples = new CacheSample();
		samples.cacheSample();
	}

	@SneakyThrows
	public void cacheSample() {
		CacheLoader<String, BigDecimal> cacheLoader = new CacheLoader<String, BigDecimal>() {
			@Override
			public BigDecimal load(String key) {
				// キャッシュされる値をロード
				return new BigDecimal(System.currentTimeMillis());
			}
		};
		// 最大で100エントリを持ち、値をキャッシュしてから5秒で消すLoadingCache
		LoadingCache<String, BigDecimal> cache = CacheBuilder.newBuilder().maximumSize(100)
				.expireAfterWrite(5, TimeUnit.SECONDS).build(cacheLoader);

		BigDecimal cacheValue = cache.get("hoge");

		for (int i = 0; i < 200; i++) {
			BigDecimal bigDecimal = cache.get("hoge");
			System.out.println(bigDecimal.toPlainString());
			Thread.sleep(100);
		}
	}
}
