package gmail.alexspush.service;

import gmail.alexspush.page.SelenideMainPage;
import org.jbehave.core.annotations.When;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoCRUDStepsImpl {

    private IMainPage mainPage = SelenideMainPage.INSTANCE;


    @When("user creates todo item (name: $todoItemName)")
    public void userEntersTodoName(String todoName) {
        mainPage.setNewItemName(todoName);
        mainPage.hitEnter();
    }


    @When("user marks item as completed (name: $todoItemName)")
    public void userMarksItemAsComplete(String todoItemName) {
        mainPage.selectCheckBoxForItem(todoItemName);
    }


    @When("user deletes item (name: $todoItemName)")
    public void userDeletesItem(String todoItemName) {
        mainPage.clickDeleteButtonForItem(todoItemName);
    }


    @When("user un-marks item as completed (name: $todoItemName)")
    public void userUnMarksItemAsComplete(String todoItemName) {
        mainPage.unSelectCheckBoxForItem(todoItemName);
    }
}
