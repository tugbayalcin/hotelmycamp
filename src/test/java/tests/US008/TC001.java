package tests.US008;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC001 extends TestBaseRapor {

    @Test
    public void testCase1() throws InterruptedException {
        extentTest=extentReports.createTest("TC001","Hotel Management tiklanmali");
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage=new RoomReservationsPage();
        LoginPage loginPage=new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        loginPage.GirisLoginButon.click();
        extentTest.info("Giris butonu tiklandi");
        roomReservationsPage.hotelManagementList.click();
        extentTest.info("Hotel Management tiklandi");

        Driver.closeDriver();


        Driver.closeDriver();

    }
}
