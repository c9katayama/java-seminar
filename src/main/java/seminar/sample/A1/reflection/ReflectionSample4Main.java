package seminar.sample.A1.reflection;

import java.lang.reflect.Method;

/**
 * リクレクション利用のサンプル(publicメソッドを取得して、メソッド呼び出し）
 * 
 * @author yaman
 *
 */
public class ReflectionSample4Main {
  public static void main(String[] args) throws Exception {
    // Carをインスタンス化
    Car car = new Car();
    car.setName("カローラ");
    car.setColor("白");
    car.setCompany("トヨタ");

    // Classクラスを取得
    Class carClass = car.getClass();
    // "getColor"のMethodクラスを取得
    Method colorMethod = carClass.getMethod("getColor");
    // Methodクラスを使って、carのgetColor()を呼び出し
    String colorValue = (String) colorMethod.invoke(car);
    System.out.println(colorValue);
  }
}
