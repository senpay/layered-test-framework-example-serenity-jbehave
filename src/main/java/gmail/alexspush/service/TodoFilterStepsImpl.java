package gmail.alexspush.service;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoFilterSteps;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.When;

/**
 * Created by Alexander Pushkarev on 10.2.18.
 */
public class TodoFilterStepsImpl implements ITodoFilterSteps {

    private IMainPage mainPage = SelenideMainPage.INSTANCE;

    @Override
    @When("selects completed filter")
    public void selectsCompletedFilter() {
        mainPage.clickCompletedLink();
    }

    @Override
    @When("selects all filter")
    public void selectsAllFilter() {
        mainPage.clickAllLink();
    }

    @Override
    @When("selects active filter")
    public void selectsActiveFilter() {
        mainPage.clickActiveLink();
    }
}
