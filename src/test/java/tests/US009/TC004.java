package tests.US009;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

import static utilities.ObjectInitialiser.*;

public class TC004 extends TestBaseRapor {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void testCase4() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("TC004","Reservation delete edilmeli");

        roomReservationsPage.roomReservationsGiris();
        extentTest.info("giris yapildi");

        Thread.sleep(500);

        js.executeScript("scroll(0, 250);");

        roomReservationsPage.ContactPhoneBox.sendKeys("(312) 321-3211");
        Thread.sleep(1000);

        js.executeScript("arguments[0].scrollBy(500,0);", roomReservationsPage.reservationsListSagaKaydir);
        Thread.sleep(1000);
        roomReservationsPage.searchButon.click();
        Thread.sleep(1500);
        roomReservationsPage.detailsButon.click();

        roomReservationsPage.createHotelRoomReservation();

        Thread.sleep(1500);
        js.executeScript("scrollBy(0, 500);",roomReservationsPage.deleteButon);
        roomReservationsPage.deleteButon.click();
        extentTest.info("Delete butonu tiklandi");
        ReusableMethods.getScreenShots("TC004","target/screenShot/US009-");
        Assert.assertTrue(roomReservationsPage.roomSuccesfullyYazisi.isDisplayed());
        extentTest.pass("Delete Room Succesfully yazisi goruntulendi");
        Driver.closeDriver();
    }

}
