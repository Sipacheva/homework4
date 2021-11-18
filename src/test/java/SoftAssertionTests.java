import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionTests {
  static void beforeAll() {
    Configuration.startMaximized = true;
  }

  @Test
  void findSoftAssertions(){
    // открыть страницу Selenide в Github
    open("https://github.com/selenide/selenide");
    // перейти в раздел Wiki проекта
    $("#wiki-tab").click();
    // убедиться, что в списке страниц (Pages) есть страница SoftAssertions, открыть страницу SoftAssertions
    $("#wiki-pages-box").$(byText("Show 2 more pages…")).click();
   $("#wiki-pages-box").$(byText("SoftAssertions")).click();
    $(".gh-header-title").shouldHave(text("SoftAssertions"));
    // проверить, что внутри есть пример кода для JUnit5
    $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
  }
}
