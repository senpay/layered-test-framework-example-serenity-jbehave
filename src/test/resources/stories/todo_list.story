Scenario: Should be able to add new todo item
When user creates todo item (name: todoItemName)
Then user sees todo item in items list (name: todoItemName)

Scenario: should be able to mark todo item as completed
Given user created todo item  (name: todoItemCompleted)
When user marks item as completed (name: todoItemCompleted)
Then todo item marked completed (name: todoItemCompleted)

Scenario: should be able to un-mark todo item as completed
Given user created todo item  (name: todoItemNotCompleted)
And user completed todo item (name: todoItemNotCompleted)
When user un-marks item as completed (name: todoItemNotCompleted)
Then todo item is not marked completed (name: todoItemNotCompleted)

Scenario: should be able to delete todo item
Given user created todo item (name: todoItemDeleted)
When user deletes item (name: todoItemDeleted)
Then user does not see todo item in items list (name: todoItemDeleted)

Scenario: should see only active if active filter applied
Given user created several todo items (amount: 6)
And user completed some of them (amount: 4)
When selects active filter
Then user sees active items
And user does not see completed items

Scenario: should see only completed if completed filter applied
Given user created several todo items (amount: 7)
And user completed some of them (amount: 6)
When selects completed filter
Then user sees completed items
And user does not see active items

Scenario: should see all items if all filter applied
Given user created several todo items (amount: 3)
And user completed some of them (amount: 1)
When selects all filter
Then user sees completed items
And user sees active items

Scenario: failing scenario to check reporting
Given user created several todo items (amount: 3)
And user completed some of them (amount: 1)
When selects all filter
Then user does not see completed items
And user sees active items