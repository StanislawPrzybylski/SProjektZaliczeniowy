package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StronaLogowania {


    public StronaLogowania(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-email")
    WebElement emailInput;

    @FindBy(id = "field-password")
    WebElement passwordInput;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    public void logIn(String email, String haslo) {
        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.clear();
        passwordInput.sendKeys(haslo);

        signInButton.click();
    }


}