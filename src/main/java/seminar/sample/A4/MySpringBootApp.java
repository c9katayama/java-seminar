package seminar.sample.A4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MySpringBootApp {

  public static void main(String[] args) {
    SpringApplication.run(MySpringBootApp.class, args);
  }

  @RestController
  public static class IndexController {
    @GetMapping("/index")
    public String index() {
      return "hoge";
    }
  }

}

