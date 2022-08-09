package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    WebDriver driver;

    private By makeAppointmentBtn = By.id("btn-make-appointment");
    private By mainPageHeader = By.className("text-vertical-center");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMainPageHeader() {
        return driver.findElement(mainPageHeader);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void navigateToLogInPage() {
        driver.findElement(makeAppointmentBtn).click();
    }
}
