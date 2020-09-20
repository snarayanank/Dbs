package sg.com.dbs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DBSHomePage {

    public WebDriver driver;

    public DBSHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//p[@class='dbs-group']//button[@class='btn btn-primary'][contains(text(),'Learn More')]")
    WebElement learnMore;
    public void clickLearnMore() { learnMore.click(); }
    public WebElement getLearnMore() { return learnMore; }

    @FindBy(xpath= "//div[@class='navbar-links-left']//a[contains(text(),'Sustainability')]")
    WebElement sustainability;
    public void clickSustainability() { sustainability.click(); }
    public WebElement getSustainability() { return sustainability; }

    @FindBy(xpath= "//h4[contains(text(),'Creating Social Impact')]")
    WebElement socialImpact;
    public void clickSocialImpact() { socialImpact.click(); }

    @FindBy(xpath= "//a[contains(text(),'DBS Stronger Together Fund')]")
    WebElement strongTogetherFund;
    public void clickStrongTogetherFund() { strongTogetherFund.click(); }

    @FindBy(xpath= "//a[@class='nav-link hasDevice'][contains(text(),'Singapore')]")
    WebElement singapore;
    public void clickSingapore() { singapore.click(); }

    @FindBy(xpath= "//a[@class='nav-link hasDevice'][contains(text(),'Hong Kong')]")
    WebElement hongkong;
    public void clickHongkong() { hongkong.click(); }

    @FindBy(xpath= "//a[@class='nav-link hasDevice'][contains(text(),'China')]")
    WebElement china;
    public void clickChina() { china.click(); }

    @FindBy(xpath= "//a[@class='nav-link hasDevice'][contains(text(),'Indonesia')]")
    WebElement indonesia;
    public void clickIndonesia() { indonesia.click(); }

    @FindBy(xpath= "//div[@class='rich-text-box']//div//table//tbody")
    WebElement tableBody;
    public WebElement getTableBody() { return tableBody; }

    @FindBy(xpath= "//div[@class='navbar-links-left']//a[contains(text(),'About')]")
    WebElement About;
    public void clickAbout() { About.click(); }

    @FindBy(xpath= "//a[contains(text(),'Who We Are')]")
    WebElement whoWeAre;
    public void clickWhoWeAre() { whoWeAre.click(); }

    @FindBy(xpath= "//a[contains(text(),'Our Awards & Accolades')]")
    //@FindBy(xpath= "//div[4]//div[1]//div[2]//p[2]//a[1]")
    WebElement awardsAccolades;
    public void clickAwardsAccolades() { awardsAccolades.click(); }
    public WebElement getAwardsAccolades() { return awardsAccolades; }

    @FindBy(xpath= "//div[@class='row mBot-20']")
    WebElement awardsCount;
    public WebElement getAwardsCount() { return awardsCount; }

}
