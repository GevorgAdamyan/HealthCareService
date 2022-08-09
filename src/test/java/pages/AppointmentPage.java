package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Utils;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;


public class AppointmentPage {
    WebDriver driver;

    private By appointmentPanel = By.className("form-horizontal");
    private By medCenterDropdown = By.id("combo_facility");
    private By medCenters = By.cssSelector("#combo_facility > option");
    private By readmissionChkBx = By.id("chk_hospotal_readmission");
    private By programRadios = By.cssSelector(".radio-inline > input");
    private By dayInputField = By.id("txt_visit_date");
    private By days = By.className("day");
    private By commentField = By.id("txt_comment");
    private By bookBtn = By.id("btn-book-appointment");


    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAppointmentPanel() {
        return driver.findElement(appointmentPanel);
    }

    private void openDropdown() {
        driver.findElement(medCenterDropdown).click();
    }

    private List<WebElement> getDropdownOptions() {
        this.openDropdown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(medCenters));
        return driver.findElements(medCenters);
    }

    public List<WebElement> getProgramRadios() {
        return driver.findElements(programRadios);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    private void selectRandomOption(List<WebElement> options) {
        int index = (int) Math.round(Math.random() * (options.size() - 1));
        options.get(index).click();
    }

    public void selectRandomReadmission() {
        this.selectRandomOption(this.getDropdownOptions());
    }

    public void selectRandomProgram() {
        this.selectRandomOption(this.getProgramRadios());
    }

    public void checkTheCheckBox() {
        int num = (int) Math.round(Math.random());
        if (num == 0)
            driver.findElement(readmissionChkBx).click();
    }

    private void openTheCalendar() {
        driver.findElement(dayInputField).click();
    }

    private List<WebElement> getDays() {
        this.openTheCalendar();
        return driver.findElements(days);
    }

    public void selectAppointmentDay() {
        int today = LocalDate.now().getDayOfMonth();
        this.getDays().get(today + 3).click();
    }

    public void leaveAComment() {
        driver.findElement(commentField).sendKeys(Utils.getRandomComment());
    }

    public void bookAnAppointment() {
        driver.findElement(bookBtn).click();
    }
}
