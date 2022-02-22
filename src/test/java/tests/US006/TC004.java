package tests.US006;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC004 extends TestBaseRapor {

    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();

    @Test
    public void test04() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("TC004"," Hotel Room Basariyla eklendi");

        hotelRoomsPage.managerLoginHotelRoomPages();

        hotelRoomsPage.hotelManagementLinki.click();

        hotelRoomsPage.hotelRoomsLinki.click();

        hotelRoomsPage.addHotelRoomsButonu.click();

        Select select=new Select(hotelRoomsPage.idHotelDropDownButonu);
        select.selectByVisibleText("SAMET OTEL");

        Actions actions=new Actions(Driver.getDriver());

        actions.click(hotelRoomsPage.ddCodeBox)
                .sendKeys("0004"+ Keys.TAB)
                .sendKeys("Samet's King Room"+Keys.TAB)
                .sendKeys("Ankara"+Keys.TAB).perform();

        actions.click(hotelRoomsPage.descriptionArea)
                .sendKeys("otel odasi hakkinda aciklamalar").perform();

        actions.click(hotelRoomsPage.ddPriceBox)
                .sendKeys("900").perform();

        //eklenecek oda turunu dropdown dan  secilir
        select=new Select(hotelRoomsPage.ddRoomTypeBox);
        select.selectByVisibleText("King");

        //yetiskin sayisi cocuk sayisi girildikten sonra onay kutusu tiklanir
        actions.click(hotelRoomsPage.ddMaxAdultcountBox)
                .sendKeys("2"+Keys.TAB)
                .sendKeys("4"+Keys.TAB+Keys.SPACE+Keys.PAGE_DOWN).perform();

        hotelRoomsPage.saveButonu.click();

        Thread.sleep(5000);

        Assert.assertFalse(hotelRoomsPage.hotelRoomBasariylaEklendiYazisi.isDisplayed());

        extentTest.info("Hotel Room Basariyla Eklendi Yazisi Goruntulendi");

        ReusableMethods.getScreenShots("Hotel Room Basariyla Eklendi Yazisi","target/screenShots/US006");

        hotelRoomsPage.alertOKButonu.click();



        actions.sendKeys(Keys.HOME).perform();
        hotelRoomsPage.hotelRoomsLinki.click();














    }


}
