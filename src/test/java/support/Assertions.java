package support;

import org.openqa.selenium.WebDriver;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Assertions {
    WebDriver driver;

    MainPage mainPage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    SuccessPage successPage;

    public Assertions(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        appointmentPage = new AppointmentPage(driver);
        successPage = new SuccessPage(driver);
    }

    public void assertThatMainPageIsOpened() {
        assertTrue(mainPage.getMainPageHeader().isDisplayed());
        assertEquals(mainPage.getPageTitle(), "CURA Healthcare Service");
    }

    public void assertThatLoginPageIsOpened() {
        assertTrue(loginPage.getLoginPanel().isDisplayed());
        assertTrue(loginPage.getPageUrl().contains(("/profile.php#login")));
    }

    public void assertThatAppointmentPageIsOpened() {
        assertTrue(appointmentPage.getPageUrl().contains("#appointment"));
        assertTrue(appointmentPage.getAppointmentPanel().isDisplayed());
    }

    public void assertThatAppointmentIsBookedSuccessfully() {
        assertTrue(successPage.getInfoPanel().isDisplayed());
    }
}
