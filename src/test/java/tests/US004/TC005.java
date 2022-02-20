package tests.US004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AnaSayfaPage;
import pages.HotelListPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC005 extends TestBaseRapor {
    AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
    LoginPage loginPage = new LoginPage();
    HotelListPage hotelListPage = new HotelListPage();

    @Test
    public void test01() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("TC005","Hotel was inserted successfully goruldu");
        //1-https://www.hotelmycamp.com/ Url ile giris yapılır
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        //2-Login butonuna tıklandı
        anaSayfaPage.mainLoginLinki.click();
        //3-Username girildi
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        //4-Password girildi
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        //5-Login butonuna basıldı
        loginPage.GirisLoginButon.click();
        //6-Yönetici olarak giriş yapıldıgını test edelim.
        Assert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed());


        //7)sol taraftaki hotel management a tikla
        hotelListPage.hotelManagementButonu.click();
        //8)Acilan menuden hotel list e tikla
        hotelListPage.hotelListButonu.click();
        //9)List of hotels yazisi goruldugunu test et
        hotelListPage.listOfHotelsYazısı.click();
        Assert.assertTrue(hotelListPage.listOfHotelsYazısı.isDisplayed());
        //10)sol taraftaki Add Hotel butonuna tikla
        hotelListPage.ADDHOTELButonu.click();

        //11)Create hotel yazisi goruldugunu test et
        hotelListPage.CreateHotelButonu.click();
        Assert.assertTrue(hotelListPage.CreateHotelButonu.isDisplayed());

        //  11-ilgili alanlari  giriniz
        Actions action = new Actions(Driver.getDriver());
        action.click(hotelListPage.CreateHotelCodeButonu)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("Hotel Karen")
                .sendKeys(Keys.TAB)
                .sendKeys("Cikmaz Sokak no:4")
                .sendKeys(Keys.TAB)
                .sendKeys("211")
                .sendKeys(Keys.TAB)
                .sendKeys("dd@gmail.com").perform();


        // 16-IDGroup dan select group a tiklayiniz
        //  17-select group
        Select select = new Select(hotelListPage.CreateHotelIDGroupButonu);
        select.selectByIndex(2);



        //18-save butonuna tiklayin
  hotelListPage.CreateHotelSaveButonu.click();
       // ReusableMethods.getScreenShots("UsernamesS","target/screenShot/US004");

          Thread.sleep(5000);
       // 19-save isleminin sonunda "Hotel was inserted successfully" yazisinin  goruldugunu test et

        Assert.assertTrue(hotelListPage.MesajKutusuButonu.isDisplayed());

     hotelListPage.MesajOkButonu.click();
     extentTest.info("ok butonuna tiklanildi");

       // Driver.closeDriver();


    }
}