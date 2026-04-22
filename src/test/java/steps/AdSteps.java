package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.*;
import models.Ad;
import models.User;
import pages.AdCreationPage;
import pages.LoginPage;
import pages.ProfilePage;
import utils.TestDataGenerator;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class AdSteps {
    private ProfilePage profilePage = new ProfilePage();
    private AdCreationPage adCreationPage = new AdCreationPage();
    private LoginPage loginPage = new LoginPage();
    private Ad currentAd;
    private User testUser;

    @Пусть("пользователь зарегистрирован и авторизован")
    public void userRegisteredAndAuthorized() {
        loginPage.openPage();
        testUser = new User(
                "test3@mail.com",
                "Test567!home_worktoday098@$",
                "testuser"
        );
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        // Добавьте ожидание успешной авторизации
        profilePage.getCreateAdButton().shouldBe(Condition.visible);

        System.out.println("✓ Пользователь зарегистрирован и авторизован");
    }

    @Когда("пользователь переходит на страницу создания объявления")
    public void goToCreateAdPage() {
        profilePage.clickCreateAd();
        // Добавьте ожидание загрузки страницы создания объявления
        adCreationPage.waitForPageLoaded();
    }

    @И("пользователь создает новое объявление")
    public void createNewAd() {
        currentAd = new Ad(
                TestDataGenerator.generateAdTitle(),
                TestDataGenerator.generateAdDescription(),
                TestDataGenerator.generatePrice(),
                TestDataGenerator.getRandomCategory(),
                TestDataGenerator.generatePhoneNumber()
        );

        adCreationPage.createAd(
                currentAd.getTitle(),
                currentAd.getDescription(),
                String.valueOf(currentAd.getPrice())
        );
    }

    @Тогда("объявление успешно создано")
    public void adCreatedSuccessfully() {
        System.out.println("✓ Объявление успешно создано: " + currentAd.getTitle());

        // Проверяем, что появилось сообщение об успехе или произошел редирект
        assertThat(adCreationPage.isAdCreated()).isTrue();
    }
}