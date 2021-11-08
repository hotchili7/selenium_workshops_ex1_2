package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class='text-sm-center']/a")
    protected WebElement proceedToCheckoutButton;


    public SummaryOrderPage proceedToOrderPage() {
        waitForVisibility(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return new SummaryOrderPage(driver);
    }

}
