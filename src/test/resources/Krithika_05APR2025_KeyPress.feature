Feature: Krithika_05APR_2025_KeyPress

  Scenario Outline: Verify key press events
    Given I am on the Key Press page
    When I press the "<key>" key
    Then I should see the message "You Entered: <key>"

    Examples:
      | key     |
      | TAB     |
      | ENTER   |
      | ESCAPE  |
      | ALT     |
      | SHIFT   |
