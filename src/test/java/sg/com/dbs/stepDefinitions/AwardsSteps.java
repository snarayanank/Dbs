package sg.com.dbs.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sg.com.dbs.pageObjects.DBSHomePage;
import sg.com.dbs.utilities.Base;
import java.util.List;
import java.util.Map;

public class AwardsSteps extends Base {

    private static Logger log = LogManager.getLogger(AwardsSteps.class.getName());
    public WebDriver driver;
    public DBSHomePage dbsHomePage;
    WebDriverWait wait;

    public AwardsSteps()
    {
        driver = Hooks.driver;
        dbsHomePage = new DBSHomePage(driver);
        wait = new WebDriverWait(driver, 20);
    }
    @Then("Validate the total number of awards displayed on the page is {int}")
    public void validate_the_total_number_of_awards_displayed_on_the_page_is(Integer int1) {
        // Get all the awards displayed
        List<WebElement> allAwards = driver.findElements(By.xpath("//div[@class='row mBot-20']"));
        log.info("Total number of awards displayed on the page is " + allAwards.size());
        if (allAwards.size() == int1){
            log.info("Validated the total number of awards displayed on the page is " + allAwards.size());
        }
        else {
            Assert.fail("There are " + allAwards.size() + " awards displayed on the page instead of " + int1);
            log.info("There are " + allAwards.size() + " awards displayed on the page instead of " + int1);
        }
    }

    @Then("User validates all the award name and caption of the awards mentioned below")
    public void user_validates_all_the_award_name_and_caption_of_the_awards_mentioned_below(DataTable awards) {
        log.info("User validates all the award name and caption of the awards mentioned below");
        wait.until(ExpectedConditions.visibilityOf(dbsHomePage.getAwardsCount()));
        List<Map<String, String>> rows = awards.asMaps(String.class,String.class);
        for (Map<String, String> columns : rows) {
            WebElement awardName = driver.findElement(By.xpath("//*[text()=\""+ columns.get("Award Name") +"\"]"));
            WebElement caption = driver.findElement(By.xpath("//*[text()=\""+ columns.get("Caption of the award") +"\"]"));
            log.info("Award Name to be validated is " + columns.get("Award Name") + " and the Caption is " + columns.get("Caption of the award"));
            if(awardName.isDisplayed() && caption.isDisplayed()){
                log.info("Award/Caption " + awardName.getText() + "/" + caption.getText() + " is displayed");
            }
            else{
                Assert.fail("Award/Caption " + columns.get("Award Name") + "/" + columns.get("Caption of the award") + " is not displayed");
                log.info("Award/Caption " + columns.get("Award Name") + "/" + columns.get("Caption of the award") + " is not displayed");
            }
        }
    }
}
