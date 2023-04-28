package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PotwierdzenieZnizki {
    public PotwierdzenieZnizki(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]")
    WebElement discountPrice;


    public double getDiscountPrice() {

        return Double.parseDouble(discountPrice.getText().replaceAll("[^0-9.]", ""));

    }

    public double discountCalculation() {
        double regularP = 35.90;
        double discount = 100 - 20;
        return regularP * discount / 100;

    }

}