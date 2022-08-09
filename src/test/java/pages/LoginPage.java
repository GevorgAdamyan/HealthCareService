package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    private By loginPanel = By.className("form-horizontal");
    private By loginField = By.id("txt-username");
    private By passwordFiled = By.id("txt-password");
    private By loginBtn = By.id("btn-login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginPanel() {
        return driver.findElement(loginPanel);
    }

    public void insertLoginAndPassword(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordFiled).sendKeys(password);
    }

    public void loginToSystem() {
        driver.findElement(loginBtn).click();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

}
