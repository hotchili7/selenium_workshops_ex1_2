package example;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressesPageTest extends BaseTest {

    public MainPage mainPage;
    public LoginPage loginPage;
    public YouAccountPage youAccountPage;
    public ShoppingCartPage shoppingCartPage;
    public AddressesPage addressesPage;


    @BeforeMethod
    public void before() {

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        loginPage = new LoginPage(driver);
    }


    @Test
    public void shouldGoToAddressesPageTest() {

        loginPage.inputCredentials(emailToLog, passwdToLog)
                .clickSignInButton()
                .navigateToAdressesPage();

        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("address"));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://mystore-testlab.coderslab.pl/index.php?controller=address");


    }



    @Test
    public void shouldFillTheForm() {
        loginPage.inputCredentials(emailToLog, passwdToLog)
                .clickSignInButton()
                .navigateToAdressesPage()
                .fillForm("aliasDoe", "Narrow Street", "456985", "Boston", "United Kingdom", "14725814");

    }






}
