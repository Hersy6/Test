package Steps;

import Configs.RandomGenerator;
import Pages.registrationPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
public class RegistrationPageSteps {
    Pages.registrationPage registrationPage;
    RandomGenerator randomGenerator;

    @Step
    public RegistrationPageSteps checkCountriesClickability() {
        registrationPage = new registrationPage();


        registrationPage.cityDrop.click();
        //  System.out.println(registrationPage.cityList.size());
        //System.out.println(registrationPage.cityList);
        // System.out.println(registrationPage.cityDrop);
        System.out.println(registrationPage.selection.getText());



        for (int i = 1; i <registrationPage.cityList.size() ; i++) {
            registrationPage.cityList.get(i).click();
            registrationPage.cityDrop.click();
            if (registrationPage.cityList.get(i).isDisplayed()) {
                System.out.println(registrationPage.cityList.get(i).getText() + " is clickable");

            }

            boolean boolian = false;
            if(boolian == registrationPage.cityList.get(i).isDisplayed()){
                registrationPage.cityDrop.click();
                System.out.println(registrationPage.cityList.get(i).getText() + " is not clickable");

            }


        }
        return this;
    }

    @Step
    public RegistrationPageSteps checkDoubledYears() {
        registrationPage = new registrationPage();
        registrationPage.cityDrop.click();
        registrationPage.username.scrollTo();
        registrationPage.yearSection.click();
        System.out.println(registrationPage.years.size());

        for (int i = 0; i < registrationPage.years.size(); i++) {
            for (int j = i + 1; j < registrationPage.years.size(); j++) {
                if (registrationPage.years.get(i) == registrationPage.years.get(j)) {
                    System.out.println(registrationPage.years.get(i).getText());
                }
                }
            }

        return this;
    }

    @Step
    public RegistrationPageSteps checkEmailInput() {
        SoftAssert softAssert = new SoftAssert();

        registrationPage = new registrationPage();
        randomGenerator = new RandomGenerator();
        registrationPage.email.sendKeys(randomGenerator.Email);
        softAssert.assertFalse(registrationPage.message.isDisplayed());
        registrationPage.email.clear();
        registrationPage.email.sendKeys("email");
        softAssert.assertTrue(registrationPage.message.isDisplayed());
        return this;
    }

    @Step
    public RegistrationPageSteps checkPasswordInput() {
        SoftAssert softAssert = new SoftAssert();
        registrationPage = new registrationPage();

        registrationPage.username.shouldNotHave(Condition.cssValue("color", "rgba(255, 255, 255, 1)"));
        registrationPage.range.shouldNotHave(Condition.cssValue("color", "rgba(255, 255, 255, 1)"));
        registrationPage.numbers.shouldNotHave(Condition.cssValue("color", "rgba(255, 255, 255, 1)"));
        registrationPage.letters.shouldNotHave(Condition.cssValue("color", "rgba(255, 255, 255, 1)"));
        registrationPage.password.sendKeys("Tornike123");
        registrationPage.username.shouldHave(Condition.cssValue("color", "rgba(255, 255, 255, 1)"));
        registrationPage.range.shouldHave(Condition.cssValue("color", "rgba(255, 255, 255, 1)"));
        registrationPage.numbers.shouldHave(Condition.cssValue("color", "rgba(255, 255, 255, 1)"));
        registrationPage.letters.shouldHave(Condition.cssValue("color", "rgba(255, 255, 255, 1)"));
        softAssert.assertFalse(registrationPage.usernameInput.getText() == registrationPage.password.getText());
        System.out.println(registrationPage.username.getCssValue("color"));
        String clas = "invalid-value";
        registrationPage.password.clear();
        registrationPage.password.sendKeys("tornike123");
        softAssert.assertEquals(registrationPage.password.getAttribute("class").toString(), clas);
        registrationPage.password.clear();
        registrationPage.password.sendKeys("To1");
        softAssert.assertEquals(registrationPage.password.getAttribute("class").toString(), clas);
        registrationPage.password.clear();
        registrationPage.password.sendKeys("tornike12311111111111111111111111111111111111111111111111111111");
        softAssert.assertEquals(registrationPage.password.getAttribute("class").toString(), clas);
        registrationPage.password.sendKeys("123333123");
        softAssert.assertEquals(registrationPage.password.getAttribute("class").toString(), clas);
        registrationPage.password.clear();
        registrationPage.password.sendKeys("T123333123");
        softAssert.assertEquals(registrationPage.password.getAttribute("class").toString(), clas);
        registrationPage.password.clear();
        registrationPage.password.sendKeys("T@123333123");
        softAssert.assertEquals(registrationPage.password.getAttribute("class").toString(), clas);
        registrationPage.password.clear();
        registrationPage.password.sendKeys("@123333123");
        softAssert.assertEquals(registrationPage.password.getAttribute("class").toString(), clas);
        registrationPage.password.clear();
        registrationPage.password.sendKeys("Td@123333123");
        softAssert.assertEquals(registrationPage.password.getAttribute("class").toString(), clas);
        registrationPage.password.clear();
        softAssert.assertAll();
        return this;
    }
}
