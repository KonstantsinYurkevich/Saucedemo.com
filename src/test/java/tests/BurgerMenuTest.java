package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BurgerMenuTest extends BaseTest {
    @Test
    public void logOutTest() {
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.burgerMenuOpen();
        productsPage.burgerMenuButtonLogOutClick();
        assertTrue(logInPage.logInButtonIsDisplayed(), "log out doesn't work");
    }

    @Test
    public void burgerMenuButtonAllItemsWorksFromAnyPageWhileLogIn() {
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.openProduct("Backpack");
        productPage.burgerMenuOpen();
        assertTrue(productPage.burgerMenuIsOpened(), "burger menu doesn't open");
        productPage.burgerMenuButtonAllItemsClick();
        assertTrue(productsPage.pageOpened(), "Button All Items doesn't work from product page");
        cartPage.open();
        cartPage.burgerMenuOpen();
        assertTrue(productPage.burgerMenuIsOpened(), "burger menu doesn't open");
        cartPage.burgerMenuButtonAllItemsClick();
        assertTrue(productsPage.pageOpened(), "Button All Items doesn't work from cart page");
        cartPage.open();
        cartPage.checkout();
        checkoutPage.burgerMenuOpen();
        assertTrue(productPage.burgerMenuIsOpened(), "burger menu doesn't open");
        checkoutPage.burgerMenuButtonAllItemsClick();
        assertTrue(productsPage.pageOpened(), "Button All Items doesn't work from cart page");

    }
}
