Feature: Book Management

  Scenario: Add a new book
    Given Adding the new book into the store after successful login of user into the system
    When add new book into book store with valid login token of user
    Then verify the response after adding the new book should be success
