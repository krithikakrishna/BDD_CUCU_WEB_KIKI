Feature: Krithika_04APR_2025_Context_Menu 

   Scenario: Verify the context menu alert
    Given I open the context menu webpage
    When I right-click on the context menu box
    Then I should see an alert with text "You selected a context menu"
    And I accept the alert
    And I close the browser
