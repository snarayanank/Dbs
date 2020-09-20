package sg.com.dbs.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sg.com.dbs.pageObjects.DBSHomePage;
import sg.com.dbs.utilities.Base;
import java.io.IOException;

public class Hooks extends Base{
    WebDriverWait wait;

    @Before
    public void initialize() throws IOException {
        driver = initializeDriver();
        wait = new WebDriverWait(driver, 20);
    }
    
    @After
    public void tearDown() throws IOException{
        driver.close();
        driver=null;
    }
}
