import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTaskTest extends BaseTest {
    @Test
    public void homeTest() {
        driver.get("https://www.saucedemo.com/");
        String name = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        List<WebElement> allPrice;
        allPrice = driver.findElements(By.cssSelector("[class='inventory_item_price']"));
        String priceOnPage = allPrice.get(3).getText();
        String nameOfProduct = driver.findElement(By.cssSelector("#item_5_title_link > div")).getText();
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
        boolean buttonClicked = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Fleece Jacket')]/ancestor" +
                "::div//button[text()='Remove']")).isDisplayed();
        Assert.assertTrue(buttonClicked, "Button add to cart doesn't work");
        driver.findElement(By.cssSelector(".shopping_cart_container")).click();
        String cart = driver.findElement(By.cssSelector("[class='title']")).getText();
        Assert.assertEquals(cart, "YOUR CART", "cart doesn't open");
        String fromCartPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        String fromCartName = driver.findElement(By.cssSelector("div>a div")).getText();
        Assert.assertEquals(fromCartPrice, priceOnPage, "incorrect price in cart and on product pages");
        Assert.assertEquals(fromCartName, nameOfProduct, "incorrect name in cart and on product pages");

    }
}
