Feature: Login feature

  Scenario: Login Sucess
    Given I open browser
    And I open Login Page
    When I enter email "khushbu07@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in