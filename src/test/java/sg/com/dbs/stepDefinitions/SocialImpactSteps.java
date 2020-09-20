package sg.com.dbs.stepDefinitions;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sg.com.dbs.pageObjects.DBSHomePage;
import sg.com.dbs.utilities.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.List;

public class SocialImpactSteps extends Base {

    private static Logger log = LogManager.getLogger(SocialImpactSteps.class.getName());
    public WebDriver driver;
    public DBSHomePage dbsHomePage;
    WebDriverWait wait;
    JavascriptExecutor js;
    String pageTitle;
    public SocialImpactSteps()
    {
        driver = Hooks.driver;
        dbsHomePage = new DBSHomePage(driver);
        wait = new WebDriverWait(driver, 20);
        js = (JavascriptExecutor) driver;
    }

    @Given("User is on dbs singapore home page")
    public void user_is_on_dbs_singapore_home_page() {
        //Open the DBS SG home page
        driver.get(prop.getProperty("baseurl"));
        log.info("Page title is " + driver.getTitle());
        pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("DBS Bank"));
    }
    @When("User clicks on {string}")
    public void user_clicks_on(String string) {
        // User clicks on the link based on the page name
        String currentWindowHandle=driver.getWindowHandle();
        driver.switchTo().window(currentWindowHandle);

        switch (string) {
            case "Learn More":
                wait.until(ExpectedConditions.visibilityOf(dbsHomePage.getLearnMore()));
                dbsHomePage.clickLearnMore();
                log.info("Clicked Learn More link");
                pageTitle = driver.getTitle();
                Assert.assertTrue(pageTitle.contains("Portraits of Purpose"));
                break;
            case "Sustainability":
                wait.until(ExpectedConditions.visibilityOf(dbsHomePage.getSustainability()));
                dbsHomePage.clickSustainability();
                log.info("Clicked Sustainability link");
                pageTitle = driver.getTitle();
                Assert.assertTrue(pageTitle.contains("Sustainability"));
                break;
            case "Creating Social Impact":
                dbsHomePage.clickSocialImpact();
                log.info("Clicked Social Impact link");
                pageTitle = driver.getTitle();
                Assert.assertTrue(pageTitle.contains("Sustainability"));
                break;
            case "DBS Stronger Together Fund":
                dbsHomePage.clickStrongTogetherFund();
                log.info("Clicked DBS Stronger Together Fund link");
                pageTitle = driver.getTitle();
                Assert.assertTrue(pageTitle.contains("DBS Stronger Together Fund"));
                break;
            case "About":
                dbsHomePage.clickAbout();
                log.info("Navigating to About page");
                pageTitle = driver.getTitle();
                Assert.assertTrue(pageTitle.contains("About DBS Bank"));
                break;
            case "Who we are":
                dbsHomePage.clickWhoWeAre();
                log.info("Navigating to Who we are page");
                String pageTitle = driver.getTitle();
                Assert.assertTrue(pageTitle.contains("Who We Are"));
                break;
            case "Our Awards & Accolades":
                wait.until(ExpectedConditions.elementToBeClickable(dbsHomePage.getAwardsAccolades()));
                if (dbsHomePage.getAwardsAccolades().isEnabled()) {
                    js.executeScript("arguments[0].click();", dbsHomePage.getAwardsAccolades());
                }
                log.info("Navigating to Our Awards & Accolades page");
                break;
        }
    }

    @Then("User navigates to {string} on the left panel")
    public void user_navigates_to_on_the_left_panel(String string) {
        // User navigates to the given country
        switch (string) {
            case "Singapore":
                dbsHomePage.clickSingapore();
                log.info("Navigating to Singapore option");
                break;
            case "Hongkong":
                dbsHomePage.clickHongkong();
                break;
            case "China":
                dbsHomePage.clickChina();
                break;
            case "Indonesia":
                dbsHomePage.clickIndonesia();
                break;
        }
    }

    @Then("Gets the list of SG F&B Businesses providing meals and writes to excel")
    public void gets_the_list_of_sg_f_b_businesses_providing_meals_and_writes_to_excel() throws IOException {
        //get the table
        WebElement fbTable = dbsHomePage.getTableBody();

        //Get all the rows in the table
        List<WebElement> allRows = fbTable.findElements(By.tagName("tr"));

        //Get the size(row no) of allRows
        int rowSize = allRows.size();
        log.info("Number of rows in the table is " + rowSize);

        // locate the test xls file
        String fileName = currDir + "//src//main//java//sg//com//dbs//reports//Output.xls";
        HSSFWorkbook workbook = new HSSFWorkbook();
        System.out.println(fileName);
        FileOutputStream file1 = new FileOutputStream (new File(fileName));
        HSSFSheet spreadSheet = workbook.createSheet("F&B businesses");
        // get rows
        HSSFRow row;
        for (int i=0; i<rowSize; i++)
        {
            WebElement webRow = allRows.get(i);
            //Get all cell values in each row
            List<WebElement> allCells = webRow.findElements(By.tagName("td"));
            log.info("Number of columns in the table is " + allCells.size());

            if(allCells.size() > 1)
            {
                HSSFRow excelRow = spreadSheet.createRow(i);

                for (int j=0; j<allCells.size(); j++)
                {
                    WebElement webCell = allCells.get(j);
                    String text = webCell.getText();
                    if(text.length()>2)
                    {
                        Cell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(webCell.getText());
                        log.info("Value written to excel is " + webCell.getText());
                    }
                }
            }
        }
        file1.close();
        FileOutputStream outFile =new FileOutputStream(new File(fileName));  //Creating new file
        workbook.write(outFile);   //printing the data in the new file
        outFile.close();           //closing the new file
        System.out.println("The Result are now printed in the excel sheet");
    }
}
