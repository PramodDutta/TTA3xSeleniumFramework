package com.thetestingacademy.utils;
import com.thetestingacademy.driver.DriverManagerTL;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
public class ScreenShotListener implements ITestListener{

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.addAttachment(result.getTestName(),new ByteArrayInputStream(((TakesScreenshot)DriverManagerTL.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }


}
