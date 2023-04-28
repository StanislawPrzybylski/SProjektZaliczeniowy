package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WybierzIlosc {
    public WybierzIlosc(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]")
    WebElement selectedQuantinty;
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    WebElement addToCart;

    public void setSelectQuantinty() {
        int number = 5;
        for (int i = 0; i <= number; i++) {
            selectedQuantinty.click();
        }
    }

    public void addToCartBtn() {
        addToCart.click();
    }
}