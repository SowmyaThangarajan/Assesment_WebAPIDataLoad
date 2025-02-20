package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tests.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    public void onStart(ITestContext context) {
        //extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\src\\report\\myExtentReport.html");
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\SparkReport\\SparkReport.html");

        extentSparkReporter.config().setDocumentTitle("Automation report for Web, API & DB tests");
        extentSparkReporter.config().setReportName("Functional tests");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Tester Name","Sowmya");
        extentReports.setSystemInfo("Browser Name","Chrome");
    }

    public void onTestSuccess(ITestResult testResult) {
        extentTest=extentReports.createTest(testResult.getName());
        extentTest.log(Status.PASS,"Test case PASSED is: "+testResult.getName() +" "+ testResult.getTestName() +" "+ testResult.getTestContext());
    }

    public void onTestFailure(ITestResult testResult) {
        extentTest=extentReports.createTest(testResult.getName());
        extentTest.log(Status.FAIL,"Test case FAILED is: "+testResult.getName());
        extentTest.log(Status.FAIL,"Test case FAILED. Reason is: "+testResult.getThrowable());
        //Base.failedTest();
    }

    public void onTestSkipped(ITestResult testResult) {
        extentTest=extentReports.createTest(testResult.getName());
        extentTest.log(Status.SKIP,"Test case SKIPPED is: "+testResult.getName());
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
