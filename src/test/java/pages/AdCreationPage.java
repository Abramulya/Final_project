package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdCreationPage extends BasePage {
    private SelenideElement titleInput = $("input[name='name']");
    private SelenideElement descriptionInput = $("textarea[name='description']");
    private SelenideElement priceInput = $("input[name='price']");
    private SelenideElement publishButton = $("button[type='submit']");
    private SelenideElement adCard = $("h2.h2");
    private SelenideElement searchInput = $("input[placeholder='Я хочу купить...']");
    private SelenideElement applyButton = $("button[type='submit']");

    public void waitForPageLoaded() {
        titleInput.shouldBe(visible);
    }

    public void createAd(String title, String description, String price) {
        System.out.println("Создание объявления: " + title);
        titleInput.setValue(title);
        descriptionInput.setValue(description);
        priceInput.setValue(price);
        System.out.println("Нажатие кнопки публикации");
        publishButton.click();
    }

    public boolean isAdCreated(String adTitle) {
        searchInput.shouldBe(visible);
        searchInput.setValue(adTitle);
        applyButton.click();
        adCard.shouldBe(visible);
        return adCard.getText().equals(adTitle);
    }
}