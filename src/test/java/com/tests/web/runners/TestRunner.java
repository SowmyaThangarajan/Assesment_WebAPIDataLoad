package com.tests.web.runners;

import io.cucumber.testng.*;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.image.PackedColorModel;

@CucumberOptions(features = "src/test/java/com/tests/web/features",
                glue={"com.tests.web.stepDefinitions"},
                plugin = {"pretty"//,"html:target/cucumber-reports","json:target/cucumber.json"
                        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                monochrome = true,
                publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    /*private TestNGCucumberRunner testNGCucumberRunner;

    @Test(groups={"cucumber"}, description = "Cucumber features", dataProvider = "features")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper){
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] features(){
        return this.testNGCucumberRunner==null? new Object[0][0]:this.testNGCucumberRunner.provideScenarios();
    }

    @BeforeClass(alwaysRun = true)
    public void setupClass(ITestContext context){
        this.testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        if(this.testNGCucumberRunner!=null) {
            this.testNGCucumberRunner.finish();
        }
    }*/

    /*@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }*/

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
