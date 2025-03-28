Feature: Test the functionality of automation panda
 
  Scenario: Test the booking operations in customer login
    Given I enter the booking url of domain
    When I enter customer booking dates
    And I enter customer creadentials
    Then I can book successfully