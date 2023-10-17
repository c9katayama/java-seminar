package seminar.sample.A4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.io.ClassPathResource;
import seminar.sample.A4.beans.Foo;
import seminar.sample.A4.beans.Hoge;

public class BeanFactorySampleMain {

  public static void main(String[] args) {
    // 標準実装されたBeanFactoryをインスタンス化
    // このクラスはBeanFactoryとBeanDefinitionRegistryインターフェースを持っている
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // XMLに書かれた定義を読み込んで、BeanDefinitionRegistryにBeanDefinitionを登録するs
    XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
    xmlReader.loadBeanDefinitions(new ClassPathResource("bean-config.xml"));
    // semiar.sample.A4パッケージ以下をスキャンして@Componentのついたクラスを登録
    ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
    scanner.scan("seminar.sample.A4");

    // BeanFactoryインターフェース経由でオブジェクトが取得できる
    Hoge hoge = beanFactory.getBean(Hoge.class);
    System.out.println(hoge.getValue());
    Foo foo = beanFactory.getBean(Foo.class);
    System.out.println(foo.getFoo());
  }
}
