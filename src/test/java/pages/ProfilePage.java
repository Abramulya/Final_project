package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage extends BasePage {
    private SelenideElement createAdButton = $x("//button[contains(text(),'Разместить объявление')]");
    private SelenideElement logoutButton = $("button.btnSmall");

    public SelenideElement getCreateAdButton() {
        return createAdButton;
    }

    public void clickCreateAd() {
        createAdButton.shouldBe(visible).shouldBe(enabled).click();
    }

    public void logout() {
        logoutButton.click();
    }
}