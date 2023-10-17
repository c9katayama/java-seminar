package seminar.sample.C1;

import java.util.Iterator;

public class IterableSample {

  // Iterableの実装
  public static class MyIterable implements Iterable<String> {
    String[] stringArray = {"a", "b"};

    @Override
    public Iterator<String> iterator() {
      return new MyIterator(stringArray);
    }
  }

  // Iteratorの実装
  public static class MyIterator implements Iterator<String> {
    String[] array;
    int i;

    public MyIterator(String[] array) {
      this.array = array;
      this.i = 0;
    }

    @Override
    public boolean hasNext() {
      // 配列長よりもindexが少なければOK
      // for(int i = 0;i < stringArray.length;i++)と等価
      if (i < array.length) {
        return true;
      }
      return false;
    }

    @Override
    public String next() {
      String value = array[i];
      i++;
      return value;
    }
  }

  public static void main(String[] args) {
    MyIterable iterable = new MyIterable();
    // forループ
    for (String s : iterable) {
      System.out.println(s);
    }

    // forループの実装
    Iterator<String> iterator = iterable.iterator();
    while (iterator.hasNext()) {
      String s = iterator.next();
      System.out.println(s);
    }
  }
}
