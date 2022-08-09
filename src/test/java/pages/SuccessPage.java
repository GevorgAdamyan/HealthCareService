package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

public class SuccessPage {
    WebDriver driver;

    private By successPanel = By.className("row");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInfoPanel() {
        return driver.findElement(successPanel);
    }
}
