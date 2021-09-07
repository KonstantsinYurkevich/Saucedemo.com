package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser, ITestContext testContext) throws MalformedURLException {
        if (browser.equals("chrome")) {
         /*   WebDriverManager.chromedriver().setup();*/

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", new HashMap<String, Object>(){
                {
                    put("profile.default_content_settings.popups", 0);
                    put("download.default_directory", "/home/selenium/Downloads");
                    put("download.prompt_for_download", false);
                    put("download.directory_upgrade", true);
                    put("safebrowsing.enabled", false);
                    put("plugins.always_open_pdf_externally", true);
                    put("plugins.plugins_disabled", new ArrayList<String>(){
                        {
                            add("Chrome PDF Viewer");
                        }
                    });
                }
            });
            driver = new RemoteWebDriver(new URL("http://192.168.116.113:4444/wd/hub"),options);
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


            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
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
