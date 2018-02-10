package gmail.alexspush.test;

import java.util.List;

import gmail.alexspush.service.GenericStepsImpl;
import gmail.alexspush.service.TodoCRUDStepsImpl;
import gmail.alexspush.service.TodoCompositeStepsImpl;
import gmail.alexspush.service.TodoFilterStepsImpl;
import gmail.alexspush.service.TodoValidationStepsImpl;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static gmail.alexspush.utils.TestUtils.generateItemName;
import static gmail.alexspush.utils.TestUtils.getListWithoutSublist;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18
 */
@RunWith(SerenityRunner.class)
@Ignore
public class TodoListTest {


    //In order for Serenity to do injection for me I will have to use
    //Concrete classes here
    @Steps
    GenericStepsImpl genericSteps;
    @Steps
    TodoCRUDStepsImpl todoCRUDSteps;
    @Steps
    TodoFilterStepsImpl todoFilterSteps;
    @Steps
    TodoValidationStepsImpl todoValidationSteps;
    @Steps
    TodoCompositeStepsImpl todoCompositeSteps;



    /**
     * This guys would be actually very good to be a parametrized test.
     * Same as previous.
     */
    @Test
    public void shouldShowOnlyCompletedItemsIfCompletedFilterApplied() {
        //Given
        final int numberOfItemsCreated = 5;
        final int numberOfItemsCompleted = 2;
       // final List<String> todoItems = todoCompositeSteps.userCreatedNumberOfItems(numberOfItemsCreated);
       // final List<String> completedItems = todoCompositeSteps.userCompletedNumberOfItems(todoItems, numberOfItemsCompleted);
        //final List<String> activeItems = getListWithoutSublist(todoItems, completedItems);

        //When
        todoFilterSteps.selectsCompletedFilter();

        //Then
        //todoValidationSteps.userSeesItems(completedItems);
        //todoValidationSteps.userDoesNotSeeItems(activeItems);
    }

    /**
     * This guys would be actually very good to be a parametrized test.
     * Same as previous.
     */
    @Test
    public void shouldShowAllItemsIfNoFilterApplied() {
        //Given
        final int numberOfItemsCreated = 5;
        final int numberOfItemsCompleted = 2;
        //final List<String> todoItems = todoCompositeSteps.userCreatedNumberOfItems(numberOfItemsCreated);
        //todoCompositeSteps.userCompletedNumberOfItems(todoItems, numberOfItemsCompleted);

        //When
        todoFilterSteps.selectsAllFilter();

        //Then
//        todoValidationSteps.userSeesItems(todoItems);
    }


    /**
     * This guys would be actually very good to be a parametrized test.
     * Same as previous.
     */
    @Test
    public void failingTestForHtmlReportCheck() {
        //Given
        final int numberOfItemsCreated = 5;
  //      final List<String> todoItems = todoCompositeSteps.userCreatedNumberOfItems(numberOfItemsCreated);

        //When

        //Then
//        todoValidationSteps.userDoesNotSeeItems(todoItems);
    }
}
