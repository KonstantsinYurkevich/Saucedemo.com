package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open(String name) {
        String openButton = "//*[contains(text(),'" + name + "')]/ancestor::a[contains(@id,'link')]";
        driver.findElement(By.xpath(openButton)).click();
    }

    public void addToCart(String name) {
        driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]//ancestor::div/div/button[contains(@class," +
                "'btn')]")).click();
    }

    public void remove(String itemName) {
        itemName = itemName.toLowerCase(Locale.ROOT);
        String removeButton = "//*[contains(@name, '" + itemName + "')]";
        driver.findElement(By.xpath(removeButton)).click();
    }
}
