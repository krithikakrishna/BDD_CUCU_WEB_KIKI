Feature: Krithika_05APR_2025_HorizontalSlider

    Scenario: Verify slider updates the displayed value correctly
    Given I open the slider webpage
    When I move the slider to "0.5"
    Then I should see the displayed value as "0.5"
    When I move the slider to "2.5"
    Then I should see the displayed value as "2.5"
    When I move the slider to "5"
    Then I should see the displayed value as "5"
