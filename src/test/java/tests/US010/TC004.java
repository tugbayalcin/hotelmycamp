package tests.US010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.HotelRoomsPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC004 extends TestBaseRapor {
    @Test
    public void test04(){

        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();

        extentTest=extentReports.createTest("TC004","Kullanıcı olarak başarılı bir şekilde log in yapabilme");

        //1- https://www.hotelmycamp.com/ URL adresine gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        //2- '"Log in" menüsünü locate ediniz ve "Log in" butonuna tıklayınız.
        anaSayfaPage.mainLoginLinki.click();
        extentTest.info("Main log in linki tıklandı");
        //3- Açılan sayfada "username" kutucuğuna "iyilmaz27", "Password" kutucuğuna "Deneme78." değerini giriniz.
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        //4- "Log in" butonunu locate ediniz ve tıklayınız ve "UserName : iyilmaz27" yazısının çıktığını test ediniz.
        loginPage.GirisLoginButon.click();
        extentTest.info("Giriş log in butonu tıklandı");
        Assert.assertTrue(loginPage.userNameiyilmaz27Yazısı.isDisplayed());
        extentTest.info("Giriş yapıldı");
        //5-"Log in" sayfasına geri geliniz ve "Create a new account" butonunun tıklanabilir olduğunu test ediniz.
        Driver.getDriver().navigate().back();
        Assert.assertTrue(loginPage.CreateNewAccountButonu.isEnabled());
        extentTest.info("Giriş yapıldı");
        Driver.closeDriver();
    }
}

