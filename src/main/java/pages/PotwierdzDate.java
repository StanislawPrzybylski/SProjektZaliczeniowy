package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PotwierdzDate {
    public PotwierdzDate(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]")
    WebElement fullAddress;


    public String confirmAddress() {
        return fullAddress.getText();
    }

    public void confirmAddress(String name, String lastname, String alias, String address, String city, String postalCode, String phone) {
        fullAddress.getText();
        Assert.assertEquals(fullAddress.getText(), name + "\n" + lastname + "\n" + alias + "\n" +
                address + "\n" + city + "\n" + postalCode + "\n" +
                "United Kingdom\n" +
                phone);

    }
}