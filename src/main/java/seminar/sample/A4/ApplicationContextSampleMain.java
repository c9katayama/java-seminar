package seminar.sample.A4;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import seminar.sample.A4.beans.Foo;
import seminar.sample.A4.beans.Hoge;

public class ApplicationContextSampleMain {

  public static void main(String[] args) {

    // 汎用的なApplicationContextをインスタンス化
    // このApplicationContextは、自分では管理対象のオブジェクトの定義(BeanDefinition)を読み込まない。
    // BeanDefinitionRegistryインターフェース経由でオブジェクト定義を追加してもらう
    GenericApplicationContext ctx = new GenericApplicationContext();

    // XMLに書かれた定義を読み込んで、BeanDefinitionRegistryにBeanDefinitionを登録するs
    XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
    xmlReader.loadBeanDefinitions(new ClassPathResource("my-spring-app-context.xml"));
    // semiar.sample.A4パッケージ以下をスキャンして@Componentのついたクラスを登録
    ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(ctx);
    scanner.scan("seminar.sample.A4");

    // BeanDefinition登録完了後に、ApplicationContextをリロード
    ctx.refresh();

    // オブジェクトが取得できる
    Hoge hoge = ctx.getBean(Hoge.class);
    System.out.println(hoge.getValue());
    Foo foo = ctx.getBean(Foo.class);
    System.out.println(foo.getFoo());
  }
}
