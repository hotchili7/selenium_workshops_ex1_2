package example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage{




    public MainPage(WebDriver driver) {
        super(driver);
    }






    @FindBy(xpath = "//input[@class='ui-autocomplete-input']")
    protected WebElement searchInput;

    @FindBy(xpath = "//a[contains(text(), 'Hummingbird printed sweater')]")
    protected WebElement hummingbirdPrintedSwater;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    protected WebElement addToCartButton;

    @FindBy(xpath = "//a/span[@class='hidden-sm-down']")
    protected WebElement signInButton;

    @FindBy(id = "group_1")
    protected WebElement sizeSelect;

    @FindBy(xpath = "//span[@class='input-group-btn-vertical']/button/i[contains(@class, 'touchspin-up')]")
    protected WebElement quantityTouchspinUpButton;

    @FindBy(id = "quantity_wanted")
    protected WebElement quantityInput;

    @FindBy(xpath = "//h6[contains(@class,'product-name')]")
    protected WebElement itemTitleSummary;

    @FindBy(xpath = "//a[contains(@class, 'btn-primary')]")
    protected WebElement proceedToCheckoutButton;



//    ---- select option size

    public List<String> getNamesOfSelectOptions(WebElement select) {
        Select sizes = new Select(select);

        List<WebElement> elementsOfDropdown = sizes.getOptions();
        return elementsOfDropdown.stream().map(element -> element.getAttribute("value")).collect(Collectors.toList());
    }

    public List<String> getNamesOfSizes() {
        return getNamesOfSelectOptions(sizeSelect);
    }

    public void selectOption(WebElement select, String option) {
        Select elements = new Select(select);
        elements.selectByVisibleText(option);
    }

    public MainPage selectOptionSize(String option) {
        sizeSelect.click();
        selectOption(sizeSelect, option);
        return this;

    }
//    -----



    public MainPage searchForItem(String item) {
        searchInput.click();
        searchInput.sendKeys(item);
        searchInput.sendKeys(Keys.ENTER);
        return this;

    }

//
//    public MainPage selectQuantity() {
//        quantityTouchspinUpButton.click();
//    }

    public MainPage addProductToCart(String item, String size, String qty) {
        hummingbirdPrintedSwater.click();
        waitForVisibility(addToCartButton);
        selectOptionSize(size);
        setQuantityForProduct(qty);
        addToCartButton.click();
        return this;
    }

//    public YouAccountPage clickSignInButton() {
//        signInButton.click();
//        return new YouAccountPage(driver);
//    }

    public MainPage setQuantityForProduct(String qty) {
        quantityInput.clear();
        quantityInput.sendKeys(qty);
        return this;
    }

    public String getTextFromitemTitleSummmary() {
        driver.switchTo().activeElement();
        waitForVisibility(proceedToCheckoutButton);
        waitForVisibility(itemTitleSummary);
        return itemTitleSummary.getText();
    }

    public ShoppingCartPage proceedToCheckout() {
        driver.switchTo().activeElement();
        waitForVisibility(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return new ShoppingCartPage(driver);

    }






}
