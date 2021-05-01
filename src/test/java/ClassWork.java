import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ClassWork extends BaseTest {
    @Test
    public void locators() {
        driver.get("https://www.saucedemo.com/");
        String name = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name")).sendKeys(name);                              //1
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[type='submit']")).click();                      //2
        driver.findElement(By.id("react-burger-menu-btn")).click();
        List<WebElement> elem;
        elem = driver.findElements(By.xpath("//div/nav/a"));                                //3
        driver.findElement(By.id("react-burger-cross-btn")).click();
        List<WebElement> products;
        products = driver.findElements(By.className("inventory_item_name"));                //4
        products.get(4).click();
        driver.findElement(By.name("back-to-products")).click();                            //5
        List<WebElement> dropdown;
        dropdown = driver.findElements(By.tagName("option"));                               //6
        dropdown.get(2).click();
        driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();                 //7
        driver.findElement(By.cssSelector("[data-test='back-to-products']")).click();
        driver.findElement(By.partialLinkText("Backpack")).click();                         //8
        driver.findElement(By.cssSelector("[data-test='back-to-products']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();           //x1
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();       //x2
        List<WebElement> namesOfProducts;
        namesOfProducts = driver.findElements(By.xpath("//div[contains(@class,'item_name')]"));  //x3
        List<WebElement> allButtonsAddToCart;
        allButtonsAddToCart = driver.findElements(By.xpath("//button[contains(text(),'Add')]"));  //x4
        driver.findElement(By.xpath("//div[contains(text(),\"Backpack\")]")).click();
        String priceFromProductPage = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']//ancestor::div//div" +
                "[@class='inventory_details_price']")).getText();    //x5
        Assert.assertEquals(priceFromProductPage, "$29.99", "Price incorrect");
        driver.findElement(By.cssSelector("[data-test='back-to-products']")).click();
        List<WebElement> productSort;
        productSort = driver.findElements(By.xpath("//select[@class=\"product_sort_container\"]//descendant::option"));  //x6
        productSort.get(3).click();
        List<WebElement> sortedPriceFromHighToLow;
        sortedPriceFromHighToLow = driver.findElements(By.xpath("//div[@class=\"inventory_list\"]//following::div" +
                "[@class=\"inventory_item_price\"]"));   //x7
        List<WebElement> sortedItems;
        sortedItems = driver.findElements(By.xpath("//*[@class=\"inventory_item\"]/parent::div/child::div"));   //x8
        List<WebElement> list;
        list = driver.findElements(By.xpath("//a[contains(@id,'title_link')]//preceding::" +
                "div[@class=\"inventory_item\"]"));   //x9 ????
        List<WebElement> nameAndDescription;
        nameAndDescription = driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"] | " +
                "//div[@class=\"inventory_item_desc\"]"));  //x10
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();  //css1
        driver.findElement(By.cssSelector(".btn.back")).click();  //css2
        List<WebElement> elemsFromPageCss;
        elemsFromPageCss = driver.findElements(By.cssSelector(".inventory_list .inventory_item")); //css3
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click(); //css4
        driver.findElements(By.cssSelector("nav"));  //css5
        List<WebElement> elemsInBottomMenu;
        elemsInBottomMenu = driver.findElements(By.cssSelector("a.bm-item")); //css6
        List<WebElement> elemsInBottomMenue;
        elemsInBottomMenue = driver.findElements(By.cssSelector("nav a")); //css7
        driver.findElement(By.cssSelector("#react-burger-cross-btn")).click();
        List<WebElement> allNamesOfProducts;
        allNamesOfProducts = driver.findElements(By.cssSelector("a > div")); //css8
        List<WebElement> allDescriptions;
        allDescriptions = driver.findElements(By.cssSelector("a + div")); //css9
        List<WebElement> allButtonsCss;
        allButtonsCss = driver.findElements(By.cssSelector("div ~ button")); //css10
        List<WebElement> allIdFromMainPage;
        allIdFromMainPage = driver.findElements(By.cssSelector("[id]")); //css11
        List<WebElement> allPriceCss;
        allPriceCss = driver.findElements(By.cssSelector("[class=inventory_item_price]")); //css12
        List<WebElement> buttonsCss;
        buttonsCss = driver.findElements(By.cssSelector("[class~=btn]")); //css13
        List<WebElement> buttonsCSS;
        buttonsCSS = driver.findElements(By.cssSelector("[id|=add]")); //css14
        List<WebElement> directLinks;
        directLinks = driver.findElements(By.cssSelector("a[href^='http']")); // css15
        List<WebElement> endDirectLinks;
        endDirectLinks = driver.findElements(By.cssSelector("a[href$='saucelabs']")); //css16
        driver.findElement(By.cssSelector("a[href*='facebook']")); //css17


    }
}
