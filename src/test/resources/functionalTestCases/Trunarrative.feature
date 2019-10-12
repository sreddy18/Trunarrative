@run
Feature: Trunarrative feature

  Description:As a user when i click on https://trunarrative.com ,the website strapline should be displayed

  Background:User on google search results page
    Given  I am on the google page
    When the user enters text "TruNarrative" into the search bar
    And I click on google search button
    Then "TruNarrative" should be the first result on the search page
    And website link should be displayed as "https://trunarrative.com"


  Scenario: Navigate to TruNarrative website
    When I click on TruNarrative web link
    Then TruNarrative website with title "TruNarrative | Who, What and When | Fraud and Compliance Risk Solution" should be displayed
    And the strap line "Easy Onboarding.  Smooth Transactions.  Insightful Compliance." below text should be displayed on the home page


  Scenario:TruNarrative team members
    When I click on TruNarrative web link
    Then TruNarrative website with title "TruNarrative | Who, What and When | Fraud and Compliance Risk Solution" should be displayed
    And TruNarrative team should include the following team members
      | John Lord      | Founder & CEO            |
      | Nicola Janney  | Human Resources Manager  |
      | David Eastaugh | Chief Technology Officer |
