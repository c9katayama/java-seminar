package seminar.sample.A3.step4;

public class Sample {

  @Cacheable(cacheName = "hogeCache")
  public String hoge(String key) {
    return key + System.currentTimeMillis();
  }
}
