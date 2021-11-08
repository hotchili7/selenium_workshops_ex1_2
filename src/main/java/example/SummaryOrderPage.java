package example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class SummaryOrderPage extends BasePage{
    public SummaryOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@name='confirm-addresses']")
    protected WebElement continueAdressesButton;


    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    protected WebElement continueShippingButton;

    @FindBy(xpath = "//input[@id='payment-option-1']")
    protected WebElement payByCheckButton;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    protected WebElement termsCheckbox;

    @FindBy(xpath = "//div[@class='ps-shown-by-js']/button")
    protected WebElement orderButton;


    public SummaryOrderPage clickOnContinueAddressesButton() {
        waitForVisibility(continueAdressesButton);
        continueAdressesButton.click();
        return this;
    }

    public SummaryOrderPage clickOnContinueShippingButton() {
        waitForVisibility(continueShippingButton);
        continueShippingButton.click();
        return this;
    }

    public SummaryOrderPage clickOnPayByCheckButtonAndCheckbox() {
        waitForVisibility(orderButton);
        payByCheckButton.click();
        termsCheckbox.click();
        orderButton.click();
        return this;
    }

    public void takeSnapShot() throws IOException {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
    }











}
