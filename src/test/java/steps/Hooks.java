package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ApiClient;

import java.util.HashMap;
import java.util.Map;

public class Hooks {

    @Before
    public void setUp() {
        // Настройка Selenide
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://qa-desk.stand.praktikum-services.ru";

        // Отключаем предупреждения о скомпрометированных паролях
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-password-manager");

        // отключаем проверку утечки паролей
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Отключаем автоматическое всплывающее окно
        options.addArguments("--disable-features=PasswordCheck,PasswordLeakDetection");

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));

        // Инициализация API клиента
        ApiClient.init();

        System.out.println("✓ Тест запущен, браузер настроен");
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
        System.out.println("✓ Браузер закрыт");
    }
}