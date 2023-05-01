@tag
Feature: Calculate How much I could borrow?

  Background:
    Given I landed on Calculate How much I could borrow page

  Scenario Outline:

    Given I have entered person's following details: <application type>,  <Number of dependants>,  <Property you would like to buy> ,<Your annual income>, <Your annual other income>, <Monthly living expenses>, <Current home loan monthly repayments>, <Other loan monthly repayments>, <Other monthly commitments>, <Total Credit limits>
    When  I click on Work Out how much I could borrow button
    Then  Borrowing estimate is displayed on the screen "<result>"
    Examples:
      | application type | Number of dependants | Property you would like to buy | Your annual income | Your annual other income | Monthly living expenses | Current home loan monthly repayments | Other loan monthly repayments | Other monthly commitments | Total Credit limits | result   |
      | "Single"         | 0                    | "Home To Live In"              | "80000"            | "10000"                  | "500"                   | "0"                                  | "100"                         | "0"                       | "10002"             | $415,000 |


  Scenario Outline: Entering on monthly details

    Given I have entered person's following details:<monthly living expenses>
    When I click on Work Out how much I could borrow button
    Then Borrowing Error is displayed : <error>
    Examples:
      | monthly living expenses | error                                                                                                                                                             |
      | "1"                     | "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500." |
