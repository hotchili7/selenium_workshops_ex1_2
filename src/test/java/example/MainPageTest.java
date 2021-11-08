package example;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest{

    public MainPage mainPage;
    public LoginPage loginPage;
    public YouAccountPage youAccountPage;
    public ShoppingCartPage shoppingCartPage;




    @BeforeMethod
    public void before() {

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        loginPage = new LoginPage(driver);
    }




    @Test
    public void shoulAddItemToCartAndDisplayShoppingCartTest() {

        loginPage.inputCredentials(emailToLog, passwdToLog)
                .clickSignInButton()
                .navigateToMainPage()
                .searchForItem("Hummingbird printed sweater")
                .addProductToCart("Hummingbird printed sweater", "M", "5")
                .proceedToCheckout();
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("action=show"));
//        System.out.println(driver.getCurrentUrl());
        String URL = driver.getCurrentUrl();

        Assert.assertEquals(URL, "https://mystore-testlab.coderslab.pl/index.php?controller=cart&action=show");

    }

}
