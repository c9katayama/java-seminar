package seminar.sample.C3.guava;

import java.util.ArrayList;
import java.util.List;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimitterSample {

	public static void main(String[] args) throws Exception {
		multiThreadSample();

		// 秒間に1回まで処理を許可するRateLimiterを作成
		RateLimiter rateLimiter = RateLimiter.create(1.0);
		for (int i = 0; i < 1000; i++) {
			rateLimiter.acquire();
			System.out.println("処理中" + i);
		}

		System.exit(0);
	}

	public static void multiThreadSample() {
		// 秒間に3回まで処理を許可するRateLimiterを作成
		RateLimiter rateLimiter = RateLimiter.create(3);
		// 処理対象のリストを作成
		List<String> list = createProcessList();
		list.parallelStream().forEach(i -> {
			rateLimiter.acquire();
			System.out.println("処理中" + i);
		});
	}

	private static List<String> createProcessList() {
		return new ArrayList();
	}
}
