package tests.US007;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC004 extends TestBaseRapor {
    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
    ReusableMethods reusableMethods=new ReusableMethods();

    @Test
    public void TC004() throws IOException {
        //1-https://www.hotelmycamp.com/ Url ile giris yapılır
        //2-Login butonuna tıklandı
        //3-Username girildi
        //4-Password girildi
        //5-Login butonuna basıldı
        //6-Hotel Management listesinden Hotel Rooms tıklanır
        //7-LIST OF HOTELROOMS yazısı görüntülendi
        //8-Silmek istediği data üzerinde bulunan DETAILS butonuna tıklanır.
        //9-Silme işlemi yapılcak olan sayfada  "Edit Hotelroom" yazısı görüntülenir
        //10-Mevcut tablodaki tüm rezervasyon bilgileri silinir
        //11-İşlem yapılacak sayfanın en alt ksımına inilir.
        //12-DELETE  butonuna tıklanır
        //13-"Would you like to continue? Yazısı görüntülendiği doğrulanır
        //14-Uyarı penceresinde OK butonuna tıklanır
        //15-Silme işlemi sonunda "HotelRoom successfully deleted"yazısı görüntülendiği doğrulanır

        extentTest=extentReports.createTest("TC004","Oda silme islemi yapildigi goruntulenmeli," +
                "HotelRoom successfully deleted yazisi gorulmeli");
        hotelRoomsPage.managerLoginHotelRoomPages();

        hotelRoomsPage.hotelManagementLinki.click();
        ReusableMethods.waitFor(2);
        hotelRoomsPage.hotelRoomsLinki.click();
        ReusableMethods.waitFor(2);
        hotelRoomsPage.detailsRnd().click();

        Assert.assertTrue(hotelRoomsPage.editHotelRoomYazisi.isDisplayed());
        System.out.println("Edit hotel rooms yazisi görüntülendi");

        Select select=new Select(hotelRoomsPage.ddHotelLink);
        select.selectByIndex(0);
        ReusableMethods.waitFor(2);
        hotelRoomsPage.ddCodeBox.clear();
        hotelRoomsPage.ddNameBox.clear();
        ReusableMethods.waitFor(2);
        hotelRoomsPage.ddLocationBox.clear();
        ReusableMethods.waitFor(3);
        hotelRoomsPage.ddDescriptionArea.clear();
        ReusableMethods.waitFor(3);

        hotelRoomsPage.ddPriceBox.clear();
        Select roomtype =new Select(hotelRoomsPage.ddRoomTypeBox);
        roomtype.selectByIndex(0);
        hotelRoomsPage.ddMaxAdultcountBox.clear();
        hotelRoomsPage.ddMaxChildrenCountbox.clear();
        if(hotelRoomsPage.ddIsAvaliableCheckBox.isSelected()){
            hotelRoomsPage.ddIsAvaliableCheckBox.click();
        }
        hotelRoomsPage.deleteButonu.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(hotelRoomsPage.wouldYouLikeToContinueYazisi.isDisplayed());
        hotelRoomsPage.deleteOkButonu.click();

        Assert.assertTrue(hotelRoomsPage.error.isDisplayed());
        ReusableMethods.waitFor(2);
        String expectedText="The room was deleted succesfully";
        Assert.assertEquals(hotelRoomsPage.error.getText(), expectedText);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(hotelRoomsPage.error.getText(),expectedText);
        ReusableMethods.waitFor(10);
        ReusableMethods.getScreenShots("Couldn't delete room","target/screenshot/US004");
        extentTest.fail("Oda silme islemi yapılamadı");

    }

}
