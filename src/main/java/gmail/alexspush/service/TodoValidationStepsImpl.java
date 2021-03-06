package gmail.alexspush.service;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoValidationStepsImpl {

    private TodoValidationLogic todoValidationLogic = new TodoValidationLogic();

    @Steps
    TodoCompositeStepsImpl todoCompositeSteps;

    @Then("user sees todo item in items list (name: $todoItemName)")
    public void todoItemIsPresent(String todoName) {
        final String errorMessage = String.format("Item with name %s was't found in a list", todoName);
        assertTrue(errorMessage, todoValidationLogic.isItemPresentInAList(todoName));
    }

    @Then("todo item marked completed (name: $todoName)")
    public void todoItemMarkedCompeted(String todoName) {
        final String errorMessage = String.format("Item with name %s is not marked completed", todoName);
        assertTrue(errorMessage, todoValidationLogic.isTodoItemMarkedCompeted(todoName));
    }

    @Then("user does not see todo item in items list (name: $todoItemName)")
    public void todoItemIsNotPresent(String todoItemName) {
        final String errorMessage = String.format("Item with name %s was found in a list", todoItemName);
        assertFalse(errorMessage, todoValidationLogic.isItemPresentInAList(todoItemName));
    }

    @Then("todo item is not marked completed (name: $todoItemName)")
    public void todoItemIsNotMarkedCompeted(String todoItemName) {
        final String errorMessage = String.format("Item with name %s is marked completed", todoItemName);
        assertFalse(errorMessage, todoValidationLogic.isTodoItemMarkedCompeted(todoItemName));
    }

    @Step
    public void userDoesNotSeeItems(List<String> items) {
        for (String itemName : items) {
            todoItemIsNotPresent(itemName);
        }
    }

    @Then("user does not see completed items")
    public void userDoesNotSeeCompletedItems() {
        this.userDoesNotSeeItems(todoCompositeSteps.getCompletedItems());
    }

    @Then("user sees active items")
    public void userSeesActiveItems() {
        this.userSeesItems(todoCompositeSteps.getActiveItems());
    }


    @Then("user does not see active items")
    public void userDoesNotSeeActiveItems() {
        this.userDoesNotSeeItems(todoCompositeSteps.getActiveItems());
    }

    @Then("user sees completed items")
    public void userSeesCompletedItems() {
        this.userSeesItems(todoCompositeSteps.getCompletedItems());
    }

    @Step
    public void userSeesItems(List<String> items) {
        for (String itemName : items) {
            todoItemIsPresent(itemName);
        }
    }
}
