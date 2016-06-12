package serenitytest.steps.serenity;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import serenitytest.pages.SkillsUpPage;

public class EndUserSteps extends ScenarioSteps {

    SkillsUpPage SkillsUpPage;

    @Step
    public void is_the_start_page (){SkillsUpPage.open(); }

    @Step
    public void click_on_our_team (){        SkillsUpPage.goToCoachesPage();
            }

    @Step
    public void should_see_coach (String coach_name){
        assertThat(SkillsUpPage.allCoachesNames(), hasItem(containsString(coach_name)));
    }

    @Step
    public void clickOnCoach(String coach_name){
        SkillsUpPage.goToCoachesPage();
        SkillsUpPage.goToCoach(coach_name);
    }

    @Step
    public void checkingCourseForCoach(String course){
        assertTrue(SkillsUpPage.courseFromCoachPage(course));
    }

    @Step
    public void putKeywordIntoSearchField(String keyword){
        SkillsUpPage.sendSearchingMask(keyword);
    }

    @Step
    public void seeResultsWithNamesAndPositions(String coach_name, String position){
        assertTrue(SkillsUpPage.getCoachSearchResults(coach_name).findElement(By.className("xsltsearch_result_title")).getText().contains(coach_name));
        assertTrue(SkillsUpPage.getCoachSearchResults(coach_name).findElement(By.className("xsltsearch_result_description")).getText().contains(position));
    }

    @Step
    public void seeResultsOfStudentSearching(String number, String student_name){
        assertTrue(SkillsUpPage.getStudentSearchResults(number).getText().contains(number));
        assertTrue(SkillsUpPage.getCoachSearchResults(number).getText().contains(student_name));
    }

    @Step
    public void selectTrainingFromEducationSubmenu(){
        SkillsUpPage.selectLeadWay();
    }

    @Step
    public void pageWithDetailedInformationAboutTraining(String price, String size){
        assertEquals("Wrong price!", price, SkillsUpPage.gettingTrainingPrice());
        assertEquals("Wrong group size!", size, SkillsUpPage.gettingTrainingGroupSize());
    }


}