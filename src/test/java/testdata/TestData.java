package testdata;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.Main_page;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestData {
    static String mainPageUrl = "https://uchi.ru/";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = mainPageUrl;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void afterEach() {

        closeWebDriver();
    }

}
