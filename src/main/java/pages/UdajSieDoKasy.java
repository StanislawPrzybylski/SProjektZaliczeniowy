package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UdajSieDoKasy {
    public UdajSieDoKasy(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    WebElement procedureToCheckBtn;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    WebElement procedureToCheckBtn2;

    public void checkProcedure() {
        procedureToCheckBtn.click();
    }

    public void checkProcedure2() {
        procedureToCheckBtn2.click();
    }
}