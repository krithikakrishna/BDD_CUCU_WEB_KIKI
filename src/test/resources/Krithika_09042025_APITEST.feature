Feature: Krithika_09042025_Reqres_API_Testing_Rest_Assured
 
  Scenario: Get user details 
    Given the API is available 
    When I send a GET request to "/api/users/2" 
    Then the response status code should be 200 
    And the response should contain user 

  @post  
  Scenario: Post user details  
  Given the API endpoint for creating user is "https://reqres.in/api/users"
  And the request contains name "John" and job "Engineer"
  When I send a POST request
  Then the response status code should be 201
  And the response should contain "John"
  And the response should contain "Engineer"

