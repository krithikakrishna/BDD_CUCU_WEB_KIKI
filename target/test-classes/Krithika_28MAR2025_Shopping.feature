Feature: Krithika_28MAR_2025_ShoppingSite

  Scenario: Adding an item to the cart
    Given I navigate to the shopping page
    When I select a product
    And I choose the size, color, and quantity
    And I add the product to the cart
    Then I should be redirected to the shopping cart page
    
