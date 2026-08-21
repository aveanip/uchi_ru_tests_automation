package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Main_page {
    private final SelenideElement registrationButton = $(byText("Зарегистрироваться"));
    private final SelenideElement advantagesBlock = $(".Facts_wrapper__C0PWW");
    private final SelenideElement login = $("#login");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginButton = $(byText("Войти"));
    private final SelenideElement validationText = $(".Form_errorContainer__3olS7");
    private final SelenideElement helpButton = $(".text__HV7U6");
    private final SelenideElement titleText = $(".popularTitle__8Pi-v");
    private final SelenideElement searchInput = $(".cinput-text-input__fL5CI");
    private final SelenideElement searchResponse = $(".title__vtW-7");


    @Step("Перейти на главную страницу сайта https://uchi.ru/")
    public Main_page openPage() {
        open("https://uchi.ru/");
        return this;
    }

    public Main_page removeBanners() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);

        return this;
    }

    @Step("Проверить, что кнопка 'Зарегистрироваться' видна")
    public Main_page checkButtonVisible() {
        registrationButton.shouldHave(visible);
        return this;
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public Main_page clickButton() {
        registrationButton.click();
        return this;
    }

    @Step("Проверить, список преимуществ")
    public Main_page checkBlock(String value, String value2, String value3) {
        advantagesBlock.shouldHave(text(value)).shouldHave(visible)
                .shouldHave(text(value2)).shouldHave(visible)
                .shouldHave(text(value3)).shouldHave(visible);
        return this;
    }

    @Step("Ввести валидный логин {value}")
    public Main_page validLogin(String value) {
        login.setValue(value);
        return this;
    }

    @Step("Ввести валидный пароль {value}")
    public Main_page ValidPassword(String value) {
        password.setValue(value);
        return this;
    }

    @Step("Нажать кнопку Войти")
    public Main_page clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Проверка текста валидации при не верно введенном логине или пароле")
    public Main_page checkValidationTextError(String value) {
        validationText.shouldHave(text("Неверная пара логина и пароля")).shouldHave(visible);
        return this;
    }

    @Step("Нажать на кнопку 'Помощь")
    public Main_page clickHelpButton() {
        helpButton.click();
        return this;
    }

    @Step("Проверить заголовок {value}")
    public Main_page checkTitleText(String value) {
        titleText.shouldHave(text("Популярные статьи")).shouldHave(visible);
        return this;
    }

    @Step("В поле поиска ввести : {value}")
    public Main_page enterSearchQuery(String value) {
        searchInput.setValue(value);
        return this;
    }

    @Step("Проверить ответ поиска {value}")
    public Main_page verifyArticleFound(String value) {
        searchResponse.shouldHave(text(value));
        return this;
    }
}