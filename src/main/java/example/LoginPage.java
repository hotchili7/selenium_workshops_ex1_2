package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@class='form-control']")
    protected WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    protected WebElement passwdInput;

    @FindBy(id = "submit-login")
    protected WebElement signInButton;


    public LoginPage inputCredentials(String email, String password) {
        emailInput.sendKeys(email);
        passwdInput.sendKeys(password);
        return this;

    }

    public YouAccountPage clickSignInButton() {
        signInButton.click();
        return new YouAccountPage(driver);
    }


}