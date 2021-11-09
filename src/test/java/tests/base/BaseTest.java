package tests.base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    public static final String USER = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRST_NAME = "Anton";
    public static final String LAST_NAME = "Frolov";
    public static final String POSTAL_CODE = "220123";
    protected RemoteWebDriver driver;
    protected LogInPage logInPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected ProductPages productPage;
    protected CheckOutPages checkoutPage;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws MalformedURLException {
        if (browser.equals("chrome")) {
         /*   WebDriverManager.chromedriver().setup();*/
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            driver = new RemoteWebDriver(new URL("http://selenoid:4444/wd/hub"),capabilities);
           /* driver = new ChromeDriver(options);*/
            driver.manage().window().maximize();
        } else if (browser.equals("firefox")) {
           /* WebDriverManager.firefoxdriver().setup();*/
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("moz:firefoxOptions", new HashMap<String, Object>(){
                {
                    put("prefs", new HashMap<String, Object>(){
                        {
                            put("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
                        }
                    });
                }
            });
            driver = new RemoteWebDriver(new URL("http://selenoid:4444/wd/hub"), firefoxOptions);
            driver.manage().window().maximize();
        }
        testContext.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInPage = new LogInPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPages(driver);
        checkoutPage = new CheckOutPages(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
