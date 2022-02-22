package tests.US007;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC005 extends TestBaseRapor {
    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
    ReusableMethods reusableMethods=new ReusableMethods();
    //1-https://www.hotelmycamp.com/ Url ile giris yapılır
    //2-Login butonuna tıklandı
    //3-Username girildi
    //4-Password girildi
    //5-Login butonuna basıldı
    //6-Hotel Management listesinden Hotel Rooms tıklanır
    //7-LIST OF HOTELROOMS yazısı görüntülendi

    //8-Silmek istediği data üzerinde bulunan DETAILS butonuna tıklanır.
    //9-Silme işlemi yapılcak olan sayfada  "Edit Hotelroom" yazısı görüntülenir
    //10-İşlem yapılacak sayfanın en alt ksımına inilir.
    //11-DELETE  butonuna tıklanır
    //12-"Would you like to continue? "Yazısı görüntülendiği doğrulanır
    //13-Uyarı penceresinde OK butonuna tıklanır
    //"14-Silme işleminin gerçekleşmediğini belirten"Error: Couldn't delete room :
    //please delete reservations for this room first"yazısı görüntülenmeli"

    @Test
    public void test005(){
        extentTest=extentReports.createTest("TC005","Oda bilgileri silinmeden oda silme islemi yapılmadigi goruntulenir");
     hotelRoomsPage.managerLoginHotelRoomPages();

     hotelRoomsPage.detailsButonu.click();
        Assert.assertTrue(hotelRoomsPage.editHotelRoomYazisi.isDisplayed());
        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        hotelRoomsPage.deleteButonu.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(hotelRoomsPage.wouldYouLikeToContinueYazisi.isDisplayed());
        ReusableMethods.waitFor(2);
        hotelRoomsPage.deleteOkButonu.click();
        Assert.assertTrue(hotelRoomsPage.error.isDisplayed());
        extentTest.pass("Oda silme islemi yapilamadi");



    }
}
