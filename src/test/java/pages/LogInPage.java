package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MASSAGE = By.cssSelector("[data-test=error]");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open LogIn page")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    @Step("LogIn by user {user} and password {password}")
    public void logIn(String user, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR_MASSAGE).getText();
    }

    public boolean logInButtonIsDisplayed() {
        boolean buttonDisplayed;
        try {
            waitButton.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
            buttonDisplayed = true;
        } catch (TimeoutException exception) {
            buttonDisplayed = false;
        }
        return buttonDisplayed;
    }
}
