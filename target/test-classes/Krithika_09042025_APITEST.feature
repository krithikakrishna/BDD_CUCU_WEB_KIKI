Feature: Krithika_09042025_Reqres_API_Testing_Rest_Assured
 
  Scenario: Get user details 
    Given the API is available 
    When I send a GET request to "/api/users/2" 
    Then the response status code should be 200 
    And the response should contain user detail