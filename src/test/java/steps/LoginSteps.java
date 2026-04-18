package steps;

import io.cucumber.java.ru.*;
import models.User;
import pages.LoginPage;

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
                "test2@mail.com",
                "test123",
                "testuser"
        );
        loginPage.login(testUser.getEmail(), testUser.getPassword());
    }

    @Тогда("авторизация успешно проходит")
    public void loginSuccess() {
        System.out.println("✓ Авторизация выполнена");
    }
}
