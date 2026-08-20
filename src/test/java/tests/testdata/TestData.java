package tests.testdata;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.Main_page;
import pages.RolePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestData {
    Faker faker = new Faker();

    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password(8, 16);
    public String validationTextError = "Неверная пара логина и пароля";
    public String teacherRole = "Я учитель/воспитатель";
    public String headTeacherRole = "Я завуч";
    public String studentRole = "Я ученик/родитель";
    public String popularArticlesTitle = "Популярные статьи";
    public String validSearchQuery = "служба поддержки";
    public String invalidSearchQuery = "jjgfdjd";
    public String foundArticlesText = "Нашлось 9 статей";
    public String zeroArticlesText = "Нашлось 0 статей";


}
