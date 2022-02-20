package tests.US008;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC002 extends TestBaseRapor {

    Select select;
    @Test
    public void testCase2() throws InterruptedException {
        extentTest=extentReports.createTest("TC002","Hotel Management menusundeki List Of Reservations goruntulenmeli");
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
        roomReservationsPage.roomReservationsList.click();
        extentTest.info("Room Reservations List tiklandi");
        WebElement actualListOfReservations=roomReservationsPage.listOfReservations;
        Assert.assertTrue(actualListOfReservations.isDisplayed());
        extentTest.pass("List Of Reservations yazisi goruntulendi");


         Driver.closeDriver();
    }

}
