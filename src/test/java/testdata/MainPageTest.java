package testdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Main_page;
import pages.RolePage;

import static io.qameta.allure.Allure.step;

public class MainPageTest {
    Main_page mainPage = new Main_page();
    RolePage rolePage = new RolePage();

    @Test
    @DisplayName("При нажатии на кнопку 'Зарегистрироваться' открывается страница выбора роли")
    void clickRegisterButtonOpensRoleSelectionPage() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });
        step("Проверить видимость кнопки и нажать на нее ", () -> {
            mainPage
                    .checkButtonVisible()
                    .clickButton();
        });

        step("Проверить, что открылась страница с выбором ролей ", () -> {
            rolePage
                    .visibilityRole("Я учитель/воспитатель",
                            "Я завуч",
                            "Я ученик/родитель");
        });
}
}
