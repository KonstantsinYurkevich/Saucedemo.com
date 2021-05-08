package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait waitPageLoad;
    WebDriverWait waitButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitPageLoad = new WebDriverWait(driver, 10);
        waitButton = new WebDriverWait(driver, 3);

    }
}
