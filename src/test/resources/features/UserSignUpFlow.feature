Feature: User SignUp and Login

  Scenario: Sign up a user with valid credentials
    Given Sign up to the book store as the new user with email and password
    When do the sign up with valid credentials
    Then validate that the response code is 200 and response message should be User created successfully after sign up

  Scenario: Login with correct credentials
    When user tried to login with valid credentials into book store system
    Then verify the response after login into book store should 200 and successLogin
