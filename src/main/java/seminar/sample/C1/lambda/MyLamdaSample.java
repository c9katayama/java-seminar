package seminar.sample.C1.lambda;

import java.util.Collections;

public class MyLamdaSample {


  public interface MyLambdaFunction {
    // ラムダ式用のFunctionはメソッドが1つだけ
    String hoge(Integer value);
  }

  public void invokeFunction(MyLambdaFunction function) {
    String s = function.hoge(1);
    System.out.println(s);
  }


  public static void main(String[] args) {
    MyLamdaSample sample = new MyLamdaSample();
    {
      // 匿名クラスを作成するパターン
      MyLambdaFunction function = new MyLambdaFunction() {
        @Override
        public String hoge(Integer value) {
          return value + "hoge";
        }
      };
      sample.invokeFunction(function);
    }
    {
      // 匿名クラスを直接作成するパターン
      sample.invokeFunction(new MyLambdaFunction() {
        @Override
        public String hoge(Integer value) {
          return value + "hoge";
        }
      });
    }
    {
      // ラムダ式
      sample.invokeFunction((value) -> value + "hoge");
    }
    {
      // ラムダ式（複数行）
      sample.invokeFunction((value) -> {
        String str = value + "hoge";
        return str;
      });
    }
  }
}
