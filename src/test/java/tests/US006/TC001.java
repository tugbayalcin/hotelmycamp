package tests.US006;


import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.hotelRoomsPage;


public class TC001 extends TestBaseRapor {


    @Test
    public void tc01() throws InterruptedException {

        extentTest=extentReports.createTest("TC001","List of User yazisi goruntulendi");

        hotelRoomsPage.managerLoginHotelRoomPages();

        extentTest.info("Yonetici olarak giris yapildi");

        Assert.assertTrue(hotelRoomsPage.listOfUsersYazisi.isDisplayed());

        extentTest.pass("List of User yazisi goruntulendi");

        Driver.closeDriver();



    }
}
