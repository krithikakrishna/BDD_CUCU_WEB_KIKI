Feature: Test the functionality of domain login
 
  Scenario: Test the banking operations in customer login
    Given I enter the url of domain
    When I enter customer credentials
    Then I can login domain successfully