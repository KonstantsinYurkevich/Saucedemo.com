package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import tests.base.TestListener;

@Listeners(TestListener.class)
public abstract class BasePage {
    public static final By ALL_ITEMS = By.id("inventory_sidebar_link");
    public static final By ABOUT = By.id("about_sidebar_link");
    public static final By LOG_OUT = By.id("logout_sidebar_link");
    public static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    RemoteWebDriver driver;
    WebDriverWait waitPageLoad;
    WebDriverWait waitButton;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        waitPageLoad = new WebDriverWait(driver, 10);
        waitButton = new WebDriverWait(driver, 2);

    }
    @Step("Checking that burger menu is displayed")
    public boolean burgerMenuIsDisplayed() {
        boolean burgerMenuIsDisplayed;
        try {
            waitButton.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bm-burger-button"))).isDisplayed();
            burgerMenuIsDisplayed = true;
        } catch (TimeoutException exception) {
            burgerMenuIsDisplayed = false;
        }
        return burgerMenuIsDisplayed;

    }

    public boolean burgerMenuIsHidden() {
        boolean burgerMenuIsHidden;
        try {
            driver.findElement((By.cssSelector("[aria-hidden = 'true']")));
            burgerMenuIsHidden = true;
        } catch (TimeoutException exception) {
            burgerMenuIsHidden = false;
        }
        return burgerMenuIsHidden;

    }

    @Step("Open burger menu")
    public void burgerMenuOpen() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @Step("Checking that burger menu is opened")
    public boolean burgerMenuIsOpened() {
        boolean burgerMenuIsHidden;
        try {
            driver.findElement((By.cssSelector("[aria-hidden = 'false']")));
            burgerMenuIsHidden = true;
        } catch (TimeoutException exception) {
            burgerMenuIsHidden = false;
        }
        return burgerMenuIsHidden;

    }

    public void burgerMenuClose() {
        driver.findElement(By.id("react-burger-cross-btn")).click();
    }

    @Step("Click on button Log out in burger menu")
    public void burgerMenuButtonLogOutClick() {
        driver.findElement(LOG_OUT).click();
    }

    @Step("Click on button all items in burger menu")
    public void burgerMenuButtonAllItemsClick() {
        driver.findElement(ALL_ITEMS).click();
    }

    public void burgerMenuButtonResetAppStateClick() {
        driver.findElement(RESET_APP_STATE).click();
    }

    public void burgerMenuButtonAboutClick() {
        driver.findElement(ABOUT).click();
    }

}
