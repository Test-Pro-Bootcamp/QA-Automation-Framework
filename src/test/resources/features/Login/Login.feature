Feature: Login feature

  Scenario: Login Success
    Given I open Browser
    And I open Login Page
    When I enter email "dankoyanka@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in
