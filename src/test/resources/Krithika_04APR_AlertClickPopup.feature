Feature: Validate alert popup

  Scenario: Handle Alert popup
  Given I enter the URL of the practice page for confirmation
    When I enter "Krishna" in the textbox
    And I click on the alert button
    Then I handle the alert popup   
