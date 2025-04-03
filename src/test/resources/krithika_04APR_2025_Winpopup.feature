Feature: Test the functionality of open window page
 
  Scenario: Test the window button operations in practice page
    Given I enter the url of practice page
    When I click  open window button popup
    Then I can see open window page successfully

  Scenario: Test the open tab button operation in the practice page
    Given I enter the URL of the practice page
    When I click the open tab button
    Then I should see the new tab opened successfully