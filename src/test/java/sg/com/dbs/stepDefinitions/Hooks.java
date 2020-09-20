package sg.com.dbs.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sg.com.dbs.pageObjects.DBSHomePage;
import sg.com.dbs.utilities.Base;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends Base{
    WebDriverWait wait;

    @Before
    public void initialize() throws IOException {
        driver = initializeDriver();
        wait = new WebDriverWait(driver, 20);
    }
    
    @After
    public void tearDown(Scenario scenario) throws IOException{
        //if (scenario.isFailed()) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(currDir + "//src//main//java//sg//com//dbs//reports//" + scenario.getName() + "screenshot.png"));
        //}
        driver.close();
        driver=null;
    }
}
