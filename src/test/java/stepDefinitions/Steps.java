package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Steps extends BaseTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Given("I am on a main page")
    public void iAmOnAMainPage() {
        this.visitTheApplication("https://katalon-demo-cura.herokuapp.com/");
        assertions.assertThatMainPageIsOpened();
    }

    @When("I click on Make Appointment button")
    public void iClickMakeAppointmentOnButton() {
        mainPage.navigateToLogInPage();
    }

    @And("I assert that log in panel is opened")
    public void iAssertThatLogInPanelIsOpened() {
        assertions.assertThatLoginPageIsOpened();
    }

    @And("I log in with valid credentials")
    public void iLogInWithValidCredentials() {
        loginPage.insertLoginAndPassword("John Doe", "ThisIsNotAPassword");
        loginPage.loginToSystem();
    }

    @And("I assert that log in is successful")
    public void iAssertThatLogInIsSuccessful() {
        assertions.assertThatAppointmentPageIsOpened();
    }

    @And("I fill and confirm the appointment")
    public void iFillAndConfirmTheAppointment() {
        appointmentPage.checkTheCheckBox();
        appointmentPage.selectRandomReadmission();
        appointmentPage.selectRandomProgram();
        appointmentPage.selectAppointmentDay();
        appointmentPage.leaveAComment();
        appointmentPage.bookAnAppointment();
    }

    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {
        assertions.assertThatAppointmentIsBookedSuccessfully();
    }
}
