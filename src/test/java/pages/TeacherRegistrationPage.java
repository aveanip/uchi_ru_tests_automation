package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TeacherRegistrationPage {

    private static String teacherRegistUrl = "signup/teacher";
    private SelenideElement titleText = $(".styles__Title - sc - 1fj65io - 0hmlXCo");
    private SelenideElement teacherEmail = $("#teacher_email");
    private SelenideElement teacher_password = $("#teacher_email");
    private SelenideElement teacherConsentUseData = $("#teacher_consent_use_data");
    private SelenideElement teacherPersonalDataCheckbox = $ ("#teacher_personal_data_checkbox");
    private SelenideElement signUpButton= $(".styles__Btn-sc-10s2nsr-0 dMzKPN");
    private SelenideElement emailValidationError = $(byText("Адрес электронной почты должен содержать символ @"));
    private SelenideElement validationShortPassword =$(byText("Слишком короткий пароль"));

    @Step("Открыть страницу регистрации учителя/воспитателя")
    public TeacherRegistrationPage openTeacherRegistUrl(){
        open(teacherRegistUrl);
        return this;
    }
    @Step("Проверка валидации при вводе в поле email ")







}
