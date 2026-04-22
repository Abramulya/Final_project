package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
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
        // Используйте единую конфигурацию
        WebDriverConfig.setUp();

        // Дополнительные настройки Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-password-manager");
        options.addArguments("--disable-features=PasswordCheck,PasswordLeakDetection");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        Configuration.browserCapabilities = options;

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