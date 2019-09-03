@run
Feature: Volkswagen Home Portal

  Description:As a user of the insurance portal when I click the link then the corresponding information shpuld
  be displayed on the home page

  Background:
    Given I am on the insurance "Dealer Portal" page
    When I click on the volkswagen financial services link
    Then the "Volkswagen Insurance Portal" page should be displayed

  Scenario Outline: <id> Sub-link information
    Given I am on the "Volkswagen Insurance Portal" page
    When I click on the "<sublink>" under home
    Then the sub link detail "<information>"  should be displayed
    Examples:
      | id | description                 | sublink                | information                         |
      | 1  | Approved Used Warranty link | Approved Used Warranty | Approved Used Warranty              |
      | 2  | Extended Warranty link      | Extended Warranty      | Extended Warranty                   |
      | 3  | Gap Insurance link          | Gap Insurance          | Gap Insurance                       |
      | 4  | Ensurance                   | Ensurance              | Ensurance                           |
      | 5  | Car Insurance               | Car Insurance          | Car Insurance                       |
      | 6  | MOT Cover                   | MOT Cover              | MOT Cover                           |
      | 7  | Home                        | Home                   | Welcome                             |
      | 8  | Q3 offers                   | Q3 offers              | Insurance Included Offers - Q3 2018 |
      | 9  | Q2 offers                   | Q2 offers              | SEAT Ibiza                          |
