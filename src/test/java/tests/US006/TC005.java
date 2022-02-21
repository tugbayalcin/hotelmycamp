package tests.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC005 extends TestBaseRapor {


    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();


    @Test
    public void test05() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("TC005","Hotel Room Eklendigi Test Edildi");

        hotelRoomsPage.managerLoginHotelRoomPages();

        hotelRoomsPage.hotelManagementLinki.click();

        hotelRoomsPage.hotelRoomsLinki.click();

        hotelRoomsPage.listOfHotelRoomSayfasindakiNameBox.sendKeys("Samet's King Room");

        hotelRoomsPage.searchButonu.click();

        Thread.sleep(3000);

        String otelOdasiIsmi="Samet's King Room";
        String webTableStringOlarak=hotelRoomsPage.bodydekiTumDatalarListElementi.getText();

        Assert.assertEquals(otelOdasiIsmi,webTableStringOlarak);

        extentTest.info("Eklenen Oda Goruntulendi");

        ReusableMethods.getScreenShots("TC005","target/screenShots/US006");



    }


}
