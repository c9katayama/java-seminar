package seminar.sample.A2.step6;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DIContainer {

  public DIContainer(String configFile) {
    init(configFile);
  }

  private void init(String configFile) {
    InputStream is = DIContainer.class.getResourceAsStream(configFile);
    Gson gson = new Gson();
    JsonObject fromJson = gson.fromJson(new InputStreamReader(is), JsonObject.class);
    fromJson.entrySet().forEach((e) -> {
      JsonObject asJsonObject = e.getValue().getAsJsonObject();
      beanConfigMap.put(e.getKey(), asJsonObject);
    });

  }

  private Map<String, JsonObject> beanConfigMap = new ConcurrentHashMap<>();
  private Map<String, Object> beanInstanceMap = new ConcurrentHashMap<>();

  public <T> T getBean(Class<T> clazz) {
    return getBean(clazz.getSimpleName());
  }

  private static final String CONFIG_CLASS = "class";
  private static final String CONFIG_AUTOWIRED = "autoWired";
  private static final String CONFIG_CONSTRUCTOR_ARG_PREFIX = "constructor-arg";

  public <T> T getBean(String beanName) {
    Object bean = beanInstanceMap.computeIfAbsent(beanName, (n) -> createBeanInstance(n));
    return (T) bean;
  }

  private Object createBeanInstance(String beanName) {
    JsonObject config = beanConfigMap.get(beanName);
    if (config == null) {
      return null;
    } else {
      try {
        // クラス/コンストラクタ情報取得
        Class<?> clazz = Class.forName(config.get(CONFIG_CLASS).getAsString());
        Constructor<?> constructor = clazz.getConstructors()[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] params = new Object[parameterTypes.length];
        // auto wiredするかどうか
        boolean autoWired = config.get(CONFIG_AUTOWIRED) == null ? false
            : config.get(CONFIG_AUTOWIRED).getAsBoolean();
        if (autoWired == true) {
          // 型に従って実装クラスを取得
          for (int i = 0; i < params.length; i++) {
            params[i] = getBean(parameterTypes[i]);
          }
        } else {
          // 設定からコンストラクタのパラメータ取得
          for (int i = 0; i < params.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            String configValue = config.get(CONFIG_CONSTRUCTOR_ARG_PREFIX + i).getAsString();
            params[i] = toParameterValue(configValue, parameterType);
          }
        }
        return constructor.newInstance(params);
      } catch (Exception e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }
  }

  private Object toParameterValue(String configValue, Class<?> parameterType) {
    if (parameterType.equals(Integer.class) || parameterType.equals(int.class)) {
      return Integer.parseInt(configValue);
    } else if (parameterType.equals(File.class)) {
      return new File(configValue);
    } else {
      throw new IllegalStateException("unsupported param:" + parameterType.toString());
    }
  }
}
