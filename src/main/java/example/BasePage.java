package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(String elementXPath) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elementXPath))));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }






}
