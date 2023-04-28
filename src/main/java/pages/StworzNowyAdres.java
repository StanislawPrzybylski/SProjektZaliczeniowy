package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StworzNowyAdres {
    public StworzNowyAdres(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    WebElement aliasField;

    @FindBy(id = "field-address1")
    WebElement addressField;

    @FindBy(id = "field-city")
    WebElement cityField;

    @FindBy(id = "field-postcode")
    WebElement postcodeField;

    @FindBy(id = "field-id_country")
    WebElement countrySelect;

    @FindBy(id = "field-phone")
    WebElement phoneField;

    @FindBy(name = "submitAddress")
    WebElement saveAddress;

    public void fillTheAddressForm(String alias, String address, String city, String postalCode, String phone) {
        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        postcodeField.sendKeys(postalCode);
        phoneField.sendKeys(phone);
        countrySelect.getText().contains("United Kingdom");
        countrySelect.isEnabled();
        countrySelect.isSelected();
        countrySelect.click();
        saveAddress.submit();
    }
}