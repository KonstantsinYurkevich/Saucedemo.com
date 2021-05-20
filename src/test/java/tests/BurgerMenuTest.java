package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BurgerMenuTest extends BaseTest {

    @DataProvider(name = "Log in data")
    public Object[][] logInaData() {
        return new Object[][]{
                {"", PASSWORD, "User name should be required" },
                {USER, "", "Password should be required" },
                {USER, "asddsadas", "Epic sadface: Username and password do not match any user in this service" },
                {"qweqweqw", PASSWORD, "Epic sadface: Sorry, this user has been locked out." },
        };
    }

    @Test(description = "User name should be required", dataProvider = "Log in data")
    public void logInTest(String user, String password, String errorMessage) {
        logInPage.open();
        logInPage.logIn(user, password);
        String error = logInPage.getError();
        assertEquals(error, errorMessage);

    }

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
