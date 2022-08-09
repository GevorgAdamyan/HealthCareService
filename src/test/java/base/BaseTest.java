package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import support.Assertions;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected AppointmentPage appointmentPage;
    protected SuccessPage successPage;
    protected Assertions assertions;


    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        appointmentPage = new AppointmentPage(driver);
        successPage = new SuccessPage(driver);
        assertions = new Assertions(driver);
    }

    public void visitTheApplication(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void tearDown() {
        driver.quit();
    }
}
