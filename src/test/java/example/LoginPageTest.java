package example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

   private LoginPage loginPage;


   @BeforeMethod
    public void before() {
       driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
       loginPage = new LoginPage(driver);
   }


   @Test
    public void shouldLoginUser() {

       String currentUser = loginPage.inputCredentials(emailToLog, passwdToLog).clickSignInButton().getCurrentUser();
       System.out.println(currentUser);
       Assert.assertEquals(currentUser, "John Doe");

   }



}
