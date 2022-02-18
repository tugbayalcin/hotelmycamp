package tests.US009;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import static utilities.ObjectInitialiser.*;

public class TC002 {

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void testCase2() throws InterruptedException {


        roomReservationsPage.roomReservationsGiris();




        js.executeScript("scroll(0, 250);");

        roomReservationsPage.ContactPhoneBox.sendKeys("(312) 321-3211");


        js.executeScript("arguments[0].scrollBy(500,0);", roomReservationsPage.reservationsListSagaKaydir);
        ReusableMethods.waitFor(1);
        roomReservationsPage.searchButon.click();
        ReusableMethods.waitFor(2);
        roomReservationsPage.detailsButon.click();
        ReusableMethods.waitFor(1);

        roomReservationsPage.createHotelRoomReservation();

        Assert.assertTrue(roomReservationsPage.roomSuccesfullyYazisi.isDisplayed());
         Driver.closeDriver();
    }

}
