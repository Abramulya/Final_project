package steps;

import static com.codeborne.selenide.Condition.visible;

import io.cucumber.java.ru.*;
import models.User;
import pages.BasePage;
import pages.LoginPage;
import utils.ApiClient;
import utils.TestDataGenerator;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();
    private User testUser;

    @Когда("пользователь переходит на страницу авторизации")
    public void openLoginPage() {
        loginPage.openPage();
    }

    @И("вводит корректные email и пароль")
    public void enterValidCredentials() {
        testUser = new User(
                TestDataGenerator.generateUniqueEmail(),
                TestDataGenerator.generatePassword(),
                TestDataGenerator.generateUsername()
        );
        ApiClient.registerUser(testUser);
        loginPage.login(testUser.getEmail(), testUser.getPassword());
    }

    @Тогда("авторизация успешно проходит")
    public void loginSuccess() {
        BasePage.logoutButton.shouldBe(visible);
        System.out.println("✓ Авторизация выполнена");
    }
}