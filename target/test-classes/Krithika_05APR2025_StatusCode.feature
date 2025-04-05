Feature: Krithika_05APR_2025_Status_Code

  Scenario Outline: Navigate to status code page and click back button
    Given I am on the Status Codes page
    When I click on status code "<code>"
    Then I should be navigated to the status code "<code>" page
    And I click the back link
    Then I should be navigated back to the Status Codes page

    Examples:
      | code |
      | 200  |
      | 301  |
      | 404  |
      | 500  |
