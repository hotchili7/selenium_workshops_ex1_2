package example;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SummaryOrderPageTest extends BaseTest{

    public MainPage mainPage;
    public LoginPage loginPage;
    public YouAccountPage youAccountPage;
    public ShoppingCartPage shoppingCartPage;
    public SummaryOrderPage summaryOrderPage;




    @BeforeMethod
    public void before() {

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        loginPage = new LoginPage(driver);
    }




    @Test
    public void shoulAddItemToCartAndDisplayShoppingCartTest() throws IOException {

        loginPage.inputCredentials(emailToLog, passwdToLog)
                .clickSignInButton()
                .navigateToMainPage()
                .searchForItem("Hummingbird printed sweater")
                .addProductToCart("Hummingbird printed sweater", "M", "5")
                .proceedToCheckout()
                .proceedToOrderPage()
                .clickOnContinueAddressesButton()
                .clickOnContinueShippingButton()
                .clickOnPayByCheckButtonAndCheckbox()
                .takeSnapShot();

    }
}
