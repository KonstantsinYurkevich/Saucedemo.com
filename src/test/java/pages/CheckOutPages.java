package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPages extends BasePage {

    public static final By CONTINUE_BUTTON = By.cssSelector("#continue");
    public static final By FIRST_NAME = By.cssSelector("#first-name");
    public static final By LAST_NAME = By.cssSelector("#last-name");
    public static final By POSTAL_CODE = By.cssSelector("#postal-code");
    public static final By Error_Massage = By.cssSelector("[data-test='error']");

    public CheckOutPages(WebDriver driver) {
        super(driver);
    }

    public boolean pageOpened() {
        boolean pageOpened;
        try {
            waitPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Checkout: Your Information')]")));
            pageOpened = true;
        } catch (TimeoutException exception) {
            pageOpened = false;
        }
        return pageOpened;
    }

    public void openFirsCheckoutPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void checkOutUserData(String firstName, String LastName, String PostCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(LastName);
        driver.findElement(POSTAL_CODE).sendKeys(PostCode);
    }

    public void continueCheckout() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(Error_Massage).getText();

    }

}
