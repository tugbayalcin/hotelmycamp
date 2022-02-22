package tests.US004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.HotelListPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC001 extends TestBaseRapor {
    AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
    LoginPage loginPage = new LoginPage();
    HotelListPage hotelListPage = new HotelListPage();

    @Test
    public void test01() {
        extentTest=extentReports.createTest("TC001","list of user yazisi goruntulenmeli");
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
        extentTest.info("giris yapildi");
        //6-Yönetici olarak giriş yapıldıgını test edelim.
        Assert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed());
          extentTest.info("list of user yasisi goruntulendi");
       // Driver.closeDriver();

    }

}

