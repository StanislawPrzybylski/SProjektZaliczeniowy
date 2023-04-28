package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;


public class ZrobSkrinszot {
    public ZrobSkrinszot(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "content")
    WebElement orderContent;
    WebDriver driver;

    public void takePicture(WebElement element) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("./CucumberShots/Test1_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the order page screenshot is taken");

    }

    public void getElementSS(WebElement element) {
        takePicture(orderContent);
    }

}