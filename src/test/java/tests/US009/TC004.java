package tests.US009;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Driver;
import static utilities.ObjectInitialiser.*;

public class TC004 {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void testCase5() throws InterruptedException {



        roomReservationsPage.roomReservationsGiris();


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
        Assert.assertTrue(roomReservationsPage.roomSuccesfullyYazisi.isDisplayed());

        Driver.closeDriver();
    }

}
