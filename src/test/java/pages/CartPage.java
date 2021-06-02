package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class CartPage extends BasePage {
    public static final By CHECKOUT_BUTTON = By.cssSelector("#checkout");
    public static final By CONTINUE_SHOPPING = By.cssSelector("#continue-shopping");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open cart page")
    public void open() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Step("Checking that cart page is opened")
    public boolean pageOpened() {
        boolean pageOpened;
        try {
            waitPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your Cart')]")));
            pageOpened = true;
        } catch (TimeoutException exception) {
            pageOpened = false;
        }
        return pageOpened;
    }

    @Step("Click checkout button on cart page")
    public void checkout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void remove(String itemName) {
        itemName = itemName.toLowerCase(Locale.ROOT);
        String removeButton = "//*[contains(@name, '" + itemName + "')]";
        driver.findElement(By.xpath(removeButton)).click();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public String getProductName(String name) {
        String nameProduct = "//div[contains(text(),'" + name + "')]";
        return driver.findElement(By.xpath(nameProduct)).getText();
    }
}
