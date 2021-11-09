package tests.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    public static final String USER = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRST_NAME = "Anton";
    public static final String LAST_NAME = "Frolov";
    public static final String POSTAL_CODE = "220123";
    public static RemoteWebDriver driver;
    protected LogInPage logInPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected ProductPages productPage;
    protected CheckOutPages checkoutPage;

    public static RemoteWebDriver getDriver(){
        return driver;
    }

    @BeforeSuite
    public void setUp() throws MalformedURLException {
         /*   WebDriverManager.chromedriver().setup();*/
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            driver = new RemoteWebDriver(new URL("http://selenoid:4444/wd/hub"),capabilities);
           /* driver = new ChromeDriver(options);*/
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInPage = new LogInPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPages(driver);
        checkoutPage = new CheckOutPages(driver);
    }

   /* @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+ "t");
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
        driver.close();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
    }*/

}
