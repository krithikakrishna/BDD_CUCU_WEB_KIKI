Feature: Site Interaction Testing
 
 Background: 
    Given I navigate to the website
 
 Scenario Outline: Verify text box functionality
   When I enter "<name>" in the name text box  
   And I enter "<email>" in the email text box
   Then The text boxes should contain the entered values "<name>" and "<email>"

  Examples:
      | name      | email                 |
      | John Doe  | john.doe@example.com  |
      | Alice Ray | alice.ray@gmail.com   |


Scenario Outline: Select a checkbox
   When I select the "<checkboxName>" checkbox

Examples:
   | checkboxName |
   | Home        |
   

    
Scenario Outline: Verify radio button selection
    When I select the "<Impressive>" radio button
    Then The "<Impressive>" radio button should be selected

    Examples:
      | Yes |
      | Impressive   |


  
 