Feature: Healthcare

  Scenario: As a user I should be able to creat a new appointment
    Given I am on a main page
    When I click on Make Appointment button
    And I assert that log in panel is opened
    And I log in with valid credentials
    And I assert that log in is successful
    And I fill and confirm the appointment
    Then I should see a success message