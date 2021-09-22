package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.mode.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(css = "[data-test-id=login] input")
    private SelenideElement loginField;
    @FindBy(css = "[data-test-id=password] input")
    private SelenideElement passwordField;
    @FindBy(css = "[data-test-id=action-login]")
    private SelenideElement loginButton;

    public VerificationPage validLogin(User user) {
        loginField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword());
        loginButton.click();
        return page(VerificationPage.class);
    }
}
