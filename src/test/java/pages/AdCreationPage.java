package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class AdCreationPage extends BasePage {
    private SelenideElement titleInput = $("input[name='name']");
    private SelenideElement descriptionInput = $("textarea[name='description']");
    private SelenideElement priceInput = $("input[name='price']");
    private SelenideElement publishButton = $("button[type='submit']");

    public void createAd(String title, String description, String price) {
        titleInput.setValue(title);
        descriptionInput.setValue(description);
        priceInput.setValue(price);
        publishButton.click();
    }

    public boolean isAdCreated() {
        String currentUrl = com.codeborne.selenide.WebDriverRunner.url();
        return currentUrl.contains("qa-desk.stand.praktikum-services.ru/");
    }
}