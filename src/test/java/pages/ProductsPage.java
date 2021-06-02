package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageOpened() {
        boolean pageOpened;
        try {
            waitPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Products')]")));
            pageOpened = true;
        } catch (TimeoutException exception) {
            pageOpened = false;
        }
        return pageOpened;
    }

    @Step("Open product {name} page")
    public void openProduct(String name) {
        String openButton = "//*[contains(text(),'" + name + "')]/ancestor::a[contains(@id,'link')]";
        driver.findElement(By.xpath(openButton)).click();
    }

    @Step("Add product {name} into cart")
    public void addToCart(String name) {
        driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]//ancestor::div/div/button[contains(@class," +
                "'btn')]")).click();
    }

    public void remove(String itemName) {
        itemName = itemName.toLowerCase(Locale.ROOT);
        String removeButton = "//*[contains(@name, '" + itemName + "')]";
        driver.findElement(By.xpath(removeButton)).click();
    }

    public String getProductName(String name) {
        String nameProduct = "//*[contains(text(),'" + name + "')]";
        return driver.findElement(By.xpath(nameProduct)).getText();
    }

    @Step("Checking remove button is displayed on products page")
    public boolean removeButtonIsDisplayed(String name) {
        boolean buttonDisplayed;
        try {
            waitButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + name
                    + "')]//ancestor::div/div/button[contains(@name,'remove')]"))).isDisplayed();
            buttonDisplayed = true;
        } catch (TimeoutException exception) {
            buttonDisplayed = false;
        }
        return buttonDisplayed;
    }
}
