package gmail.alexspush.service;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoCRUDSteps;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoCRUDStepsImpl implements ITodoCRUDSteps {

    private IMainPage mainPage = SelenideMainPage.INSTANCE;

    @Override
    @Step
    @When("user creates todo item with name: $todoName")
    public void userEntersTodoName(String todoName) {
        mainPage.setNewItemName(todoName);
        mainPage.hitEnter();
    }

    @Override
    @Step
    public void userMarksItemAsComplete(String todoItemName) {
        mainPage.selectCheckBoxForItem(todoItemName);
    }

    @Override
    @Step
    public void userDeletesItem(String todoItemName) {
        mainPage.clickDeleteButtonForItem(todoItemName);
    }

    @Override
    @Step
    public void userUnMarksItemAsComplete(String todoItemName) {
        mainPage.unSelectCheckBoxForItem(todoItemName);
    }
}
