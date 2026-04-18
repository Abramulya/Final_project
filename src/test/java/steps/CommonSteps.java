package steps;

import com.codeborne.selenide.Selenide;
import config.WebDriverConfig;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import pages.BasePage;

public class CommonSteps {

    private BasePage basePage = new BasePage() {};

    @Пусть("пользователь открыл главную страницу")
    public void openMainPage() {
        Selenide.open(WebDriverConfig.BASE_URL);
    }

    @И("пользователь разлогинился")
    public void logout() {
        basePage.logout();
    }
}