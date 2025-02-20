package com.tests.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePage {
    private WebDriver driver;

    private By homePageTagLine=By.xpath("//h2[@class='tagline'][contains(text(),'Test your front-end against a real API')]");
    private By endPoints=By.xpath("//div[@class='endpoints']//li");
    private By activeEndPointListUsers=By.xpath("//li[@class='active']/a[contains(text(),'List users')]");
    private By defaultEndPointRequest=By.xpath("//div[@class='request']//span[text()='/api/users?page=2']");
    private By singleUserNotFoundRequest=By.xpath("//div[@class='request']//span[text()='/api/users/23']");
    private By endPointResponseStatusCode=By.xpath("//span[@data-key='response-code']");
    private By outputResponseBody=By.xpath("//pre[@data-key='output-response']");
    private By singleUserNotFound=By.xpath("//a[contains(text(),'Single user not found')]");
    private By reqresButton=By.xpath("//button[contains(text(),'Support ReqRes')]");
    private By upgradeButton=By.xpath("//button[@id='trigger-pro']");
    private By reqresPage=By.xpath("//div[text()='Support ReqRes']");
    private By oneTimeReqResSupport=By.xpath("//label[normalize-space()='One-time payment ($)']");
    private By monthlyReqResSupport=By.xpath("//label[normalize-space()='Monthly support ($5/month)']");


    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //Actions
    public String getHomePageTagLine(){
        WebElement eleHomePageTagLine=driver.findElement(homePageTagLine);
        return eleHomePageTagLine.getText().trim();
    }

    public List<String> getUniqueHTTPMethods() {
        List<WebElement> elements = driver.findElements(endPoints);
        List<String> uniqueEndPointsMethods = new ArrayList<>(List.of());
        for (WebElement element : elements) {
            uniqueEndPointsMethods.add(element.getDomAttribute("data-http"));
        }
        Set<String> set = new HashSet<>(uniqueEndPointsMethods);
        return new ArrayList<>(set);
    }

    public WebElement getActiveEndPoint(){
        return driver.findElement(activeEndPointListUsers);
    }

    public WebElement getDisplayedRequestDetails(){
        return driver.findElement(defaultEndPointRequest);
    }

    public WebElement getDisplayedRequestDetailsSingleUserNotFound(){
        return driver.findElement(singleUserNotFoundRequest);
    }

    public WebElement getResponseStatusCode(){
        return driver.findElement(endPointResponseStatusCode);
    }

    public WebElement getResponseBody(){
        return driver.findElement(outputResponseBody);
    }

    public WebElement singleUserNotFoundClick(){
        return driver.findElement(singleUserNotFound);
    }

    public Boolean reqresButtonIsAvailable(){
        return driver.findElement(reqresButton).isEnabled();
    }

    public Boolean upgradeButtonIsAvailable(){
        return driver.findElement(upgradeButton).isEnabled();
    }

    public WebElement reqresButtonClickable(){
        return driver.findElement(reqresButton);
    }

    public Boolean regresPageTitleIsDisplayed(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(reqresPage));
        return driver.findElement(reqresPage).isDisplayed();
    }

    public Boolean oneTimeReqResSupportIsEnabled(){
        return driver.findElement(oneTimeReqResSupport).isEnabled();
    }

    public Boolean monthlyReqResSupportIsEnabled(){
        return driver.findElement(monthlyReqResSupport).isEnabled();
    }


}
