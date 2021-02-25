@smokeTest
Feature: Menu

  Background:
    Given I am logged in prodtest

    Scenario: Check the hamburger menu
      When I click on hamburger menu
      Then Menu should contain next options:
        |Search|
        |Data Management|
        |Logout|


  Scenario: Checking version number
    When  I click on hamburger menu
    Then  Version has to be "v3.1.21"


