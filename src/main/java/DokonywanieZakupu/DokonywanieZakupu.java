package DokonywanieZakupu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DokonywanieZakupu {

    public static WebDriver driver;
    public String url = "https://mystore-testlab.coderslab.pl/index.php";

    @Given("Niezalogowany uzytkownik znajduje się na stronie glownej aplikacji")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("Uzytkownik kilka przycisk signIn i loguje sie na strone danym adres {string} oraz haslo {string}")
    public void goToLoginPage(String email, String haslo) {
        StronaGlowna stronaGlowna = new StronaGlowna(driver);
        stronaGlowna.gotoSignInPage();
        StronaLogowania logInApp = new StronaLogowania(driver);
        logInApp.logIn(email, haslo);
    }

    @And("Uzytkownik przechodzi do strony mystore i wybiera produkt Hummingbird Printed Sweater")
    public void selectItem() {
        PrzebieranieWPrzedmiotach openMyStore = new PrzebieranieWPrzedmiotach(driver);
        openMyStore.goToMyStore();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PrzebieranieWPrzedmiotach przebieranieWPrzedmiotach = new PrzebieranieWPrzedmiotach(driver);
        przebieranieWPrzedmiotach.selectingItem();
    }

    @And("Uzytkownik sprawdza przecene")
    public void discountCheck() {
        PotwierdzenieZnizki discountPrice = new PotwierdzenieZnizki(driver);
        Assert.assertEquals(discountPrice.getDiscountPrice(), discountPrice.discountCalculation());
    }

    @When("Wybiera rozmiar {string} produktu")
    public void chooseASize(String rozmiar) {
        WybierzRozmiar choosedSize = new WybierzRozmiar(driver);
        choosedSize.selectSize(rozmiar);
    }

    @And("Wybiera ilosc towaru i klika przycisk addToCart")
    public void setQuantinity() {
        WybierzIlosc wybierzIlosc = new WybierzIlosc(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wybierzIlosc.setSelectQuantinty();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wybierzIlosc.addToCartBtn();
    }

    @And("Uzytkownik kilka procedure to checkout i ponawia ten krok na nowej stronie")
    public void toCheckout() {
        UdajSieDoKasy checkout = new UdajSieDoKasy(driver);
        checkout.checkProcedure();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        checkout.checkProcedure2();
    }

    @And("Uzytkownik wepelnia formularz  swoimi danymi {string}, {string}, {string}, {string}, {string} Kilka continue")
    public void completeContactForm(String alias, String address, String city, String postalCode, String phone) {
        DodajAdressPrzedZakupem dodajAdressPrzedZakupem = new DodajAdressPrzedZakupem(driver);
        dodajAdressPrzedZakupem.addAdressUntliShopinng(alias, address, city, postalCode, phone);
    }

    @Then("Uzytkownik wybiera i potwierdza rodzaj dostawy")
    public void confirmDelivery() {
        WyborDostawy wyborDostawy = new WyborDostawy(driver);
        wyborDostawy.setDeliveryOpt();
        Assert.assertEquals(wyborDostawy.setDeliveryOpt(), "Pick up in-store");
        //contains("Pick up in-store");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wyborDostawy.setConfirmDelivery();
    }

    @And("Uzytkownik wybiera metode platnosci wyraza zgode z warunkami umowy i kilka Place Order")
    public void paymentByCheckSelect() {
        PotwierdzeniePlatnosci potwierdzeniePlatnosci = new PotwierdzeniePlatnosci(driver);
        potwierdzeniePlatnosci.setPayByCheck();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        potwierdzeniePlatnosci.placeOrder();
    }

    @And("Wyswietla sie potwierdzenie zamowienia i uzytkownik robi screenshota")

    public void takeScreenShot() {
        WiadomoscPotwierdzajacaZamowienie getconfMsg = new WiadomoscPotwierdzajacaZamowienie(driver);


        getconfMsg.confirmMsg();
        Assert.assertEquals(getconfMsg.confirmMsg(), "YOUR ORDER IS CONFIRMED");

        TakesScreenshot takeSS = (TakesScreenshot) driver;
        File file = takeSS.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./CucumberShots/Test1_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the order page screenshot is taken");
    }

    @And("Przegladarka jest zamknieta")
    public void browserDown() {
        driver.close();
        driver.quit();
    }


}