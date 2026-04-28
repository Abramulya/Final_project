package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    public static SelenideElement logoutButton = $(byText("Выйти"));

    public void logout() {
        logoutButton.click();
    }
}