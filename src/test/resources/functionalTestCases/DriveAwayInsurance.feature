@run
Feature: Drive Away Insurance

  Description:As a user of the insurance portal when I enter vehicle registration no in the dealer portal it should display
  vehicle cover start and end dates

  Background:
    Given I am on the insurance "Dealer Portal" page

  Scenario: <1> Check for vehicle cover with valid vehicle registration no
    When I enter valid vehicle registration no "OV12UYY"
    And I click on the find vehicle button
    Then the vehicle "Cover start:  09 FEB 2022 : 16 : 26" and "Cover end:    18 FEB 2022 : 23 : 59" dates should be displayed

  Scenario Outline: <id> Check for vehicle cover with invalid vehicle registration no
    When I enter valid vehicle registration no "<registrationNo>"
    And I click on the find vehicle button
    Then the valid error message "<message>" should be displayed

    Examples:
      | id | description                        | registrationNo | message                               |
      | 2  | invalid registration no  - chars   | sdsdsdfs       | Sorry record not found                |
      | 3  | invalid regsitration -nos          | 1234           | Sorry record not found                |
      | 4  | invalid registration alpha numeric | as56as         | Sorry record not found                |
      | 5  | blank registration no              |                | Please enter a valid car registration |


  Scenario:<6> Navigate to home page
    When I click on the volkswagen financial services link
    Then the "Volkswagen Insurance Portal" page should be displayed