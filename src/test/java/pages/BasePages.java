package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePages {
    WebDriver driver;

    public BasePages(WebDriver driver){
        this.driver=driver;

    }
}
