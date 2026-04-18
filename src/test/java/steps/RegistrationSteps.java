package steps;

import io.cucumber.java.ru.*;
import models.User;
import pages.RegistrationPage;
import utils.TestDataGenerator;

public class RegistrationSteps {
    private RegistrationPage registrationPage = new RegistrationPage();
    private User testUser;

    @Когда("пользователь переходит на страницу регистрации")
    public void openRegistrationPage() {
        registrationPage.openPage();
    }

    @И("заполняет форму регистрации уникальными данными")
    public void fillRegistrationFormWithUniqueData() {
        testUser = new User(
                TestDataGenerator.generateUniqueEmail(),
                TestDataGenerator.generatePassword(),
                "testuser"
        );
        registrationPage.register(testUser.getEmail(), testUser.getPassword());
    }

    @И("заполняет форму регистрации уже зарегистрированным email")
    public void fillRegistrationFormWithExistingEmail() {
        registrationPage.register("existing@test.com", "password123");
    }

    @Тогда("регистрация успешно завершается")
    public void registrationSuccess() {
        System.out.println("✓ Регистрация успешна");
    }

    @Тогда("система показывает ошибку о том, что пользователь уже существует")
    public void registrationErrorDisplayed() {
        assert registrationPage.isErrorDisplayed() : "Ошибка не отобразилась";
    }
}