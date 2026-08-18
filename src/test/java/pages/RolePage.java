package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import testdata.TestData;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RolePage extends TestData {

    private static String rolePageUrl = "signin/main/new";
    private SelenideElement teacherСard = $(".styles__Card-sc-1xasq8v-4.bDDpON");
    private SelenideElement headTeacherСard = $(".styles__Card-sc-1xasq8v-4.kwHCkx");
    private SelenideElement studentСard = $(".styles__Card-sc-1xasq8v-4.hYjCMA");
    private ElementsCollection chooseButtons = $$(byText("Выбрать"));
//    private SelenideElement teacherRoleSelectButton = $

    @Step("Проверить, что открылась страница с выбором роли {teacher}, {headTeacher}, {student}")
    public RolePage visibilityRole(String teacher, String headTeacher, String student) {
        teacherСard.shouldBe(text(teacher));
        headTeacherСard.shouldBe(text(headTeacher));
        studentСard.shouldBe(text(student));
        chooseButtons.filter(visible).shouldHave(size(3));
        return this;
    }

    @Step("Перейти на страницу выбора роли")
    public RolePage openRolePage() {
        open(rolePageUrl);
        return this;
    }

    @Step("Нажать кнопку 'Выбрать' для роли 'Учитель/воспитатель'")
    public RolePage selectTeacherRole() {
        teacherСard.click();
        return this;
    }

    @Step("Нажать кнопку 'Выбрать' для роли 'Я завуч'")
    public RolePage selectHeadTeacherСardRole() {
        headTeacherСard.click();
        return this;
    }

    @Step("Нажать кнопку 'Выбрать' для роли 'Я ученик/родитель'")
    public RolePage selectStudentRole() {
        studentСard.click();
        return this;
    }
}
