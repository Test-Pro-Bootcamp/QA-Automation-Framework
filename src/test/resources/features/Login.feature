Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "kaflimeerim@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

