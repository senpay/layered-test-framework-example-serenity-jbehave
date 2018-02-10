package gmail.alexspush.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gmail.alexspush.test.ITodoCRUDSteps;
import gmail.alexspush.test.ITodoCompositeSteps;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Given;

import static gmail.alexspush.utils.TestUtils.generateItemName;
import static gmail.alexspush.utils.TestUtils.getListWithoutSublist;
import static org.junit.Assume.assumeTrue;

/**
 * The idea of this composite is to create some abstraction
 * if "state-creating" steps. They more or less using other steps
 * but should fail with different exception if necessary
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoCompositeStepsImpl implements ITodoCompositeSteps {

    private ITodoCRUDSteps crudSteps = new TodoCRUDStepsImpl();
    //I use here concrete type as I want some method from it
    //Looks ugly but will leave it as is for now
    private TodoValidationLogic todoValidationLogic = new TodoValidationLogic();

    //bad thing about BDD frameworks with test specified with Gherkin language
    //in a separate text file is the necessity to store state somewhere
    //some use tricky context stuff (serenity offered a context, for instance,
    // but seems to abandon the idea)
    //I will use idea with getters, seems to be cleaner
    private List<String> todoItems = Collections.emptyList();
    private List<String> completedItems = Collections.emptyList();



    @Override
    @Given("user created todo (name: $todoItemName)")
    public void userCreatedTodoItem(String todoItemName) {
        crudSteps.userEntersTodoName(todoItemName);
        //Using assume here so exception in step preparation would look
        //different from typical assertion
        assumeTrue(todoValidationLogic.isItemPresentInAList(todoItemName));
    }

    @Override
    @Step
    public void userCompletedTodoItem(String todoItemName) {
        crudSteps.userMarksItemAsComplete(todoItemName);
        assumeTrue(todoValidationLogic.isTodoItemMarkedCompeted(todoItemName));
    }

    @Override
    @Given("user created several todo items (amount: $numberOfItemsCreated)")
    public void userCreatedNumberOfItems(int numberOfItemsCreated) {
        final List<String> todoItemNames = new ArrayList<>();
        for (int i = 0; i < numberOfItemsCreated; i++) {
            final String todoItemName = generateItemName();
            userCreatedTodoItem(todoItemName);
            todoItemNames.add(todoItemName);
        }
        this.todoItems = todoItemNames;
    }

    @Override
    @Given("user completed some of them (amount: $numberOfItemsCompleted)")
    public void userCompletedNumberOfItems(int numberOfItemsCompleted) {
        List<String> todoItemsToBeCompleted = this.todoItems.subList(0, numberOfItemsCompleted);
        for (String todoItem : todoItemsToBeCompleted) {
            userCompletedTodoItem(todoItem);
        }
        this.completedItems = todoItemsToBeCompleted;
    }

    public List<String> getTodoItems() {
        return todoItems;
    }

    public List<String> getCompletedItems() {
        return completedItems;
    }

    public List<String> getActiveItems() {
        return getListWithoutSublist(getTodoItems(), getCompletedItems());
    }
}
