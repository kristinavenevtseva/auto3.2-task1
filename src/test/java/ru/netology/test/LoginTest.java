package ru.netology.test;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.netology.mode.Cleaner;
import ru.netology.mode.DataGenerator;
import ru.netology.mode.VerificationCode;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @SneakyThrows
    @Test
    void shouldSuccessfulLogin() {
        Runtime.getRuntime().exec("java -jar ./artifacts/app-deadline.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app -P:jdbc.user=app -P:jdbc.pa\n" +
                "ssword=pass");
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataGenerator.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.validVerify(VerificationCode.getVerificationCode());
        Cleaner.cleanTable();
    }
}
