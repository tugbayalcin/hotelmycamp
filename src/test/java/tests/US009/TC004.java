package tests.US009;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC004 {

    @Test
    public void testCase5() throws InterruptedException {

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

        roomReservationsPage.adultAmountBox.clear();
        roomReservationsPage.adultAmountBox.sendKeys("5");
        roomReservationsPage.contactNameSurnameBox.clear();
        roomReservationsPage.contactNameSurnameBox.sendKeys("mehmet");

        Thread.sleep(1500);
        js.executeScript("scrollBy(0, 500);",roomReservationsPage.deleteButon);
        roomReservationsPage.deleteButon.click();
        Assert.assertTrue(roomReservationsPage.roomSuccesfullyYazisi.isDisplayed());

        Driver.closeDriver();
    }

}
