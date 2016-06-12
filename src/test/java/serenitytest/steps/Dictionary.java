package serenitytest.steps;

import com.sun.jndi.ldap.ext.StartTlsResponseImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.thucydides.core.annotations.Steps;
import serenitytest.steps.serenity.EndUserSteps;

public class Dictionary {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the SkillsUp home page")
    public void givenTheUserIsOnTheSkillsUpHomePage() {
        endUser.is_the_start_page();
    }

    @When("the user click on 'Наша команда'")
    public void whenTheUserClickonOurTeam() {
        endUser.click_on_our_team();
    }

    @Then("he should see the coach '$coach_name'")
    public void thenHeShouldSeeTheCoach(String coach_name) {
        endUser.should_see_coach(coach_name);
    }

    @When("the user click on coach '$coach_name'")
    public void whenTheUserClickOnCoach(String coach_name) {
        endUser.clickOnCoach(coach_name);
    }

    @Then("he should see personal coach page with course '$course'")
    public void thenHeShouldSeePersonalCoachPageWithCourse (String course){
        endUser.checkingCourseForCoach(course);
    }

    @When("the user put keyword '$keyword' into search field")
    public void whenTheUserPutKeywordIntoSearchField (String keyword){
        endUser.putKeywordIntoSearchField(keyword);
    }

    @Then("he should see results that contain coach name '$coach_name' and his position '$position'")
    public void thenHeShouldSeeResultsThatContainCoachNameAndHisPosition(String coach_name, String position){
        endUser.seeResultsWithNamesAndPositions(coach_name, position);
    }

    @Then("he should see results that contain certificate number '$number' and student's name '$student_name'")
    public void thenHeShouldSeeResultsThatContainCertificateNumberAndStudentName(String number, String student_name){
        endUser.seeResultsOfStudentSearching(number, student_name);
    }
    @When("the user select training '$training' from Education submenu")
    public void whenTheUserSelectTrainingFromEducationSubmenu (){
        endUser.selectTrainingFromEducationSubmenu();
    }
    @Then("he will see page with detailed information as price '$price' and group size '$size'")
    public void thenHeWillSeePageWithDetailedInformatonAsPriceAndGroupSize(String price, String size){
        endUser.pageWithDetailedInformationAboutTraining(price, size);
    }
}
