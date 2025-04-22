Feature: Krithika_22APR2025_UserAPIRestAssuredMethods

  Scenario: Retrieve user by ID
    Given I set the GET endpoint for user with ID "2"
    When I send the GET HTTP request
    Then I should receive a 200 status codes
    And I should see user details in the response


  
  Scenario: Successfully create a user
    Given I set the POST endpoint for creating user
    And I prepare request body with name "morpheus" and job "leader"
    When I send a POST HTTP request
    Then the response status codes should be 201
    And the response should contain the user ID and creation timestamp


   
  Scenario: Put request to update user details
    Given the API is up and running
    When I send a PUT request to update the user with ID 2
    Then I should receive a success response

  Scenario: Patch request to partially update user details
    Given the API is up and running
    When I send a PATCH request to update the user with ID 2
    Then I should receive a success response

  Scenario: Delete request to remove user
    Given the API is up and running
    When I send a DELETE request to remove the user with ID 2
    Then I should receive a success response
