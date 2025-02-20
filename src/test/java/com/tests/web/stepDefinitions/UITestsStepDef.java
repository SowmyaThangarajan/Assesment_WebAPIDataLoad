package com.tests.web.stepDefinitions;

import com.tests.web.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.util.List;

@Listeners(com.listeners.ExtentReportManager.class)
public class UITestsStepDef {

    private WebDriver driver;
    private HomePage homePage;
    private String url;

    @Before
    public void setup(){
        driver=new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("user launches browser and navigate to application {string}")
    public void launchBrowserAndHitURL(String url){
        driver.navigate().to(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        this.url=url;
    }

    @Then("user should be landed on the homepage")
    public void userLandsInHomePage(){
        driver.getCurrentUrl().equalsIgnoreCase(url);
    }

    @And("user should be able to see text {string} in tagline")
    public void validateHomePageLogo(String tagLine) {
        Assert.assertEquals(homePage.getHomePageTagLine(),tagLine);
    }

    @And("user should be able to see requests in homepage")
    public void listOfRequestsInHomePage(DataTable dataTable) {
        List<String> requests = dataTable.asList(String.class);
        for (String request : requests) {
            homePage.getUniqueHTTPMethods().contains(request);
        }
        Assert.assertEquals(homePage.getUniqueHTTPMethods().size(),requests.size());
    }

    @And("user should be able to see {string} selected by default")
    public void defaultEndPoint(String endPoint) {
        Assert.assertEquals(endPoint.toLowerCase(),homePage.getActiveEndPoint().getText().trim().toLowerCase());
    }

    @And("user should be able to see {string} under {string}")
    public void defaultEndPointRequest(String endPoint, String request) {
        if(endPoint.equalsIgnoreCase("/api/users?page=2")) {
            Assert.assertEquals(homePage.getDisplayedRequestDetails().getText(), endPoint);
        }
        if(endPoint.equalsIgnoreCase("/api/users/23")) {
            Assert.assertEquals(homePage.getDisplayedRequestDetailsSingleUserNotFound().getText(), endPoint);
        }
    }

    @And("user should be able to see {int} as response code")
    public void defaultEndPointResponseStatusCode(Integer statusCode) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(homePage.getResponseStatusCode().getText(),statusCode.toString());
    }

    @And("user should be able to see response body displayed")
    public void outputResponseBody() {
        Assert.assertNotNull(homePage.getResponseBody().getText().trim());
        if(homePage.getResponseBody().getText().trim().length()==2){
            Assert.assertEquals(homePage.getResponseBody().getText().trim(),"{}");
        }
    }

    @When("user selects {string} from list of requests")
    public void outputResponseBody(String request) {
        if(request.equalsIgnoreCase("SINGLE USER NOT FOUND")) {
            homePage.singleUserNotFoundClick().click();
        }
    }

    @And("{string} button should be available in homepage")
    public void regresBtnAvailable(String btnName) {
        if(btnName.equalsIgnoreCase("Support ReqRes")) {
            Assert.assertTrue(homePage.reqresButtonIsAvailable());
        }
        if(btnName.equalsIgnoreCase("Upgrade")) {
            Assert.assertTrue(homePage.upgradeButtonIsAvailable());
        }
    }

    @When("user clicks on {string} button")
    public void regresBtnClick(String btnName) {
        homePage.reqresButtonClickable().click();
    }

    @When("user should be landed on the {string} page")
    public void regresPageTitleIsDisplayed(String btnName) {
        Assert.assertTrue(homePage.regresPageTitleIsDisplayed());
    }

    @And("user should be able to see {string} and {string} options")
    public void supportOptions(String support1, String support2) {
        Assert.assertTrue(homePage.oneTimeReqResSupportIsEnabled());
        Assert.assertTrue(homePage.monthlyReqResSupportIsEnabled());
    }

}
