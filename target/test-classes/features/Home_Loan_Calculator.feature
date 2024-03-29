@tag
Feature: Calculate How much I could borrow?

  Background:
    Given I landed on Calculate How much I could borrow page

  Scenario Outline: Checking if Borrowing Amount is displayed
    Given I have entered person's following details: <application type>,  <Number of dependants>,  <Property you would like to buy> ,<Your annual income>, <Your annual other income>, <Monthly living expenses>, <Current home loan monthly repayments>, <Other loan monthly repayments>, <Other monthly commitments>, <Total Credit limits>
    When  I click on Work Out how much I could borrow button
    Then  Borrowing estimate is displayed on the screen "<amount>"
    And   I click on start over button for Form reset
    Examples:
      | application type | Number of dependants | Property you would like to buy | Your annual income | Your annual other income | Monthly living expenses | Current home loan monthly repayments | Other loan monthly repayments | Other monthly commitments | Total Credit limits | amount   |
      | "Single"         | 0                    | "Home To Live In"              | "80000"            | "10000"                  | "500"                   | "0"                                  | "100"                         | "0"                       | "10002"             | $415,000 |


  Scenario Outline: Checking if Borrowing estimate Error is displayed
    Given I have entered person's following details:<monthly living expenses>
    When I click on Work Out how much I could borrow button
    Then Borrowing Error is displayed : <error>
    Examples:
      | monthly living expenses | error                                                                                                                                                             |
      | "$1"                    | "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500." |
