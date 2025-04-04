Feature: Krithika_04APR_2025_Community_Voting

  Scenario: User votes in the community poll
    Given I logged into the application
    When I have chosen the option for community poll
    Then I can submit the vote button
