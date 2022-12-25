package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelenideTest {
    @BeforeEach
    void setUp() {
        Selenide.open("https://google.com");
    }

//    @DisplayName("Проверка наличия урл https://selenide.org "+
//    "в результатах выдачи гугла")
//    @Test
//    @Tag("BLOCKER")
//    void googleSelenideTest() {
//
//        $(".gLFyf").setValue("selenide").pressEnter();
//        $("[id=search]").shouldHave(text("https://selenide.org"));
//    }
//    @CsvFileSource (
//            resources = "example.csv"
//    )
    @CsvSource({
            "selenide, https://selenide.org",
            "junit 5, https://junit.org"

    })
//    @DisplayName("Проверка наличия урл {1} "+
//            "в результатах выдачи гугла {0}")
   @ParameterizedTest (name="Проверка наличия урл {1} в результатах выдачи гугла {0}")
    @Tags ({@Tag("BLOCKER"), @Tag("FEATURE")})
    @Tag("BLOCKER")
    void googleSearchTest(String searchQuery, String expectedUrl) {

        $(".gLFyf").setValue(searchQuery).pressEnter();
        $("[id=search]").shouldHave(text(expectedUrl));
    }

    @CsvSource({
            "selenide, https://selenide.org",
            "junit 5, https://junit.org"

    })
//    @DisplayName("Проверка наличия урл {1} "+
//            "в результатах выдачи гугла {0}")
    @ParameterizedTest (name="Проверка наличия урл {1} в результатах выдачи гугла {0}")
    @Tag("BLOCKER")
    void selenideButtonTest(String locale, List<String> buttons) {

        $(".gLFyf").setValue(searchQuery).pressEnter();
        $("[id=search]").shouldHave(text(expectedUrl));
    }


    @DisplayName("Проверка загрузки фото")
    @Test
    @Tag("BLOCKER")
    void googlePhotoPopupTest() {

        $("img[alt='Поиск с помощью камеры']").click();
        $(byText("Выполните поиск по изображению в Google Объективе")).shouldBe(visible);
    }
}
