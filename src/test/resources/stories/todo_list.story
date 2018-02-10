Scenario: Should be able to add new todo item
When user creates todo item (name: todoItemName)
Then user sees todo item in items list (name: todoItemName)

Scenario: should be able to mark todo item as completed
Given user created todo (name: todoItemCompleted)
When user marks item as completed (name: todoItemCompleted)
Then todo item marked completed (name: todoItemCompleted)

Scenario: should be able to delete todo item
Given user created todo (name: todoItemDeleted)
When user deletes item (name: todoItemDeleted)
Then user does not see todo item in items list (name: todoItemNatodoItemDeletedme)

Scenario: should see only active if active filter applied
Given user created several todo items (amount: 6)
And user completed some of them (amount: 4)
When selects active filter
Then user sees active items
And user does not see completed items
