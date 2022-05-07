import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FindExampleCodeForJunit {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
    }

    @DisplayName("Открываем страницу SoftAssertions, проверяем что внутри есть пример кода для JUnit5")
    @Test
    public void testFindJunit() {
        open("https://github.com");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }


}
