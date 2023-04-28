package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrzebieranieWPrzedmiotach {
    public PrzebieranieWPrzedmiotach(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"_desktop_logo\"]")
    WebElement myStoreIcon;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/div[2]/article/div/div[1]")
    WebElement itemSelected;


    public void goToMyStore() {
        myStoreIcon.click();
    }


    public void selectingItem() {
        itemSelected.click();
    }
}