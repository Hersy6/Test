package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class registrationPage {
    public SelenideElement
            cityDrop = $(By.xpath
            ("/html/body/app-root/app-register-container/div[2]/form/div[3]/div[2]/app-shared-select/div")),
            selection = $(By.cssSelector("body > app-root > app-register-container > div.wrapper > form > div.wrapper__form-input.country-city > div.wrapper__form-input__city > app-shared-select > div > ng-select > div > div > div.ng-value > span.ng-value-label")),
            yearSection = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[6]/div[3]")),
            email = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[7]/app-shared-input/div/input")),
            message = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[7]/app-shared-input/div[2]/span")),
            password = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[8]/div[3]/div[1]/app-shared-input/div[1]/input")),
            username = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[8]/div[4]/p[4]")),
            range = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[8]/div[4]/p[3]")),
            numbers = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[8]/div[4]/p[2]")),
            letters = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[8]/div[4]/p[1]")),
            usernameInput = $(By.xpath("/html/body/app-root/app-register-container/div[2]/form/div[8]/div[2]/app-shared-input/div/input"));


    public List<SelenideElement> cityList = $$(By.cssSelector("ng-dropdown-panel[aria-label='Options list']> div > div:nth-child(2)> div"));

    public List<SelenideElement> years = $$(By.cssSelector("ng-dropdown-panel[aria-label='Options list']> div > div:nth-child(2)> div"));
}
