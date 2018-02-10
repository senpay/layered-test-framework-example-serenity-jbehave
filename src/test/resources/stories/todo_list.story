Scenario: Should see total price including tax
Given user opened application
When user creates todo item with name: todoItemName
Then user sees todo item in items list: todoItemName