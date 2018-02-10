package gmail.alexspush.service;

import java.util.List;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoValidationSteps;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoValidationStepsImpl implements ITodoValidationSteps {

    private TodoValidationLogic todoValidationLogic = new TodoValidationLogic();

    @Override
    @Step
    public void todoItemIsPresent(String todoName) {
        final String errorMessage = String.format("Item with name %s was't found in a list", todoName);
        assertTrue(errorMessage, todoValidationLogic.isItemPresentInAList(todoName));
    }

    @Override
    @Step
    public void todoItemMarkedCompeted(String todoName) {
        final String errorMessage = String.format("Item with name %s is not marked completed", todoName);
        assertTrue(errorMessage, todoValidationLogic.isTodoItemMarkedCompeted(todoName));
    }

    @Override
    @Step
    public void todoItemIsNotPresent(String todoItemName) {
        final String errorMessage = String.format("Item with name %s was found in a list", todoItemName);
        assertFalse(errorMessage, todoValidationLogic.isItemPresentInAList(todoItemName));
    }

    @Override
    @Step
    public void todoItemIsNotMarkedCompeted(String todoItemName) {
        final String errorMessage = String.format("Item with name %s is marked completed", todoItemName);
        assertFalse(errorMessage, todoValidationLogic.isTodoItemMarkedCompeted(todoItemName));
    }

    @Override
    @Step
    public void userDoesNotSeeItems(List<String> items) {
        for (String itemName : items) {
            todoItemIsNotPresent(itemName);
        }
    }

    @Override
    @Step
    public void userSeesItems(List<String> items) {
        for (String itemName : items) {
            todoItemIsPresent(itemName);
        }
    }
}
