package tests.US007;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC003 extends TestBaseRapor {
    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
    ReusableMethods reusableMethods=new ReusableMethods();


    @Test
    public void TC003() throws InterruptedException {
        //1-https://www.hotelmycamp.com/ Url ile giris yapılır
        //2-Login butonuna tıklandı
        //3-Username girildi
        //4-Password girildi
        //5-Login butonuna basıldı
        //6-Hotel Management listesinden Hotel Rooms tıklandı,
        //7-LIST OF HOTELROOMS yazısı görüntülendi
        //8-Bilgilerini değiştirmek istediği alanda DETAILS butonuna tıklanmalı
        //9-Değişiklik yapılacak olan sayfada "Edit Hotelroom" yazısı görüntülenmeli
        //10-Tüm değişiklikler ilgili alanlarda yapıldıktan sonra SAVE butonuna tıklanmalı
        //11-guncellemeler yapıldıktan sonra "HotelRoom was updated successfully" yazısı görüntülenmeli

        extentTest=extentReports.createTest("TC003","Girilen bilgilerin UPDATE edildigi goruntulenmeli");


        hotelRoomsPage.managerLoginHotelRoomPages();

        hotelRoomsPage.hotelManagementLinki.click();
        hotelRoomsPage.hotelRoomsLinki.click();
        Assert.assertTrue(hotelRoomsPage.listOfHotelRoomsYazisi.isDisplayed());
        hotelRoomsPage.detailsRnd().click();
        Assert.assertTrue(hotelRoomsPage.editHotelRoomYazisi.isDisplayed());

        Select hotelSelect=new Select(hotelRoomsPage.ddHotelLink);
        hotelSelect.selectByIndex(6);
        ReusableMethods.waitFor(2);
        hotelRoomsPage.ddCodeBox.clear();
        ReusableMethods.waitFor(2);
        hotelRoomsPage.ddCodeBox.sendKeys("1110");

        hotelRoomsPage.ddNameBox.clear();
        hotelRoomsPage.ddNameBox.sendKeys("Zühre Yıldız");
        ReusableMethods.waitFor(2);

        hotelRoomsPage.ddLocationBox.clear();
        hotelRoomsPage.ddLocationBox.sendKeys("Germany");
        ReusableMethods.waitFor(2);

        hotelRoomsPage.ddPriceBox.clear();
        hotelRoomsPage.ddPriceBox.sendKeys("100.000");
        ReusableMethods.waitFor(2);

        Select select=new Select(hotelRoomsPage.ddRoomTypeBox);
        select.selectByIndex(2);
        ReusableMethods.waitFor(2);

        hotelRoomsPage.ddMaxAdultcountBox.clear();
        hotelRoomsPage.ddMaxAdultcountBox.sendKeys("2");
        ReusableMethods.waitFor(2);

        hotelRoomsPage.ddMaxChildrenCountbox.clear();
        hotelRoomsPage.ddMaxChildrenCountbox.sendKeys("3");
        ReusableMethods.waitFor(2);

        if(!hotelRoomsPage.ddIsAvaliableCheckBox.isSelected()){
            hotelRoomsPage.ddIsAvaliableCheckBox.click();
        }

        hotelRoomsPage.ddSaveButonu.click();
        ReusableMethods.waitFor(2);
        String expectedText="HotelRoom was updated successfully";
        Assert.assertEquals(hotelRoomsPage.hotelRoomWasUpdatedSuccessfullyYazisi.getText(), expectedText);
        hotelRoomsPage.deleteOkButonu.click();
        ReusableMethods.waitFor(2);
        extentTest.pass("HotelRoom was updated successfully yazisi goruntulendi");



    }
}
