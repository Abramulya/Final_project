package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdCreationPage extends BasePage {
    private SelenideElement titleInput = $("input[name='name']");
    private SelenideElement descriptionInput = $("textarea[name='description']");
    private SelenideElement priceInput = $("input[name='price']");
    private SelenideElement publishButton = $("button[type='submit']");
    private SelenideElement successMessage = $(".success-message"); // Подберите правильный селектор

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
        System.out.println("Ожидание завершения...");
    }

    public boolean isAdCreated() {
        // Проверяем несколько возможных признаков успешного создания
        String currentUrl = WebDriverRunner.url();

        // Проверка URL
        boolean urlChanged = !currentUrl.contains("/create") &&
                currentUrl.contains("qa-desk.stand.praktikum-services.ru");

        // Проверка наличия сообщения об успехе (если есть)
        boolean successMessageVisible = successMessage.exists() && successMessage.isDisplayed();

        return urlChanged || successMessageVisible;
    }
}