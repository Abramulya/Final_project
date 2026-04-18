package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    private SelenideElement emailInput = $("input[name='email']");
    private SelenideElement passwordInput = $("input[name='password']");
    private SelenideElement loginButton = $("button[type='submit']");

    public LoginPage openPage() {
        open("/login");
        emailInput.shouldBe(visible);
        return this;
    }

    public void login(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.click();
    }
}