package LogowanieiDodawanieAdresu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;


public class LogowanieiDodawanieAdresu {

    public static WebDriver driver;
    public String url = "https://mystore-testlab.coderslab.pl/index.php";

    @Given("Uzytkownik znajduje się na stronie glownej aplikacji")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);

    }

    @And("Uzytkownik kilka przycisk signIn")

    public void goToLoginPage() {
        StronaGlowna stronaGlowna = new StronaGlowna(driver);
        stronaGlowna.gotoSignInPage();

    }

    @When("Loguje sie poprawnymi danymi {string} oraz {string}")
    public void signInToApp(String email, String haslo) {
        StronaLogowania logInApp = new StronaLogowania(driver);
        logInApp.logIn(email, haslo);
    }

    @And("Zalogowany uzytkownik na stronie glownej kilka w Addresses na wyswietlonej stronie")
    public void myAddresses() {
        IdzDoMojAdres myAddress = new IdzDoMojAdres(driver);
        myAddress.goToMyAddress();
    }

    @And("Uzytkownik wybiera Creat new Address")
    public void creatingAddress() {
        MojAdres createNew = new MojAdres(driver);
        createNew.createAddress();
    }

    @And("Uzytkownik wepelnia formularz swoimi danymi {string}, {string}, {string}, {string}, {string} Kilka zapisz")
    public void setUpAddress(String alias, String address, String city, String postalCode, String phone) {
        StworzNowyAdres addressForm = new StworzNowyAdres(driver);
        addressForm.fillTheAddressForm(alias, address, city, postalCode, phone);
    }

    @Then("Nowy adres zostaje dodany uzytkownik {string} {string} sprawdza poprawnosc danych {string}, {string}, {string}, {string}, {string}")
    //@Then(" Nowy adres zostaje dodany uzytkownik {string} {string} sprawdza poprawnosc danych {string}, {string}, {string}, {string} , {string}")
    public void addressConfirmation(String name, String lastname, String alias, String address, String city, String postalCode, String phone) {
        PotwierdzDate potwierdzDate = new PotwierdzDate(driver);
        //checkAddress.confirmAddress(name, lastname, alias, address, city, postalCode, phone);

        potwierdzDate.confirmAddress().contains(name + lastname + "\n" + alias + "\n" +
                address + "\n" + city + "\n" + postalCode + "\n" +
                "United Kingdom\n" +
                phone);

    }

    @And("Przegladarka zostaje zamknieta")
    public void tearDown() {
        driver.quit();
    }
}