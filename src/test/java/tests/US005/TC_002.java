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

public class TC_002  extends TestBaseRapor {
    AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
    LoginPage loginPage=new LoginPage();
    HotelListPage hotelListPage=new HotelListPage();
    ReusableMethods reusableMethods=new ReusableMethods();
    SoftAssert softAssert=new SoftAssert();


    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("US-005-TC002","Otel Listesi sayfasının kontrol Testi");




    // 1-Yönetici olarak  https://www.hotelmycamp.com/ Url ile giriş yapılır
        reusableMethods.yöneticiGiris();

    //2-LIST OF USERS yazısı görüntülendi
        extentTest.info("yönetici olarak giriş yapıldı");

        Thread.sleep(2000);
        softAssert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed());
    //3- Hotel Management buttonuna tıklanır
        hotelListPage.hotelManagementButonu.click();
    //4- Hotel List butonuna tıklanır
        Thread.sleep(2000);

        hotelListPage.hotelListButonu.click();
    //5-LIST OF HOTELS yazısı görüntülendi
        Thread.sleep(2000);

        softAssert.assertTrue(hotelListPage.listOfHotelsYazısı.isDisplayed());
        extentTest.info("List of Hotels sayfasına ulaşıldı");


        //6-Oda listesinde sayfalar arasında geçiş yapıldıgı görüntülenir
        Thread.sleep(2000);
        hotelListPage.listOfHotelsİleriButonu.click();



      //7-Arama yapılır , SEARCH butonuna tıklanır
        hotelListPage.listOfHotelsSearchIDHotelBox.sendKeys("1382");
        Thread.sleep(2000);
        hotelListPage.listOfHotelsSearchButonu.click();

        //8-girilen bilgiler dogrultusunda tanımlı olan oda görüntülenir
        Thread.sleep(2000);
        softAssert.assertTrue(hotelListPage.EditHotelSecilenOtelAdı.isDisplayed());

        //9- details butonlarının çalıştığını test edelim.


          hotelListPage.listOfHotelsDetailsButonu.click();
          reusableMethods.switchToWindow("Admin - Edit Hotel");
         String edithotelYAzısı=hotelListPage.EditHotelYazısı.getText();
         String expectedEditYazısı="Edit Hotel";
        Thread.sleep(2000);

        softAssert.assertEquals(edithotelYAzısı,expectedEditYazısı);

        softAssert.assertAll();
        extentTest.pass("Otel Listesi Sayfası çalısıyor oldugu dogrulandı");


    }



}
