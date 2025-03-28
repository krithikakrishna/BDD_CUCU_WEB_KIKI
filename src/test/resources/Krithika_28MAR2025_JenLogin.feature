Feature: Test the functionality of domain login
 
  Scenario: Test the login operations in customer login
    Given I enter the shops login url of domain
    When I enter customer login credential
    Then I can login shops successfully