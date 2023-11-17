package seminar.sample.C1_2.mylambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaSample {

  List<String> stringList;

  public void init() {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {// 0から9までをlistに足す
      list.add(String.valueOf(i));
    }
    this.stringList = Collections.unmodifiableList(list);
  }

  public List<String> getStringList() {
    return stringList;
  }

  public static void main(String[] args) {
    new LambdaSample().sample();
  }

  public void sample() {
    init();
    // 文字列リストの内容を数値に変えて、3以上の数字をカンマ区切りにする
    beforeJava8();
    streamApiAndLambdaFunction();
    streamApiAndLambdaFunctionDetail();
  }

  public void beforeJava8() {
    List<String> stringList = getStringList();// 元のリスト
    List<Integer> intList = new ArrayList<>();
    // 文字列リストの内容を数値に変える
    for (String s : stringList) {
      Integer intValue = Integer.valueOf(s);
      intList.add(intValue);
    }
    // 3以上の数字だけ残す
    List<Integer> filteredIntList = new ArrayList<>();
    for (Integer i : intList) {
      if (i >= 3) {
        filteredIntList.add(i);
      }
    }
    // カンマ区切りにする
    StringBuilder csv = new StringBuilder();
    for (int i = 0; i < filteredIntList.size(); i++) {
      Integer intValue = filteredIntList.get(i);
      if (csv.length() != 0) {
        csv.append(",");
      }
      csv.append(String.valueOf(intValue));
    }
    System.out.println(csv.toString());
  }

  public void streamApiAndLambdaFunction() {
    List<String> stringList = getStringList();
    String csv = stringList.stream()// streamAPIの開始
        .map(s -> Integer.valueOf(s))// 文字列をIntegerに変換
        .filter(i -> i >= 3)// 3以上の数値だけにフィルターする
        .map(s -> String.valueOf(s))// Integerを文字列に変換
        .collect(Collectors.joining(","));// カンマで連結する
    System.out.println(csv);
  }

  public void streamApiAndLambdaFunctionDetail() {
    List<String> stringList = getStringList();
    Stream<String> stream = stringList.stream();// streamAPIの開始
    Stream<Integer> map = stream.map(s -> Integer.valueOf(s));// 文字列をIntegerに変換
    Stream<Integer> filter = map.filter(i -> i >= 3);// 3以上の数値だけにフィルターする
    Stream<String> map2 = filter.map(s -> String.valueOf(s));// Integerを文字列に変換
    Collector<CharSequence, ?, String> joinFunction = Collectors.joining(",");// カンマで連結する関数
    String csv = map2.collect(joinFunction);// 連結する
    System.out.println(csv);
  }

  public void streamApiAndLambdaFunctionDetail2() {
    List<String> stringList = getStringList();
    Stream<String> stream = stringList.stream();// streamAPIの開始

    Stream<Integer> map = stream.map(new Function<>() {
      @Override
      public Integer apply(String t) {
        return Integer.valueOf(t);// 文字列をIntegerに変換
      }
    });

    Stream<Integer> filter = map.filter(new Predicate<>() {
      @Override
      public boolean test(Integer i) {
        return (i >= 3);// 3以上の数値だけにフィルターする
      };
    });

    Stream<String> map2 = filter.map(new Function<>() {
      @Override
      public String apply(Integer t) {
        return String.valueOf(t);// 文字列をIntegerに変換
      }
    });

    Collector<CharSequence, ?, String> joinFunction = Collectors.joining(",");// カンマで連結する関数
    String csv = map2.collect(joinFunction);// 連結する
    System.out.println(csv);
  }

}
