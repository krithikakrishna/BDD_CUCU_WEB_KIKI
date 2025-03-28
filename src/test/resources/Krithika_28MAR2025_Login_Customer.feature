Feature: Test the functionality of domain login
 
  Scenario: Test the login operations in customer login
    Given I enter the shop login url of domain
    When I enter customer login credentials
    Then I can login shop successfully