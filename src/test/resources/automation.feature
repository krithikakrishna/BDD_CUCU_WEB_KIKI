Feature: Test the functionality of automation bookstore
 
  Scenario: Test the filter  operations in automation bookstore
    Given I enter the url of bookstore
    When I search books
    Then I can retrive books successfully