Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    And I enter email "nozishka86@gmail.com"
    And I enter password "te$t$tudent"
    When I click Log In button
    Then I am logged in

  Scenario: Login with Wrong Password
    Given I open Login Page
    And I enter email "nozishka86@gmail.com"
    And I enter password "te$t$tuden"
    When I click Log In button
    Then I am NOT logged in

   Scenario: Login with Wrong Email
     Given I open Login Page
     And I enter email "nozishka8@gmail.com"
     And I enter password "te$t$tudent"
     When I click Log In button
     Then I am NOT logged in

  Scenario: Login with Empty Credentials
    Given I open Login Page
    And I enter email ""
    And I enter password ""
    When I click Log In button
    Then I am NOT logged in  