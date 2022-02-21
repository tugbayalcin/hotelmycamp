package tests.US006;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC003 extends TestBaseRapor {

    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();

    @Test
    public void tc03() throws InterruptedException {
        extentTest=extentReports.createTest("TC003","Create Hotel Room Yazisi Goruntulendi");

        hotelRoomsPage.managerLoginHotelRoomPages();

        hotelRoomsPage.hotelManagementLinki.click();
        hotelRoomsPage.hotelRoomsLinki.click();
        hotelRoomsPage.addHotelRoomsButonu.click();

        Assert.assertTrue(hotelRoomsPage.createHotelroomYazisiElementi.isDisplayed());

        extentTest.info("yazi goruntulendi");

        //3-Gerekli Bilgileri Girerek Yeni Otel Odası Oluşturur.------------------

        //hangi otele oda eklenecekse dropdowndan dan o secilir

        Select select=new Select(hotelRoomsPage.idHotelDropDownButonu);
        select.selectByVisibleText("SAMET OTEL");

        Actions actions=new Actions(Driver.getDriver());

        //eklenecek otel odasinin kodu, ismi, lokasyonu, aciklamalari ve ucreti girilir
        actions.click(hotelRoomsPage.ddCodeBox)
                .sendKeys("12345"+ Keys.TAB)
                .sendKeys("Team11"+Keys.TAB)
                .sendKeys("izmir"+Keys.TAB).perform();

        actions.click(hotelRoomsPage.descriptionArea)
                .sendKeys("otel odasi hakkinda aciklamalar").perform();
        actions.click(hotelRoomsPage.ddPriceBox)
                .sendKeys("750").perform();

        //eklenecek oda turunu dropdown dan  secilir
        select=new Select(hotelRoomsPage.ddRoomTypeBox);
        select.selectByVisibleText("King");

        //yetiskin sayisi cocuk sayisi girildikten sonra onay kutusu tiklanir
        actions.click(hotelRoomsPage.ddMaxAdultcountBox)
                .sendKeys("2"+Keys.TAB)
                .sendKeys("4"+Keys.TAB+Keys.SPACE).perform();

        Assert.assertTrue(hotelRoomsPage.approvedCheckBox.isDisplayed());

        extentTest.info("Check Box Goruntulendi");










    }







}
