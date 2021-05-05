package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPages extends BasePages {
    public static final  By ADD_TO_CART_BUTTON = By.cssSelector(".btn_inventory") ;
    public static final  By REMOVE_BUTTON = By.xpath("//*[contains(@name, 'remove')]") ;
    public static final By BACK_TO_PRODUCTS = By.cssSelector("#back-to-products");

    public ProductPages(WebDriver driver) {
        super(driver);
    }


    public void addToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();

    }

    public void backToProducts() {
        driver.findElement(BACK_TO_PRODUCTS).click();
    }
    public void remove(){
        driver.findElement(REMOVE_BUTTON).click();
    }

}
