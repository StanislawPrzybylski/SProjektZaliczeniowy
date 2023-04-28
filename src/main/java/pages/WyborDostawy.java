package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WyborDostawy {
    public WyborDostawy(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/label/div/div[2]/span")
    WebElement deliveryOpt;
    @FindBy(name = "confirmDeliveryOption")
    WebElement confirmDelivery;

    public String setDeliveryOpt() {
        return deliveryOpt.getText();

    }

    public void setConfirmDelivery() {
        deliveryOpt.click();
        confirmDelivery.click();
    }
}
