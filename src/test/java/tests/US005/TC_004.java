package tests.US005;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AnaSayfaPage;
import pages.HotelListPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_004 extends TestBaseRapor {

    AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
    LoginPage loginPage=new LoginPage();
    HotelListPage hotelListPage=new HotelListPage();
    ReusableMethods reusableMethods=new ReusableMethods();
    SoftAssert softAssert=new SoftAssert();


    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("US-005-TC004","Otel silme  Testi");

        // 1-Yönetici olarak  https://www.hotelmycamp.com/ Url ile giriş yapılır
        reusableMethods.yöneticiGiris();
        extentTest.info("yönetici olarak giriş yapıldı");


        //2-LIST OF USERS yazısı görüntülendi
        softAssert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed());

        //3- Hotel Management buttonuna tıklanır
        hotelListPage.hotelManagementButonu.click();

        //4- Hotel List butonuna tıklanır
        hotelListPage.hotelListButonu.click();

        //5-LIST OF HOTELS yazısı görüntülendi
        softAssert.assertTrue(hotelListPage.listOfHotelsYazısı.isDisplayed());
        extentTest.info("List of Hotels sayfasına ulaşıldı");

        //6-Bilgilerini silmek istediğimiz otele ait DETAILS butonuna tıklanır.
        hotelListPage.ListOfHotelDetailsButonu.click();

        //7-Silme şlemi yapılacak olan sayfada "Edit Hotel" yazısı görüntülenir
        reusableMethods.switchToWindow("Admin - Edit Hotel");
        softAssert.assertEquals(hotelListPage.EditHotelYazısı.getText(),"Edit Hotel");
        Thread.sleep(3000);
        extentTest.info("Edit Hotel  sayfasına ulaşıldı");



        //8-Sayfanın en altına inilir
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hotelListPage.EditHotelDeleteButonu);

        //9-  Delete Hotel butonuna tıklanır
        Thread.sleep(2000);
        hotelListPage.EditHotelDeleteButonu.click();
        extentTest.info("Silme işlemi yapıldı");

        //10- Would You Like To Continue  yazısının cıktıgını goruntule
        Thread.sleep(2000);
        softAssert.assertTrue(hotelListPage.EditHotelWouldYouLikeToContinuePopUp.isDisplayed());


        //11-Uyarı penceresinde OK butonuna tıklanır
        Thread.sleep(2000);
        hotelListPage.EditHotelPopUpOkButonu.click();

        //12-Silme işlemi sonunda "Hotel successfully deleted"yazısı görüntülendiği doğrulanır
        softAssert.assertTrue(hotelListPage.EditHotelPopUp.isDisplayed());
        softAssert.assertAll();
        extentTest.pass("Otel bilgilerini silme işlemi dogrulandı");





    }
}
