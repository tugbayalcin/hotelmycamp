package tests.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC002 {

    Select select;
    @Test
    public void testCase2() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("KullaniciUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("KullaniciPassword"));
        loginPage.GirisLoginButon.click();
        anaSayfaPage.anaSayfaHomeButon.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0, 250);",anaSayfaPage.anasayfaSayfaTamami);
        anaSayfaPage.anasayfaCheckinDateBox.clear();
        anaSayfaPage.anasayfaCheckinDateBox.sendKeys("2/24/2022");
        anaSayfaPage.anasayfaCheckoutDateBox.clear();
        anaSayfaPage.anasayfaCheckoutDateBox.sendKeys("2/29/2022");
        select=new Select(anaSayfaPage.anasayfaRoomDropdown);
        select.selectByVisibleText("Single");
        select=new Select(anaSayfaPage.anasayfaCustomerDropdown);
        select.selectByIndex(2);
        anaSayfaPage.anasayfaCheckAvailabilityButon.click();

         Driver.closeDriver();
    }

}
