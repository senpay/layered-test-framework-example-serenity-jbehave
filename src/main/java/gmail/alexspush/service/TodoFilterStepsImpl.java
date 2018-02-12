package gmail.alexspush.service;

import gmail.alexspush.page.SelenideMainPage;
import org.jbehave.core.annotations.When;

/**
 * Created by Alexander Pushkarev on 10.2.18.
 */
public class TodoFilterStepsImpl {

    private IMainPage mainPage = SelenideMainPage.INSTANCE;


    @When("selects completed filter")
    public void selectsCompletedFilter() {
        mainPage.clickCompletedLink();
    }


    @When("selects all filter")
    public void selectsAllFilter() {
        mainPage.clickAllLink();
    }


    @When("selects active filter")
    public void selectsActiveFilter() {
        mainPage.clickActiveLink();
    }
}
