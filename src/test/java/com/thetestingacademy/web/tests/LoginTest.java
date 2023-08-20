package com.thetestingacademy.web.tests;

import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.DashboardPage;
import com.thetestingacademy.pages.LoginPage;
import com.thetestingacademy.utils.ProperReader;
import com.thetestingacademy.utils.ScreenShotListener;
import com.thetestingacademy.web.testbase.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

@Listeners(ScreenShotListener.class)
public class LoginTest extends TestBase { // Inheritance


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Valid Credentials are working file")
    @Test(groups = {"P0", "negative"},priority = 1)
    public void testLoginNegative() throws Exception {
        // Navigate, Login to VWO and Assert
        // Abstraction
        DriverManagerTL.getDriver().get(ProperReader.readKey("url"));
        String expectResult = new LoginPage().loginToVWO(false).error_message_text();
        Assertions.assertThat(expectResult)
                .isNotBlank().isNotNull().contains(ProperReader.readKey("expected_error"));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Invalid Credentials are working file")
    @Test(groups = {"P0", "positive"},priority = 2)
    public void testLoginPositive() throws Exception {
        // Navigate, Login to VWO and Assert
        // Abstraction
        DriverManagerTL.getDriver().get(ProperReader.readKey("url"));
        DashboardPage dashboardPage = new LoginPage().loginToVWO(true).afterLogin();
        String expectResult = dashboardPage.loggedInUserName();
        Assertions.assertThat(expectResult)
                .isNotBlank().isNotNull().contains(ProperReader.readKey("expected_username"));

    }


}
