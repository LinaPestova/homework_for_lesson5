import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ElementsWithHover {
    @BeforeAll
    static void beforeAll() {
        baseUrl="https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }
    @Test
    void solutionsWithHover() {
        open (baseUrl);
        $(".header-menu-wrapper").$(byTagAndText("button", "Solutions")).hover();
        $(".header-menu-wrapper").$(byTagAndText("a", "Enterprise")).click();
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
     $("#hero-section-brand-heading").shouldHave(
                text("The AI Powered\n" +
                        "Developer Platform.")
        );
    }

}
