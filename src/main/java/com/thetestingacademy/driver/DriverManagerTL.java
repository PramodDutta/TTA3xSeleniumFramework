package com.thetestingacademy.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class DriverManagerTL {
    // Thread Local - Java

    static WebDriver driver;
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void unload(){
        dr.remove();
    }

    @BeforeMethod
    public static void init(){
        if(getDriver() == null){
            // TODO #1 - Need to make it support for Firefox, Edge, Safari, and IE
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            setDriver(new ChromeDriver(options));
        }
    }


    @AfterMethod
    public static void down(){
        if(getDriver()!= null){
            getDriver().quit();
        }

    }







}
