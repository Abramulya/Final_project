package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected SelenideElement profileIcon = $("[data-testid='profile-icon']");
    protected SelenideElement logoutButton = $("[data-testid='logout-btn']");

    public void logout() {
        profileIcon.click();
        logoutButton.click();
    }
}