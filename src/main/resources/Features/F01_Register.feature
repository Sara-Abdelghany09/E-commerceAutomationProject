@Smoke
Feature: SignUp The guest user can create a new valid account

  Background:
    Given    The user clicks on Register

  Scenario Outline: Valid Sign Up :The user creates a valid account
    When User selects gender
    And user enter firstname and last name  and selects select date of birth
    And User enter a valid email as "<Email>"
    And User enters company name
    And newsletter is Unselected
    And User enters password and confirms it
    And user clicks the register button
    Then New account is created
    Examples:
    |Email                   |  Password      |ConfirmPassword   |
    |lara.sara44@gamil.com    |test123456789  |test123456789     |
