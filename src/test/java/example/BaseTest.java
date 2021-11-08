package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;


    public final String emailToLog = "xhsduwlnslwcjuahrw@mrvpt.com";
    public final String passwdToLog = "doe123";


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }}
