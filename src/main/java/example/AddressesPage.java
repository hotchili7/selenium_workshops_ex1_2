package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressesPage extends BasePage {
    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='alias']")
    protected WebElement aliasInput;

    @FindBy(xpath = "//input[@name='address1']")
    protected WebElement address1Input;

    @FindBy(xpath = "//input[@name='postcode']")
    protected WebElement postcodeInput;

    @FindBy(xpath = "//input[@name='city']")
    protected WebElement cityInput;

    @FindBy(xpath = "//select[@name='id_country']")
    protected WebElement countrySelect;

    @FindBy(xpath = "//input[@name='phone']")
    protected WebElement phoneInput;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    protected WebElement saveButton;

    @FindBy(xpath = "//article[@data-alert='success']/ul/li")
    protected WebElement greenMessageAlert;


    public void inputAlias(String alias) {
        aliasInput.sendKeys(alias);
    }

    public void inputAddress(String address) {
        address1Input.sendKeys(address);
    }

    public void inputPostalcode(String code) {
        postcodeInput.sendKeys(code);
    }

    public void inputCity(String city) {
        cityInput.sendKeys(city);
    }

    public void selectCountryByName(String country) {
        Select countrys = new Select(countrySelect);
        countrys.selectByVisibleText(country);
    }

    public void inputPhone(String number) {
        phoneInput.sendKeys(number);
    }

    public void fillForm(String alias, String address, String code, String city, String country, String number) {
        inputAlias(alias);
        inputAddress(address);
        inputPostalcode(code);
        inputCity(city);
        selectCountryByName(country);
        inputPhone(number);
        saveButton.click();
    }

    public AddressesPage clickOnSaveAddressButton() {
        saveButton.click();
        return this;
    }

    public String getMessageFromGreenBox() {
        waitForVisibility(greenMessageAlert);
        System.out.println(greenMessageAlert.getText());
        return greenMessageAlert.getText();
    }







}
