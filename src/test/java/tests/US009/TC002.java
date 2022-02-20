package tests.US009;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.ObjectInitialiser.*;

public class TC002 extends TestBaseRapor {

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void testCase2() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("TC002","Reservation kayit update etmeli");
        roomReservationsPage.roomReservationsGiris();

        extentTest.info("giris yapildi");


        js.executeScript("scroll(0, 250);");

        roomReservationsPage.ContactPhoneBox.sendKeys("(312) 321-3211");


        js.executeScript("arguments[0].scrollBy(500,0);", roomReservationsPage.reservationsListSagaKaydir);
        ReusableMethods.waitFor(1);
        roomReservationsPage.searchButon.click();
        ReusableMethods.waitFor(2);
        roomReservationsPage.detailsButon.click();
        ReusableMethods.waitFor(1);

        extentTest.info("room reservations details buton tiklandi");

        roomReservationsPage.createHotelRoomReservation();

     //   Driver.getDriver().switchTo().newWindow(WindowType.TAB); (WindowType.WINDOW)

        ReusableMethods.getScreenShots("TC002","target/screenShot/US009-");


        Assert.assertTrue(roomReservationsPage.roomSuccesfullyYazisi.isDisplayed());
        extentTest.pass("Room reservations Succesfully yazisi goruntulendi");
   //      Driver.closeDriver();
    }

}
