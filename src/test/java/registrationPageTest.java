import Configs.BasePage;
import Steps.RegistrationPageSteps;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
@Feature("registration")
public class registrationPageTest implements ITestListener {
    RegistrationPageSteps registrationPageSteps;

    @BeforeTest
    public void setUp() {
        BasePage basePage = new BasePage();
        basePage.Config();
        open("http://testing.challenge.crocoteam.ge:1110/#/");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    }

    @Test
    public void checkCountries() {
        registrationPageSteps = new RegistrationPageSteps();
        registrationPageSteps.checkCountriesClickability();
        registrationPageSteps.checkDoubledYears();
        registrationPageSteps.checkEmailInput();
        registrationPageSteps.checkPasswordInput();
    }

    @AfterTest
    public void tearDown() throws IOException {
        screenshot();
        closeWindow();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }

}
