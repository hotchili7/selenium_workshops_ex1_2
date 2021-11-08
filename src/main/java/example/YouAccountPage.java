package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouAccountPage extends BasePage {

    public YouAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//i[contains(@class,'hidden-md-up')]//following-sibling::span")
    protected WebElement customerAccount;

    @FindBy(xpath = "//header[@class='page-header']/h1")
    protected WebElement yourAccountLabel;

    @FindBy(id = "_desktop_logo")
    protected  WebElement desktopLogo;

    @FindBy(xpath = "//a[@id='address-link']/span/i")
    protected WebElement addressButton;


    public String getCurrentUser() {
        waitForVisibility(yourAccountLabel);
        return customerAccount.getText();

    }


    public AddressesPage navigateToAdressesPage(){
        addressButton.click();
        return new AddressesPage(driver);
    }

    public MainPage navigateToMainPage() {
        desktopLogo.click();
        return new MainPage(driver);

    }
}
