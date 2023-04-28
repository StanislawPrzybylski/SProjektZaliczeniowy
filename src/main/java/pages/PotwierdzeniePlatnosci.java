package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PotwierdzeniePlatnosci {
    public PotwierdzeniePlatnosci(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"payment-option-1-container\"]/label/span")
    WebElement payByCheck;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement agreementTerms;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    WebElement placeOrderBtn;

    public void setPayByCheck() {
        payByCheck.click();
        agreementTerms.click();
    }

    public void placeOrder() {
        placeOrderBtn.isEnabled();
        placeOrderBtn.click();
    }
}
