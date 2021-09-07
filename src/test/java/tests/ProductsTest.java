package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {


    @Test(description = "Button remove displayed on added product")
    public void afterAddingProductFromProductsPageButtonRemoveDisplayed() {
        String testProduct = "Jacket";
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.addToCart(testProduct);
        assertTrue(productsPage.removeButtonIsDisplayed(testProduct), "Button remove after click on add to cart button" +
                " doesn't displayed");

    }

    @Test(description = "Adding product from products page")
    public void productShouldBeAddedIntoCartFromProductsPage() {
        String testProduct = "Jacket";
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        assertTrue(productsPage.pageOpened(), "Products page doesn't open");
        productsPage.addToCart(testProduct);
        String nameFromProductsPage = productsPage.getProductName(testProduct);
        cartPage.open();
        assertTrue(cartPage.pageOpened(), "Cart page doesn't open");
        String nameFromCartPage = cartPage.getProductName(testProduct);
        assertEquals(nameFromCartPage, nameFromProductsPage, "Product  that added to the cart from it's page and " +
                "in cart doesn't match");
    }

    @Test(description = "Product page opened after click on it from products page")
    public void productPageShouldBeOpenedFromProductsPage() {
        String testProduct = "Jacket";
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        String fromProductsPage = productsPage.getProductName(testProduct);
        productsPage.openProduct(testProduct);
        String fromProductPage = productsPage.getProductName(testProduct);
        assertEquals(fromProductsPage, fromProductPage, "Product page doesn't open");
    }

    @Test(description = "Adding product  from  product  page")
    public void productShouldBeAddedToCartFromProductPage() {
        String testProduct = "Jacket";
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.openProduct(testProduct);
        assertTrue(productPage.pageOpened(), "Product page doesn't open");
        productPage.addToCart();
        String nameFromProductPage = productPage.getProductName();
        cartPage.open();
        String nameFromCartPage = cartPage.getProductName(testProduct);
        assertEquals(nameFromCartPage, nameFromProductPage, "Product  that added to the cart from it's page and " +
                "in cart doesn't match");
    }
}
