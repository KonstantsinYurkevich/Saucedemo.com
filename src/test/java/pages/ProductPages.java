package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductPages extends BasePage {
    public static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn_inventory");
    public static final By REMOVE_BUTTON = By.xpath("//*[contains(@name, 'remove')]");
    public static final By BACK_TO_PRODUCTS = By.cssSelector("#back-to-products");

    public ProductPages(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(By.xpath("//div[@class = 'inventory_details_name large_size']")).getText();
    }

    public void addToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public boolean pageOpened() {
        boolean pageOpened;
        try {
            waitPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
            pageOpened = true;
        } catch (TimeoutException exception) {
            pageOpened = false;
        }
        return pageOpened;
    }

    public void backToProducts() {
        driver.findElement(BACK_TO_PRODUCTS).click();
    }

    public void remove() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public boolean removeButtonIsDisplayed() {
        boolean buttonDisplayed;
        try {
            waitButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name, 'remove')]"))).isDisplayed();
            buttonDisplayed = true;
        } catch (TimeoutException exception) {
            buttonDisplayed = false;
        }
        return buttonDisplayed;
    }

}
