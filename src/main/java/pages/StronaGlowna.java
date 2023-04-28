package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StronaGlowna {

    public StronaGlowna(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#_desktop_user_info > div > a > span")
    WebElement signInPage;

    public void gotoSignInPage() {
        signInPage.click();

    }
}
