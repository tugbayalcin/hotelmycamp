package tests.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.TestBaseRapor;

public class TC002 extends TestBaseRapor {

    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();

    @Test
    public void tc02() throws InterruptedException {
        extentTest=extentReports.createTest("TC002","tc02 testi basarili : list of hotel rooms yazisi goruntulendi");

        hotelRoomsPage.managerLoginHotelRoomPages();


        hotelRoomsPage.hotelManagementLinki.click();

        hotelRoomsPage.hotelRoomsLinki.click();

        Assert.assertTrue(hotelRoomsPage.listOfHotelRoomsYazisi.isDisplayed());

        extentTest.pass("list of hotel rooms goruntulendi");





    }











}
