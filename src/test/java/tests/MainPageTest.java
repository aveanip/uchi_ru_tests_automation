package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Main_page;
import pages.RolePage;

import static io.qameta.allure.Allure.step;

public class MainPageTest extends BaseTest{

    @Test
    @DisplayName("Проверка списка преимуществ")
    void checkAdvantagesBlock() {
        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .removeBanners();
        });
        step("Проверить видимость и список блока преимуществ ");
        mainPage.checkBlock("Курсы входят в перечень ЭОР Минпросвещения России",
                "88% школ страны используют Учи.ру", "Материалы соответствуют ФГОС и ФООП");
    }

    @Test
    @DisplayName("Войти в систему с невалидными данными учителя")
    void signInWithInvalidData() {
        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .removeBanners();
        });
        step("Ввести валидный Логин", () -> {
            mainPage.validLogin(testData.email);
        });

        step("Ввести валидный Пароль", () -> {
            mainPage.ValidPassword(testData.password);
        });

        step("Нажать кнопку Войти", () -> {
            mainPage.clickLoginButton();
        });
        step("Проверка текста ошибки валидации", () -> {
            mainPage.checkValidationTextError(testData.validationTextError);
        });
    }

    @Test
    @DisplayName("При нажатии на кнопку 'Зарегистрироваться' открывается страница выбора роли")
    void clickRegisterButtonOpensRoleSelectionPage() {
        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .removeBanners();
        });
        step("Проверить видимость кнопки и нажать на нее ", () -> {
            mainPage
                    .checkButtonVisible()
                    .clickButton();
        });

        step("Проверить, что открылась страница с выбором ролей ", () -> {
            rolePage
                    .visibilityRole(testData.teacherRole,
                            testData.headTeacherRole,
                            testData.studentRole);
        });
    }

    @Test
    @DisplayName("Нажать на кнопку 'Помощь'")
    void clickMoreDetailsButton() {
        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .removeBanners();
        });
        step("Кликнуть по кнопки 'Помощь' ", () -> {
            mainPage.clickHelpButton();
        });

        step("Проверить заголовок под строкой поиска ", () -> {
            mainPage.checkTitleText(testData.popularArticlesTitle);
        });
    }

    @Test
    @DisplayName("Проверка отображения количества найденных статей при поиске")
    void checkFoundArticlesCount() {
        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .removeBanners();
        });
        step("Кликнуть по кнопки 'Помощь' ", () -> {
            mainPage.clickHelpButton();
        });
        step("Ввести поисковой запрос ", () -> {
            mainPage.enterSearchQuery(testData.validSearchQuery);
        });
        step("Проверить, отображение ответа поиска", () -> {
            mainPage.verifyArticleFound(testData.foundArticlesText);
        });

    }

    @Test
    @DisplayName("Проверка отображения '0 статей' при поиске несуществующего запроса")
    void checkZeroArticlesFound() {
        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .removeBanners();
        });
        step("Кликнуть по кнопки 'Помощь' ", () -> {
            mainPage.clickHelpButton();
        });
        step("Ввести поисковой запрос ", () -> {
            mainPage.enterSearchQuery(testData.invalidSearchQuery);
        });
        step("Проверить, отображение ответа поиска", () -> {
            mainPage.verifyArticleFound(testData.zeroArticlesText);
        });
    }
}
