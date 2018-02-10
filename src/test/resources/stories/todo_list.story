Scenario: Should see total price including tax
Given I have searched for local items containing 'wool'
And I have selected an item
When I add the item to the shopping cart
Then the item should appear in the cart
And the shipping cost should be included in the total price