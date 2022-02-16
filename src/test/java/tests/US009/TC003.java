package tests.US009;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC003 {

    @Test
    public void testCase3() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        loginPage.GirisLoginButon.click();
        roomReservationsPage.hotelManagementList.click();
        roomReservationsPage.roomReservationsList.click();

        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0, 250);");

        roomReservationsPage.ContactPhoneBox.sendKeys("(312) 321-3211");
        Thread.sleep(1000);

        js.executeScript("arguments[0].scrollBy(500,0);", roomReservationsPage.reservationsListSagaKaydir);
        Thread.sleep(1000);
        roomReservationsPage.searchButon.click();
        Thread.sleep(1500);
        roomReservationsPage.detailsButon.click();
        Thread.sleep(500);

        roomReservationsPage.propertiesButon.click();
        roomReservationsPage.codeBox.clear();
        roomReservationsPage.valueBox.clear();
        roomReservationsPage.codeBox.sendKeys("111"+ Keys.TAB+"value");

        roomReservationsPage.updateButon.click();
        WebElement actual=roomReservationsPage.updateSuccesfullyElementi;

        Thread.sleep(1500);

        Assert.assertTrue(roomReservationsPage.updateSuccesfullyElementi.isDisplayed());
        Thread.sleep(1500);
        roomReservationsPage.updateSuccesfullyOk.click();

        Driver.closeDriver();
    }

}
