package tests.US004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.HotelListPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC001 {
AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
    LoginPage loginPage=new LoginPage();
    HotelListPage hotelListPage=new HotelListPage();

    @Test
   public void test01(){

        //1-https://www.hotelmycamp.com/ Url ile giris yapılır
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        //2-Login butonuna tıklandı
        anaSayfaPage.mainLoginLinki.click();
        //3-Username girildi
        loginPage.loginUsernameBox.sendKeys(ConfigReader.getProperty("username"));
        //4-Password girildi
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("password"));
        //5-Login butonuna basıldı
        loginPage.girisLoginButon.click();
        //6-Yönetici olarak giriş yapıldıgını test edelim.
        Assert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed());


         //7)sol taraftaki hotel management a tikla

        //8)Acilan menuden hotel list e tikla
        //9)List of hotels yazisi goruldugunu test et

    }
}
