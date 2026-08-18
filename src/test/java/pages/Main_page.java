package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Main_page {
    private String mainPageUrl = "https://uchi.ru/";

    private final SelenideElement
    registrationButton = $(byText("Зарегистрироваться"));


@Step("Перейти на главную страницу сайта https://uchi.ru/")
    public Main_page openPage(){
    open(mainPageUrl);
    return this;
}

@Step("Проверить, что кнопка 'Зарегистрироваться' видна")
public Main_page checkButtonVisible(){
    registrationButton.shouldHave(visible);
    return this;
}

@Step("Нажать на кнопку")
    public Main_page clickButton(){
    registrationButton.click();
    return this;
}
}
