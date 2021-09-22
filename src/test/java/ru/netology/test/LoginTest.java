package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.mode.Cleaner;
import ru.netology.mode.User;
import ru.netology.mode.VerificationCode;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    User user = new User("vasya", "qwerty123");

    @Test
    void shouldSuccessfulLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var verificationPage = loginPage.validLogin(user);
        verificationPage.validVerify(VerificationCode.getVerificationCode());
        String text = $("[data-test-id=dashboard]").text();
        assertEquals("Личный кабинет", text.strip());
        Cleaner.cleanTable();
    }
}
