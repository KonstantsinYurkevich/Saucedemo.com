package tests;

import org.testng.annotations.Test;

public class TestFieldOnFirstCheckoutPage extends BaseTest {
    @Test
    public void filedONFirstCheckoutPageShouldBeRequired() {
        logInPage.open();
        logInPage.logIn(USER, PASSWORD);
        productsPage.addToCart("Backpack");
        cartPage.open();
        checkoutPage.openFirsCheckoutPage();
        checkoutPage.checkOutUserData(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        checkoutPage.continueCheckout();
    }
}
