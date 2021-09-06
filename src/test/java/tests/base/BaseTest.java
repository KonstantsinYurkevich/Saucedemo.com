package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.internal.Configuration;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    public static final String USER = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRST_NAME = "Anton";
    public static final String LAST_NAME = "Frolov";
    public static final String POSTAL_CODE = "220123";
    protected WebDriver driver;
    protected LogInPage logInPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected ProductPages productPage;
    protected CheckOutPages checkoutPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser1, ITestContext testContext) {
        if (browser1.equals("chrome")) {
            DesiredCapabilities browser = new DesiredCapabilities();
            browser.setBrowserName("chrome");
            browser.setCapability("enableVNC", true);
            RemoteWebDriver driver = null;
            try {
                driver = new RemoteWebDriver(
                        URI.create("localhost:4444/wd/hub").toURL(),
                        browser
                );
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browser1.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            options.addPreference("disable_beforeunload", false);
            driver = new FirefoxDriver(options);
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
