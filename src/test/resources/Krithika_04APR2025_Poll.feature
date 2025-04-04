Feature: Community Poll Voting

  Scenario: User votes in the community poll
    Given I logged into the application
    When I have chosen the option for community polls
    Then I can submit the vote button
