package com.listeners;

import com.tests.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("Test execution has started");
    }

    public void onTestSuccess(ITestResult result) { /* compiled code */ }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test execution has resulted in failure");
        Base.failedTest();
    }

    public void onTestSkipped(ITestResult result) { /* compiled code */ }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { /* compiled code */ }

    public void onTestFailedWithTimeout(ITestResult result) { /* compiled code */ }

    public void onStart(ITestContext context) { /* compiled code */ }

    public void onFinish(ITestContext context) { /* compiled code */ }
}
