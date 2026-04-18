package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends BasePage {
    private SelenideElement emailInput = $("input[name='email']");
    private SelenideElement passwordInput = $("input[name='password']");
    private SelenideElement confirmPasswordInput = $("input[name='submitPassword']");
    private SelenideElement registerButton = $x("//button[contains(text(),'Создать аккаунт')]");
    private SelenideElement errorMessage = $("span.input_span__yWPqB");
    private SelenideElement haventAccButton = $x("//button[contains(text(),'Нет аккаунта')]");

    public RegistrationPage openPage() {
        open("/login");
        emailInput.shouldBe(visible);
        haventAccButton.shouldBe(visible).click();
        emailInput.shouldBe(visible);
        return this;
    }

    public void register(String email, String password) {
        emailInput.shouldBe(visible).setValue(email);
        passwordInput.setValue(password);
        confirmPasswordInput.setValue(password);
        registerButton.shouldBe(enabled).click();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }
}