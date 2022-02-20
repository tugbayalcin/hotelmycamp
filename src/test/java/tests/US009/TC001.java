package tests.US009;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;
public class TC001 extends TestBaseRapor{

    @Test
    public void testCase1() throws InterruptedException {
        extentTest=extentReports.createTest("TC001","List reservation goruntuleme");
        roomReservationsPage.roomReservationsGiris();
        extentTest.info("giris yapildi");
        WebElement actualListOfReservations=roomReservationsPage.listOfReservations;
        Assert.assertTrue(actualListOfReservations.isDisplayed());
        extentTest.pass("List reservations goruntulendi");

  //      Driver.closeDriver();
    }
}
