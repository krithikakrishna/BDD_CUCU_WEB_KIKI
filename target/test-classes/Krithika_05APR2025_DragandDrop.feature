Feature: Krithika_05APR_2025_Drag_Drop_functionality

  Scenario: Drag box A and drop onto box B
    Given I am on the Drag and Drop page
    When I drag element "A" and drop it onto element "B"
    Then element "A" should be in position of "B"
  
  Scenario: Drag box B and drop onto box A
    Given I am on the Drag and Drop page
    When I drag element "B" and drop it onto element "A"
    Then element "B" should be in position of "A"
