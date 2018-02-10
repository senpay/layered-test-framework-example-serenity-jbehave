package gmail.alexspush.service;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoFilterSteps;
import net.thucydides.core.annotations.Step;

/**
 * Created by Alexander Pushkarev on 10.2.18.
 */
public class TodoFilterStepsImpl implements ITodoFilterSteps {

    private IMainPage mainPage = SelenideMainPage.INSTANCE;

    @Override
    @Step
    public void selectsCompletedFilter() {
        mainPage.clickCompletedLink();
    }

    @Override
    @Step
    public void selectsAllFilter() {
        mainPage.clickAllLink();
    }

    @Override
    @Step
    public void selectsActiveFilter() {
        mainPage.clickActiveLink();
    }
}
