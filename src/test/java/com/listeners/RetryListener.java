package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    int counter=0;
    int limit=3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter < limit)
        {
            counter++;
            return true;
        }
        return false;
    }
}
