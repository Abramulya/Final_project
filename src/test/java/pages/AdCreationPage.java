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

    public boolean isAdCreated() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = WebDriverRunner.url();
        return currentUrl.equals("https://qa-desk.education-services.ru/")
                || currentUrl.equals(WebDriverRunner.getWebDriver().getCurrentUrl().replaceAll("/$", ""));
    }
}