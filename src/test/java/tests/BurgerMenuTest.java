package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BurgerMenuTest extends BaseTest {

    @DataProvider(name = "Login data")
    public Object[][] logInaData() {
        return new Object[][]{
                {"", PASSWORD, "Epic sadface: Username is required"},
                {USER, "", "Epic sadface: Password is required"},
                {USER, "asddsadas", "Epic sadface: Username and password do not match any user in this service"},
                {"qweqweqw", PASSWORD, "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test(description = "Login tests", dataProvider = "Login data")
    public void logInTest(String user, String password, String errorMessage) {
        logInPage.open();
        logInPage.logIn(user, password);
        String error = logInPage.getError();
        assertEquals(error, errorMessage);
    }

    @Test(description = "Logout test")
    public void logOutTest() {
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.burgerMenuOpen();
        productsPage.burgerMenuButtonLogOutClick();
        assertTrue(logInPage.logInButtonIsDisplayed(), "log out doesn't work");
    }

    @Test(description = "Burger menu opens on each page and it's tabs opens")
    public void burgerMenuButtonAllItemsWorksFromAnyPageWhileLogIn() {
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.openProduct("Backpack");
        assertTrue(productPage.burgerMenuIsDisplayed(), "burger menu doesn't displayed");
        productPage.burgerMenuOpen();
        assertTrue(productPage.burgerMenuIsOpened(), "burger menu doesn't open");
        productPage.burgerMenuButtonAllItemsClick();
        assertTrue(productsPage.pageOpened(), "Button All Items doesn't work from product page");
        cartPage.open();
        assertTrue(cartPage.burgerMenuIsDisplayed(), "burger menu doesn't displayed");
        cartPage.burgerMenuOpen();
        assertTrue(productPage.burgerMenuIsOpened(), "burger menu doesn't open");
        cartPage.burgerMenuButtonAllItemsClick();
        assertTrue(productsPage.pageOpened(), "Button All Items doesn't work from cart page");
        cartPage.open();
        cartPage.checkout();
        assertTrue(checkoutPage.burgerMenuIsDisplayed(), "burger menu doesn't displayed");
        checkoutPage.burgerMenuOpen();
        assertTrue(productPage.burgerMenuIsOpened(), "burger menu doesn't open");
        checkoutPage.burgerMenuButtonAllItemsClick();
        assertTrue(productsPage.pageOpened(), "Button All Items doesn't work from cart page");

    }
}
