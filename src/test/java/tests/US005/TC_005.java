package tests.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AnaSayfaPage;
import pages.HotelListPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_005  extends TestBaseRapor {
    AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
    LoginPage loginPage=new LoginPage();
    HotelListPage hotelListPage=new HotelListPage();
    ReusableMethods reusableMethods=new ReusableMethods();
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("US-005-TC005","Edit hotel sayfasının kontrol Testi");

        // 1-Yönetici olarak  https://www.hotelmycamp.com/ Url ile giriş yapılır
        reusableMethods.yöneticiGiris();
        extentTest.info("yönetici olarak giriş yapıldı");


        //2-LIST OF USERS yazısı görüntülendi
        softAssert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed(),"listofUser görüntülenmiyor");

        //3- Hotel Management buttonuna tıklanır
        hotelListPage.hotelManagementButonu.click();

        //4- Hotel List butonuna tıklanır
        hotelListPage.hotelListButonu.click();

        //5-LIST OF HOTELS yazısı görüntülendi
        softAssert.assertTrue(hotelListPage.listOfHotelsYazısı.isDisplayed(),"listofhotelyazısı görüntülenmiyor");
        extentTest.info("List of Hotels sayfasına ulaşıldı");

        //6-işlem yapılacak olan otele ait DETAILS butonuna tıklanır.
        hotelListPage.listOfHotelsDetailsButonu.click();

        //7-işlem yapılacak olan sayfada "Edit Hotel" yazısı görüntülenir
        reusableMethods.switchToWindow("Admin - Edit Hotel");
        softAssert.assertEquals(hotelListPage.EditHotelYazısı.getText(), "Edit Hotel","Edithotelyazısı goruntulenmıyor");
        Thread.sleep(3000);
        extentTest.info("Edit Hotel  sayfasına ulaşıldı");


        //8-Edit Hotel Yazısı altındaki General Data  butonu tıklanır.Çalışır oldugu görüntülenir
        hotelListPage.EditHotelGeneralDataButonu.click();
        softAssert.assertTrue(hotelListPage.EditHotelGeneralDataButonu.isDisplayed(),"edıthotelGeneralButonu goruntuleneemıyor");

        //9-Edit Hotel Yazısı altındaki Photos butonu tıklanır.Çalışır oldugu görüntülenir
        hotelListPage.EditHotelPhotosButonu.click();
        softAssert.assertTrue(hotelListPage.EditHotelPhotosButtonuSecilimi.isDisplayed(),"Edit hotel photos buttonu goruntulenmıyr");

        //10-Edit Hotel Yazısı altındaki Properties  butonu tıklanır.Çalışır oldugu görüntülenir
        hotelListPage.EditHotelPropertiesButonu.click();
        softAssert.assertTrue(hotelListPage.EditHotelPropertiesButonu.isDisplayed(),"edit hotel properties butonu goruntulenemıyor");
        softAssert.assertAll();
        extentTest.pass("Edit hotel sayfası çalışıyor oldugu dogrulandı");


    }
    }
