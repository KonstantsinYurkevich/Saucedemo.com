package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void productShouldBeAddedIntoCart() {
        String testProduct = "Jacket";
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.addToCart(testProduct);
        productsPage.remove(testProduct);
        productsPage.open(testProduct);
        productPage.addToCart();
        productPage.backToProducts();
        productPage.remove();
        cartPage.open();
        cartPage.continueShopping();
        productsPage.addToCart(testProduct);
        cartPage.open();
        cartPage.remove(testProduct);
        cartPage.continueShopping();
        productsPage.addToCart(testProduct);
        cartPage.open();
        cartPage.checkout();

    }
}
