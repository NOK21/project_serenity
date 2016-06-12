package serenitytest.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.bouncycastle.cms.PasswordRecipientId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Dmitry on 17.05.2016.
 */
@DefaultUrl("http://skillsup.ua/")
public class SkillsUpPage extends PageObject {


    private By OurTeam = By.linkText("Наша команда");
    private By Names = new By.ByClassName("name");
    private By AllInfo = new By.ByClassName("text");
    private By search = By.id("u5016-2");
    private By results = By.className("xsltsearch_result");
    private By button = By.id("u1552-4");
    private By Education = By.id("menu1078");
    private By Trainings = By.xpath(".//*[@id='menu1078']/ul/li[2]/a");
    private By CourseLeadWay = By.xpath(".//*[@id='subMenuSubNodes1190']/li[8]/a");
    private By Size = By.xpath(".//*[@id='page_position_content']/div[3]/div/div/div[1]/div/p[5]");
    private By Coast = By.xpath(".//*[@id='page_position_content']/div[3]/div/div/div[1]/div/p[9]");


    public void goToCoachesPage() {
        WebElement goToCoachesPage = find(OurTeam);
        goToCoachesPage.click();
    }

    public List<String> allCoachesNames() {
        List<String> names = new ArrayList();
        List<WebElementFacade> elements = findAll(Names);
        for (WebElement name : elements)
            names.add(name.getText());
        return names;
    }

    public void goToCoach(String coach_name) {
        List<WebElementFacade> elements = findAll(Names);
        for (WebElement name : elements) {
            if (name.getText().contains(coach_name)) {
                name.click();
                break;
            }
        }
    }

    public boolean courseFromCoachPage(String course) {
        return find(AllInfo).getText().contains(course);
    }

    public void sendSearchingMask(String keyword) {
        find(search).sendKeys(keyword);
        find(button).click();
    }

    public WebElement getCoachSearchResults(String coach_name) {
        WebElement result = null;
        List<WebElementFacade> titleresults = findAll(results);
        for (WebElement names : titleresults) {
            if (names.getText().contains(coach_name))
                result = names;
        }
        return result;
    }

    public WebElement getStudentSearchResults(String number) {
        WebElement result = null;
        List<WebElementFacade> titleresults = findAll(results);
        for (WebElement names : titleresults) {
            if (names.getText().contains(number))
                result = names;
        }
        return result;
    }

    public void selectLeadWay() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(find(Education)).moveToElement(find(Trainings)).moveToElement(find(CourseLeadWay)).click().build().perform();
    }

    public String gettingTrainingPrice() {
        WebElementFacade Price = find(Coast);
        return Price.getText();
    }

    public String gettingTrainingGroupSize() {
        WebElementFacade GroupSize = find(Size);
        return GroupSize.getText();
    }
}