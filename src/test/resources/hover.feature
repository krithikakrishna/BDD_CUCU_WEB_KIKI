Feature: Test the functionality of domain login
 
  Scenario: Test the banking operations in customer login
    Given I enter the url of domains
    When I enter customers credentials
    Then I can login domains successfully