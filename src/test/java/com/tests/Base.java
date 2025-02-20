package com.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Base {
    public static WebDriver driver;

    public static void failedTest(){
        File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile,new File("//src//test//java//com//screenshots"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
