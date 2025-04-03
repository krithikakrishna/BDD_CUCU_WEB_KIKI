Feature: Validate alert and confirmation popups

  Scenario: Handle confirmation popup
  Given I enter the URL of the practice page for alert
    When I enter "Krithika" in the text
    And I click on the confirm button
    Then I handle the confirmation popup   

 
