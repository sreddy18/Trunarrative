@run
Feature: Google Search

  Description:As a user I should be able to google search for trunarrative website and it should be my first search result in the page

  Scenario:<1>Google search shows trunarrative as first result
    Given  I am on the google page
    When the user enters text "TruNarrative" into the search bar
    And I click on google search button
    Then "TruNarrative" should be the first result on the search page
    And website link should be displayed as "https://trunarrative.com"

