package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

import static org.testng.Assert.assertEquals;

public class CheckOutPageTest extends BaseTest {
    @Test(description = "First name in checkout page - required", retryAnalyzer = Retry.class)
    public void filedFirstNameONFirstCheckoutPageShouldBeRequired() {
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.addToCart("Backpack");
        cartPage.open();
        checkoutPage.openFirsCheckoutPage();
        checkoutPage.checkOutUserData("", LAST_NAME, POSTAL_CODE);
        checkoutPage.continueCheckout();
        assertEquals(checkoutPage.getError(), "Error: First Name is required", "Error massage doesn't equals");

    }

    @Test(description = "Last name in checkout page - required", retryAnalyzer = Retry.class)
    public void filedLastNameONFirstCheckoutPageShouldBeRequired() {
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.addToCart("Backpack");
        cartPage.open();
        checkoutPage.openFirsCheckoutPage();
        checkoutPage.checkOutUserData(FIRST_NAME, "", POSTAL_CODE);
        checkoutPage.continueCheckout();
        assertEquals(checkoutPage.getError(), "Error: Last Name is required", "Error massage doesn't equals");

    }

    @Test(description = "Zip code in checkout page - required", retryAnalyzer = Retry.class)
    public void filedPostCodeONFirstCheckoutPageShouldBeRequired() {
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.addToCart("Backpack");
        cartPage.open();
        checkoutPage.openFirsCheckoutPage();
        checkoutPage.checkOutUserData(FIRST_NAME, LAST_NAME, "");
        checkoutPage.continueCheckout();
        assertEquals(checkoutPage.getError(), "Error: Postal Code is required", "Error massage doesn't equals");

    }
}
